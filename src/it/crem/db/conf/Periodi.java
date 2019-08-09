package it.crem.db.conf;

// Generated May 1, 2016 7:22:17 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import it.crem.common.Utility;
import it.crem.db.BaseObject;
/**
 * Periodi generated by hbm2java
 */
public class Periodi extends BaseObject implements java.io.Serializable {

	//private Integer oid;
	private String ordine;
	private Date inizio;
	private Date fine;
	private String anno;
	private Set partecipantis = new HashSet(0);
	private Boolean attivo = false;
	private Boolean confermato = false; // campo non sul db ma ereditato logicamente da partecipanti
	private Tipologie tipologia = null ; // campo non presente sul DB utilizzato per il FrontEnd
	private Boolean libero = true;
	private Integer numeroMassimo = 60;
	private Integer numeroIscritti = null;
	
	
	public Periodi() {
	}

	public Periodi(int oid) {
		this.oid = oid;
	}

	public Periodi(Integer oid, String ordine, Date inizio, Date fine,
			Set partecipantis, Set giornates) {
		this.oid = oid;
		this.ordine = ordine;
		this.inizio = inizio;
		this.fine = fine;
		this.partecipantis = partecipantis;
		
	}
/*
	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}
*/
	public String getOrdine() {
		return this.ordine;
	}

	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}

	public Date getInizio() {
		return this.inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}

	public Date getFine() {
		return this.fine;
	}

	public void setFine(Date fine) {
		this.fine = fine;
	}

	public Set getPartecipantis() {
		return this.partecipantis;
	}

	public void setPartecipantis(Set partecipantis) {
		this.partecipantis = partecipantis;
	}

	

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public String getFormattedFine(){
		return Utility.getFormattedData(this.fine);
	}
	public String getFormattedInizio(){
		return Utility.getFormattedData(this.inizio);
	}
	
	
	public Boolean getConfermato() {
		return confermato;
	}

	public void setConfermato(Boolean confermato) {
		this.confermato = confermato;
	}

	public Tipologie getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologie tipologia) {
		this.tipologia = tipologia;
	}

	public String getChecked(){
		String checked="";
		if (attivo){
			checked = "checked";
		}
		return checked;
			
	}
	
	public String getConfermatoChecked(){
		String checked="";
		if (confermato){
			checked = "checked";
		}
		return checked;
			
	}

	public Boolean getLibero() {
		return libero;
	}

	public void setLibero(Boolean libero) {
		this.libero = libero;
	}

	public Integer getNumeroMassimo() {
		return numeroMassimo;
	}

	public void setNumeroMassimo(Integer numeroMassimo) {
		this.numeroMassimo = numeroMassimo;
	}

	public Integer getNumeroIscritti() {
		return numeroIscritti;
	}

	public void setNumeroIscritti(Integer numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}
	
	
}