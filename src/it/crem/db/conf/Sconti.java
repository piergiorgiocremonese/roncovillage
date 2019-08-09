package it.crem.db.conf;

import it.crem.db.BaseObject;

public class Sconti extends BaseObject implements Comparable{
	
	protected Ragazzi ragazzo=null;
	protected Double sconto = 0.0;
	protected Integer anno = null;
	public Ragazzi getRagazzo() {
		return ragazzo;
	}
	public void setRagazzo(Ragazzi ragazzo) {
		this.ragazzo = ragazzo;
	}
	public Double getSconto() {
		return sconto;
	}
	public void setSconto(Double sconto) {
		this.sconto = sconto;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	@Override
	public int compareTo(Object o) {
		Sconti s = (Sconti)o;
		if (this.oid==s.getOid())
		// TODO Auto-generated method stub
			return 0;
		return this.getAnno().compareTo(s.getAnno());
	}
	
	
	

}
