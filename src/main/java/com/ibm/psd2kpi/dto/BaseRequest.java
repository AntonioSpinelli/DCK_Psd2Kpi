package com.ibm.psd2kpi.dto;

import java.io.Serializable;

public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 1253968994190233761L;
	
    protected int abi;
    protected int canale;
    protected String guid;

    /**
     * Recupera il valore della proprietà abi.
     * 
     */
    public int getAbi() {
        return abi;
    }

    /**
     * Imposta il valore della proprietà abi.
     * 
     */
    public void setAbi(int value) {
        this.abi = value;
    }

    /**
     * Recupera il valore della proprietà canale.
     * 
     */
    public int getCanale() {
        return canale;
    }

    /**
     * Imposta il valore della proprietà canale.
     * 
     */
    public void setCanale(int value) {
        this.canale = value;
    }

    /**
     * Recupera il valore della proprietà guid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Imposta il valore della proprietà guid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid(String value) {
        this.guid = value;
    }

}
