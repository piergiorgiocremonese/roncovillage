package it.crem.db.conf;

import java.util.Date;

import it.crem.db.BaseObject;

public class Foto extends BaseObject implements Comparable{
	
	private String name = null;
	private String iconName = null;
	private String path = null;
	private String iconPath = null;
	private String url = null;
	private String iconUrl = null;
	private String mime = null;
	private Double  width = null;
	private Double height = null;
	private Double iconWidth = null;
	private Double iconHeight = null;
	private Date creation = null;
	private GruppiFoto gruppo = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getIconWidth() {
		return iconWidth;
	}
	public void setIconWidth(Double iconWidth) {
		this.iconWidth = iconWidth;
	}
	public Double getIconHeight() {
		return iconHeight;
	}
	public void setIconHeight(Double iconHeight) {
		this.iconHeight = iconHeight;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public GruppiFoto getGruppo() {
		return gruppo;
	}
	public void setGruppo(GruppiFoto gruppo) {
		this.gruppo = gruppo;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Foto f = (Foto)o;
		if (f==null)
			return 1;
		if (path == null)
			return -1;
		return path.compareTo(f.getPath());
	}
	
	
	
}
