package it.crem.db.conf;

import java.util.Set;

import it.crem.db.BaseObject;

public class Pagina extends BaseObject{
	
	private Set<BlocchiPagina> blocchi = null;
	private String templateName = null;
	private String nome = null;
	private String paginaId = null;
	private String categoria = null;
	private Template template = null;
	
	
	public Set<BlocchiPagina> getBlocchi() {
		return blocchi;
	}
	public void setBlocchi(Set<BlocchiPagina> blocchi) {
		this.blocchi = blocchi;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaginaId() {
		return paginaId;
	}
	public void setPaginaId(String paginaId) {
		this.paginaId = paginaId;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	

}
