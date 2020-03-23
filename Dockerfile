# Stage and thin the application 
FROM open-liberty:springBoot2 as staging
COPY --chown=1001:0 target/psd2kpi-0.1.0.jar \
                    /staging/fat-psd2kpi-0.1.0.jar         
# end::copyJar[]
	
# tag::springBootUtility[]
RUN springBootUtility thin \
 --sourceAppPath=/staging/fat-psd2kpi-0.1.0.jar \
 --targetThinAppPath=/staging/thin-psd2kpi-0.1.0.jar \
 --targetLibCachePath=/staging/lib.index.cache
# end::springBootUtility[]

USER 1001

# Build the image
FROM open-liberty:springBoot2
ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  org.opencontainers.image.authors="Antonio Spinelli" \
  org.opencontainers.image.vendor="Open Liberty" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="hello app" \
  version="$VERSION-$REVISION" \
  summary="The KPI PSD2 APPLICATION" \
  description="This image contains the kpi psd2 application running with the Open Liberty runtime."

# tag::serverXml[]
RUN cp /opt/ol/wlp/templates/servers/springBoot2/server.xml /config/server.xml
# end::serverXml[]

# tag::libcache[]
COPY --chown=1001:0 --from=staging /staging/lib.index.cache /lib.index.cache
# end::libcache[]
# tag::thinjar[]
COPY --chown=1001:0 --from=staging /staging/thin-psd2kpi-0.1.0.jar \
                    /config/dropins/spring/thin-psd2kpi-0.1.0.jar
# end::thinjar[]

RUN configure.sh 

USER 1001
