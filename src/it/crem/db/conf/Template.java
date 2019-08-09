package it.crem.db.conf;

import java.util.Set;

import it.crem.db.BaseObject;

public class Template extends BaseObject {
	
	
	private String nome = null;
	private String categoria = null;
	private String categoriaMng = null;
	private String file = null;
	private String descrizione = null;
	private Integer numeroElementi  = null;
	private Set<TemplateElement> elementi = null;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Set<TemplateElement> getElementi() {
		return elementi;
	}
	
	
	public void setElementi(Set<TemplateElement> elementi) {
		this.elementi = elementi;
	}
	public Integer getNumeroElementi() {
		return numeroElementi;
	}
	public void setNumeroElementi(Integer numeroElementi) {
		this.numeroElementi = numeroElementi;
	}
	public String getCategoriaMng() {
		return categoriaMng;
	}
	public void setCategoriaMng(String categoriaMng) {
		this.categoriaMng = categoriaMng;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
