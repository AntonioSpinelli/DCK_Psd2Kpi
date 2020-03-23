FROM open-liberty:springBoot2
COPY --chown=1001:0 target/psd2kpi-0.1.0.jar /config/dropins/spring/psd2kpi-0.1.0.jar
COPY --chown=1001:0 target/liberty/wlp/templates/servers/springBoot2/server.xml /config/