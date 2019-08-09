package it.crem.server.beans;

public class Foto {
	protected String nome = null;
	protected String url=null;
	protected String file = null;
	protected String icon = null;
	protected String iconUrl = null;
	
	protected Integer width = null;
	protected Integer height = null;
	protected Double iconwidth = null;
	protected Double iconheight = null;
	protected String orient = null;
	protected String mime = null;
	
	public Foto(){
	}
	
	public Foto(it.crem.db.conf.Foto foto){
		this.file = foto.getPath();
		this.height=foto.getHeight().intValue();
		this.width=foto.getWidth().intValue();
		this.nome=foto.getName();
		this.mime=foto.getMime();
		if (foto.getIconPath()!=null){
			this.icon=foto.getIconPath();
			this.iconheight=foto.getIconHeight();
			this.iconwidth = foto.getIconWidth();
			this.iconUrl=foto.getIconUrl();
		}
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
	
	public String getOrient() {
		return orient;
	}
	public void setOrient(String orient) {
		this.orient = orient;
	}
	public Double getIconwidth() {
		return iconwidth;
	}
	public void setIconwidth(Double iconwidth) {
		this.iconwidth = iconwidth;
	}
	public Double getIconheight() {
		return iconheight;
	}
	public void setIconheight(Double iconheight) {
		this.iconheight = iconheight;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	
	
	
}
