package it.crem.db.conf;

// Generated May 1, 2016 7:22:17 PM by Hibernate Tools 3.4.0.CR1

/**
 * Quote generated by hbm2java
 */
public class Quote implements java.io.Serializable {

	private int oid;
	private String anno;
	private Double importo;
	private String tipo;

	public Quote() {
	}

	public Quote(int oid) {
		this.oid = oid;
	}

	public Quote(int oid, String anno, Double importo, String tipo) {
		this.oid = oid;
		this.anno = anno;
		this.importo = importo;
		this.tipo = tipo;
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getAnno() {
		return this.anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Double getImporto() {
		return this.importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}