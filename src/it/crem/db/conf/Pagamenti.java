package it.crem.db.conf;

import it.crem.db.BaseObject;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.Type;

public class Pagamenti extends BaseObject implements java.io.Serializable, Comparable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int oid;
	private Ragazzi ragazzo = null;
	private Double amount = null;
	private String riferimento = null;
	private String tipo = null;
	private Date data = null;
	private Boolean fatturaEmessa = null;
	private Boolean completo = null;
	private Integer numero = null;
	private String fattura = null;
	private Integer anno = null;
	private String causale = null;
	private DecimalFormatSymbols symb = new DecimalFormatSymbols();
	
	private DecimalFormat df = new DecimalFormat();
	
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public Ragazzi getRagazzo() {
		return ragazzo;
	}


	public void setRagazzo(Ragazzi ragazzo) {
		this.ragazzo = ragazzo;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getRiferimento() {
		return riferimento;
	}


	public void setRiferimento(String riferimento) {
		this.riferimento = riferimento;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Boolean getFatturaEmessa() {
		return fatturaEmessa;
	}


	public void setFatturaEmessa(Boolean fatturaEmessa) {
		this.fatturaEmessa = fatturaEmessa;
	}


	public Boolean getCompleto() {
		return completo;
	}


	public void setCompleto(Boolean completo) {
		this.completo = completo;
	}


	public String getFattura() {
		return fattura;
	}


	public void setFattura(String fattura) {
		this.fattura = fattura;
	}


	public Integer getAnno() {
		return anno;
	}


	public void setAnno(Integer anno) {
		this.anno = anno;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getFormattedData(){
		if (data!=null)
			return sdf.format(data);
		else
			return "";
	}

	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	
	
	
	public String getCausale() {
		return causale;
	}


	public void setCausale(String causale) {
		this.causale = causale;
	}


	public String getFormattedAmount(){
		symb.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(symb);
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		//df.setGroupingUsed(false);

		//if (n>)
		return (df.format(amount));
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int ret = 0;
		Pagamenti p = (Pagamenti)o;
		if (p.getOid()==oid){
			ret=0;
		}else{
			ret = riferimento.compareTo(p.getRiferimento());
		}
		
		return ret;
	}
	
	
}
