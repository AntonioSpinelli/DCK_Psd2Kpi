package com.ibm.psd2kpi.bean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.psd2kpi.dao.Psd2KeyPerformanceIndicatorLoggerDao;
import com.ibm.psd2kpi.dto.BaseResponse;
import com.ibm.psd2kpi.dto.KpiLogRequest;
import com.ibm.psd2kpi.dto.MovimentiCcRequest;
import com.ibm.psd2kpi.dto.MovimentiCcResponse;
import com.ibm.psd2kpi.util.KpiLogUtilities;

@RestController
@RequestMapping("/api/v1/kpipsd2")
public class Psd2KpiController {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
  @GetMapping("/test")
  public ResponseEntity<BaseResponse> kpipsd2(){

	  MovimentiCcRequest parameters = new MovimentiCcRequest();
		  parameters.setAbi(9999);
		  parameters.setCanale(31);
		  parameters.setCanaleMovimento(30);
		  parameters.setCategoriaMovimento(6);
		  parameters.setDataA(Calendar.getInstance());
		  parameters.setDataDa(Calendar.getInstance());
		  parameters.setGuid(UUID.randomUUID().toString());
		  parameters.setNumeroMovimenti(2);
		  parameters.setTipologia(20);
  
	  MovimentiCcResponse responseMov = new MovimentiCcResponse();
		  responseMov.setDescrizione("Test");
		  responseMov.setEsito(0);
		  responseMov.setGuid(UUID.randomUUID().toString());
  	  
	  KpiLogRequest request = KpiLogUtilities.getKpiLogTPRequest(parameters, responseMov, Calendar.getInstance(), (short)1, 10, "Test");
	  
	  	  BaseResponse baseResponse = inserNewLogImpl(request);
	  
	  return ResponseEntity.ok().body(baseResponse);
  }
  
  @PostMapping("/insertNewLog")
  public ResponseEntity<BaseResponse> insertNewLog(@RequestBody KpiLogRequest request){
	  
	  BaseResponse response = inserNewLogImpl(request);
	  
	  return ResponseEntity.ok().body(response);
  }
  
  
  private BaseResponse inserNewLogImpl(KpiLogRequest request) {
	  
	  BaseResponse response = new BaseResponse();

	  try {
		  Psd2KeyPerformanceIndicatorLoggerDao stm = new Psd2KeyPerformanceIndicatorLoggerDao();
		  String insertQuery = stm.getInsertQuery(request.getReqLayer());
		  
		  int esito = jdbcTemplate.update(insertQuery, new PreparedStatementSetter() {
			  public void setValues(PreparedStatement preparedStatement) throws SQLException {
		    		if (request.getReqLayer() == null) {
			    		preparedStatement.setInt(1, request.getAbi());
			    		preparedStatement.setInt(2, request.getCanale());
			    		preparedStatement.setInt(3, request.getIndTOperazione());
			    		preparedStatement.setTimestamp(4,  new Timestamp(request.getTsInizio().getTimeInMillis()));
			    		preparedStatement.setTimestamp(5, new Timestamp(request.getTsFine().getTimeInMillis()));
			    		preparedStatement.setString(6, request.getDescrizione());
			    		preparedStatement.setShort(7, request.getStep());
			    		preparedStatement.setShort(8, request.getEsito());
		    		} else {
		    			if(request.getReqLayer().length() > Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_REQ_LAYER_MAX_CHARS) {
		    				request.setReqLayer(request.getReqLayer().substring(0, Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_REQ_LAYER_MAX_CHARS));
		    			}
			    		preparedStatement.setInt(1, request.getAbi());
			    		preparedStatement.setInt(2, request.getCanale());
			    		preparedStatement.setInt(3, request.getIndTOperazione());
			    		preparedStatement.setTimestamp(4,  new Timestamp(request.getTsInizio().getTimeInMillis()));
			    		preparedStatement.setTimestamp(5, new Timestamp(request.getTsFine().getTimeInMillis()));
			    		preparedStatement.setString(6, request.getDescrizione());
			    		preparedStatement.setShort(7, request.getStep());
			    		preparedStatement.setShort(8, request.getEsito());
			    		preparedStatement.setString(9, request.getReqLayer());
		    			
		    		}				  
		    		}
				});
		  
		  if (esito>0) {
		  	  response.setDescrizione("Servizio eseguito correttamente");
		  	  response.setEsito(0);
		  	  response.setGuid(request.getGuid());  
		  }else {
			  response.setDescrizione("Servizio in errore");
		  	  response.setEsito(2);
		  	  response.setGuid(request.getGuid()); 
		  }
		  			  
	  } catch (Exception e) {
			e.printStackTrace();
	  }
	  
 
  	  
  	  return response;
  }
  
}

