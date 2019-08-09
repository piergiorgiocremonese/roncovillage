package it.crem.db.conf;

import it.crem.db.BaseObject;

import java.util.Date;

import org.hibernate.annotations.Type;

public class Allegati extends BaseObject implements java.io.Serializable, Comparable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int oid;
	private Ragazzi ragazzo = null;
	private String nome = null;
	private String path = null;
	private String url = null;
	private Date creazione = null;
	private String mime = null;
	private String descrizione = null;
	private String tipo = null;
	
	private byte[] image = null;
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreazione() {
		return creazione;
	}
	public void setCreazione(Date creazione) {
		this.creazione = creazione;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int ret = 0;
		Allegati a = (Allegati)o;
		if (a.getOid()==oid){
			ret=0;
		}else{
			ret = nome.compareTo(a.getNome());
		}
		
		return ret;
	}
	
	
}
