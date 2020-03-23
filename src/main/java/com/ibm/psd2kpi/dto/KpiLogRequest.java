
package com.ibm.psd2kpi.dto;

import java.util.Calendar;


public class KpiLogRequest
    extends BaseRequest
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int indTOperazione;
    protected Calendar tsInizio;
    protected Calendar tsFine;
    protected String descrizione;
    protected short step;
    protected short esito;
    protected String reqLayer;
    protected BaseRequest bustaInput;
    protected BaseResponse bustaOutput;


    /**
     * Recupera il valore della proprietà tsInizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getTsInizio() {
        return tsInizio;
    }

    /**
     * Imposta il valore della proprietà tsInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsInizio(Calendar value) {
        this.tsInizio = value;
    }

    /**
     * Recupera il valore della proprietà tsFine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getTsFine() {
        return tsFine;
    }

    /**
     * Imposta il valore della proprietà tsFine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsFine(Calendar value) {
        this.tsFine = value;
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
     * Recupera il valore della proprietà step.
     * 
     */
    public short getStep() {
        return step;
    }

    /**
     * Imposta il valore della proprietà step.
     * 
     */
    public void setStep(short value) {
        this.step = value;
    }

    /**
     * Recupera il valore della proprietà esito.
     * 
     */
    public short getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     */
    public void setEsito(short value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà reqLayer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqLayer() {
        return reqLayer;
    }

    /**
     * Imposta il valore della proprietà reqLayer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqLayer(String value) {
        this.reqLayer = value;
    }

	public BaseRequest getBustaInput() {
		return bustaInput;
	}

	public void setBustaInput(BaseRequest bustaInput) {
		this.bustaInput = bustaInput;
	}

	public BaseResponse getBustaOutput() {
		return bustaOutput;
	}

	public void setBustaOutput(BaseResponse bustaOutput) {
		this.bustaOutput = bustaOutput;
	}

	public int getIndTOperazione() {
		return indTOperazione;
	}

	public void setIndTOperazione(int indTOperazione) {
		this.indTOperazione = indTOperazione;
	}


}
