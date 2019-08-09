package it.crem.db.conf;

import it.crem.db.BaseObject;

public class BlocchiPagina extends BaseObject {
	
	private Pagina pagina = null;
	private Blocchi blocco = null;
	private Integer ordine = null;
	private String section = null;
	private String pageElementId = null;
	public Pagina getPagina() {
		return pagina;
	}
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	public Blocchi getBlocco() {
		return blocco;
	}
	public void setBlocco(Blocchi blocco) {
		this.blocco = blocco;
	}
	public Integer getOrdine() {
		return ordine;
	}
	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPageElementId() {
		return pageElementId;
	}
	public void setPageElementId(String pageElementId) {
		this.pageElementId = pageElementId;
	}
	
	

}
