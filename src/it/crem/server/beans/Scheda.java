package it.crem.server.beans;

import it.crem.db.conf.Ragazzi;

public class Scheda {

	private Ragazzi ragazzo = null;
	private Double dovutoNoSconto = null;
	private Double dovutoSconto = null;
	private Double pagato = null;
	private Double resto = null;
	private Double sconto = 0.0;
	private Integer numeroPeriodi = null;
	private String tipo = null;
	private String info = null;
	private Boolean ok =  true;
	public Ragazzi getRagazzo() {
		return ragazzo;
	}
	public void setRagazzo(Ragazzi ragazzo) {
		this.ragazzo = ragazzo;
	}
	public Double getDovutoNoSconto() {
		return dovutoNoSconto;
	}
	public void setDovutoNoSconto(Double dovutoNoSconto) {
		this.dovutoNoSconto = dovutoNoSconto;
	}
	public Double getDovutoSconto() {
		return dovutoSconto;
	}
	public void setDovutoSconto(Double dovutoSconto) {
		this.dovutoSconto = dovutoSconto;
	}
	public Double getPagato() {
		return pagato;
	}
	public void setPagato(Double pagato) {
		this.pagato = pagato;
	}
	public Double getResto() {
		return resto;
	}
	public void setResto(Double resto) {
		this.resto = resto;
	}
	public Integer getNumeroPeriodi() {
		return numeroPeriodi;
	}
	public void setNumeroPeriodi(Integer numeroPeriodi) {
		this.numeroPeriodi = numeroPeriodi;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getSconto() {
		return sconto;
	}
	public void setSconto(Double sconto) {
		this.sconto = sconto;
	}
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
