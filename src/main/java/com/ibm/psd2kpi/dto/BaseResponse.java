
package com.ibm.psd2kpi.dto;

import java.io.Serializable;


public class BaseResponse implements Serializable {

	private static final long serialVersionUID = -7817941660266079476L;
	
	protected int esito;
    protected String descrizione;
    protected String guid;

    /**
     * Recupera il valore della proprietà esito.
     * 
     */
    public int getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     */
    public void setEsito(int value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà descrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta il valore della proprietà descrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizione(String value) {
        this.descrizione = value;
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
