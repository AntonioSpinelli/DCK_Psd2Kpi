package com.ibm.psd2kpi.dao;

public class Psd2KeyPerformanceIndicatorLoggerDao {
		
	public static final String TABLE_PSD2_KPI_LOG_NAME = "PSD2.TB_NW_PSD2_KPI_LOG";
	public static final int COLUMN_REQ_LAYER_MAX_CHARS = 10;
	
	private static final String COLUMN_COD_AZ_OPERANTE = "COD_AZ_OPERANTE";
	private static final String COLUMN_COD_CANALE = "COD_CANALE";
	private static final String COLUMN_IND_T_OPERAZIONE = "IND_T_OPERAZIONE";
	private static final String COLUMN_TS_INIZIO = "TS_INIZIO";
	private static final String COLUMN_TS_FINE = "TS_FINE";
	private static final String COLUMN_DESCRIZIONE = "DESCRIZIONE";
	private static final String COLUMN_STEP = "STEP";
	private static final String COLUMN_ESITO = "ESITO";
	private static final String COLUMN_REQ_LAYER = "REQ_LAYER";	
		
	
	private static final String PSD2_KPI_LOG_ADD_NEW_LOG = 
		    "INSERT INTO " + 
		    	Psd2KeyPerformanceIndicatorLoggerDao.TABLE_PSD2_KPI_LOG_NAME + 
		    "( " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_COD_AZ_OPERANTE 	+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_COD_CANALE 			+ ", " +	
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_IND_T_OPERAZIONE 	+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_TS_INIZIO 			+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_TS_FINE 			+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_DESCRIZIONE 		+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_STEP 				+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_ESITO 				+ ""   +
		    ") VALUES (" + 
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?"   +
		    ")";
	
	private static final String PSD2_KPI_LOG_ADD_NEW_LOG_WITH_REQ = 
		    "INSERT INTO " + 
		    	Psd2KeyPerformanceIndicatorLoggerDao.TABLE_PSD2_KPI_LOG_NAME + 
		    "( " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_COD_AZ_OPERANTE 	+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_COD_CANALE 			+ ", " +	
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_IND_T_OPERAZIONE 	+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_TS_INIZIO 			+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_TS_FINE 			+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_DESCRIZIONE 		+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_STEP 				+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_ESITO 				+ ", " +
		    	Psd2KeyPerformanceIndicatorLoggerDao.COLUMN_REQ_LAYER			+ ""   +
		    ") VALUES (" + 
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?, " +
		    	" ?"   +
		    ")";			
	
	public String getInsertQuery (//int codAzOperante, int codCanale, int indTOperazione, Timestamp tsInizio,
			//Timestamp tsFine, String descrizione, short step, short esito, 
			String reqLayer) throws Exception{
//		Connection conn = null;
		String stm = null;
//		int numberOfRowInserted;
//		Boolean result = null;
		
//		try{
        				
    		
    		if (reqLayer == null) {
//	    		stm = conn.prepareStatement(Psd2KeyPerformanceIndicatorLoggerDao.PSD2_KPI_LOG_ADD_NEW_LOG);
    			stm = Psd2KeyPerformanceIndicatorLoggerDao.PSD2_KPI_LOG_ADD_NEW_LOG;
//	    		stm.setInt(1, codAzOperante);
//	    		stm.setInt(2, codCanale);
//	    		stm.setInt(3, indTOperazione);
//	    		stm.setTimestamp(4, tsInizio);
//	    		stm.setTimestamp(5, tsFine);
//	    		stm.setString(6, descrizione);
//	    		stm.setShort(7, step);
//	    		stm.setShort(8, esito);
    		} else {
//	    		stm = conn.prepareStatement(Psd2KeyPerformanceIndicatorLoggerDao.PSD2_KPI_LOG_ADD_NEW_LOG_WITH_REQ);
    			stm = Psd2KeyPerformanceIndicatorLoggerDao.PSD2_KPI_LOG_ADD_NEW_LOG_WITH_REQ;
//	    		stm.setInt(1, codAzOperante);
//	    		stm.setInt(2, codCanale);
//	    		stm.setInt(3, indTOperazione);
//	    		stm.setTimestamp(4, tsInizio);
//	    		stm.setTimestamp(5, tsFine);
//	    		stm.setString(6, descrizione);
//	    		stm.setShort(7, step);
//	    		stm.setShort(8, esito);
//	    		stm.setString(9, reqLayer);
    			
    		}
    					
//   		numberOfRowInserted = stm.executeUpdate();
    		
//    		if(numberOfRowInserted <= 0) {
//    			result = new Boolean(false);  	// no db manipulation
//    		} else {
//    			result = new Boolean(true);		// success
//    		}
    		
//    		conn.commit();
    		
//        }finally {
//        	cleanUp(null, stm, conn);
//		}
		
		return stm;		
	}

	
}
