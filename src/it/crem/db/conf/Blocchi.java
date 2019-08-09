package it.crem.db.conf;

import it.crem.db.BaseObject;
import java.util.Set;


public class Blocchi extends BaseObject{
	
	private Pagina pagina = null;
	private String bloccoId = null;
	private String paginaId = null;
	private String info = null;
	private String tipo = null;
	private Integer ordine = null;
	private TemplateElement templateElement = null;
	private Element element = null;
	
	private Set<BloccoItem> items = null;
	
	
	public Set<BloccoItem> getItems() {
		return items;
	}
	public void setItems(Set<BloccoItem> items) {
		this.items = items;
	}
	public Pagina getPagina() {
		return pagina;
	}
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	public String getBloccoId() {
		return bloccoId;
	}
	public void setBloccoId(String bloccoId) {
		this.bloccoId = bloccoId;
	}
	public String getPaginaId() {
		return paginaId;
	}
	public void setPaginaId(String paginaId) {
		this.paginaId = paginaId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getOrdine() {
		return ordine;
	}
	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}
	public TemplateElement getTemplateElement() {
		return templateElement;
	}
	public void setTemplateElement(TemplateElement templateElement) {
		this.templateElement = templateElement;
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	
	

}
