package it.crem.db.conf;

import it.crem.db.BaseObject;

public class FormaUtilizzo extends BaseObject{
	
	private String tipo = null;
	private Integer attivo = null;
	private String giornata = null;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getAttivo() {
		return attivo;
	}
	public void setAttivo(Integer attivo) {
		this.attivo = attivo;
	}
	public String getGiornata() {
		return giornata;
	}
	public void setGiornata(String giornata) {
		this.giornata = giornata;
	}
	

}
