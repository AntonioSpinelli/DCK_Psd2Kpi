package com.ibm.psd2kpi.util;

import java.util.Calendar;

import com.ibm.psd2kpi.dto.BaseRequest;
import com.ibm.psd2kpi.dto.BaseResponse;
import com.ibm.psd2kpi.dto.KpiLogRequest;


public class KpiLogUtilities {
	
	public static synchronized  KpiLogRequest getKpiLogTPRequest(BaseRequest request, BaseResponse response, Calendar tsInizio, short step, int tipoOperazione, String decrizione){
		KpiLogRequest kpiRequest = new KpiLogRequest();
    	kpiRequest.setIndTOperazione(tipoOperazione);
    	kpiRequest.setDescrizione(decrizione);
    	kpiRequest.setStep(step);
    	kpiRequest.setTsInizio(tsInizio);
    	kpiRequest.setReqLayer("BE");
    	kpiRequest.setAbi(request.getAbi());
		kpiRequest.setCanale(request.getCanale());
		kpiRequest.setTsFine(Calendar.getInstance());
		kpiRequest.setEsito(response != null? (short) response.getEsito() : (short)2);
		kpiRequest.setGuid(request.getGuid());
		
		kpiRequest.setBustaInput(request);
		kpiRequest.setBustaOutput(response);
		
		return kpiRequest;
	}

}
