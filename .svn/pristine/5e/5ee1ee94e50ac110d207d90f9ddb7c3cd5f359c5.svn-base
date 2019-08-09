package it.crem.server.actions;

import it.crem.db.conf.Tipologie;
import it.crem.db.mng.DbMngExt;

import java.util.List;

public class TipologieAction extends RoncoAction{
	private List tipologie = null;
	private Integer oid = null;
	private String forma = null;
	private String costo = null;
	private String tipo = null;
	private Integer numSettimane = null;
	private Boolean familiare = null;
	private Boolean mensa = null;
	private Boolean fullDay = null;
	private Tipologie tipologia = null;
	private String[] tipi ={"S","G"};
	private Integer[] numeroSettimane ={1,2,3,4,5,6};
	private String esito = null;
	private String html = null;
	
	public String list(){
		DbMngExt db = new DbMngExt();
		tipologie = db.getListObjectOrdered("Tipologie", null, "forma");
		return SUCCESS;
	}
	public String show(){
		DbMngExt db = new DbMngExt();
		if ((oid!=null)&&(oid>0)){
				
			tipologia = (Tipologie)db.getObject(oid, "Tipologie");
			tipo = tipologia.getTipo();
			numSettimane = tipologia.getNumSettimane();
		}else{
			tipo = "Seleziona tipo di frequenza";
			tipologia = new Tipologie();
			numSettimane=-1;
		}
		return SUCCESS;
	}
	
	
	public String save(){
		DbMngExt db = new DbMngExt();
		String msgOut = SUCCESS;
		try{
		Double costoTotale  = Double.parseDouble(costo);
		if ((oid!=null)&&(oid>0)){
			tipologia = (Tipologie)db.getObject(oid, "Tipologie");
			tipologia.setCostoTotale(costoTotale);
			tipologia.setFamiliare(familiare);
			tipologia.setForma(forma);
			tipologia.setNumSettimane(numSettimane);
			tipologia.setMensa(mensa);
			tipologia.setFullDay(fullDay);
			tipologia.setTipo(tipo);
			if (tipologia.getCostoUnitario()==null){
				Double cu = costoTotale/numSettimane;
				tipologia.setCostoUnitario(cu);
					
			}
			
			db.updObject(tipologia);
		}else{
			tipologia = new Tipologie();
			
			tipologia.setCostoTotale(costoTotale);
			Double cu = costoTotale/numSettimane;
			tipologia.setCostoUnitario(cu);
			tipologia.setFamiliare(familiare);
			tipologia.setForma(forma);
			tipologia.setNumSettimane(numSettimane);
			tipologia.setMensa(mensa);
			tipologia.setFullDay(fullDay);
			tipologia.setTipo(tipo);
			db.insertObject(tipologia);
		}
		}
		catch (Exception E){
			//msgOut = "failure";
			esito="aggiornamento non effettuato: "+E.getMessage();
			html = "aggiornamento non effettuato: "+E.getMessage();
		}
		return msgOut;
	}
	public List getTipologie() {
		return tipologie;
	}
	public void setTipologie(List tipologie) {
		this.tipologie = tipologie;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getNumSettimane() {
		return numSettimane;
	}
	public void setNumSettimane(Integer numSettimane) {
		this.numSettimane = numSettimane;
	}
	public Boolean getFamiliare() {
		return familiare;
	}
	public void setFamiliare(Boolean familiare) {
		this.familiare = familiare;
	}
	public Boolean getMensa() {
		return mensa;
	}
	public void setMensa(Boolean mensa) {
		this.mensa = mensa;
	}
	public Boolean getFullDay() {
		return fullDay;
	}
	public void setFullDay(Boolean fullDay) {
		this.fullDay = fullDay;
	}
	public Tipologie getTipologia() {
		return tipologia;
	}
	public void setTipologia(Tipologie tipologia) {
		this.tipologia = tipologia;
	}
	public String[] getTipi() {
		return tipi;
	}
	public void setTipi(String[] tipi) {
		this.tipi = tipi;
	}
	public Integer[] getNumeroSettimane() {
		return numeroSettimane;
	}
	public void setNumeroSettimane(Integer[] numeroSettimane) {
		this.numeroSettimane = numeroSettimane;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	

}
