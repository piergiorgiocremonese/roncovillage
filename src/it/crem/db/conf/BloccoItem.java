package it.crem.db.conf;

import it.crem.db.BaseObject;

public class BloccoItem extends BaseObject {

	private Blocchi blocco = null;
	private String tipo = null;
	private String info = null;
	private String media = null;
	private String itemId = null;
	private Integer width = null;
	private Integer height = null;
	private Integer ordine = null;
	private Integer left = null;
	private Integer right = null;
	private Integer top = null;
	private Integer bottom = null;
	public Blocchi getBlocco() {
		return blocco;
	}
	public void setBlocco(Blocchi blocco) {
		this.blocco = blocco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getOrdine() {
		return ordine;
	}
	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getBottom() {
		return bottom;
	}
	public void setBottom(Integer bottom) {
		this.bottom = bottom;
	}
	
	
	
	
	
}
