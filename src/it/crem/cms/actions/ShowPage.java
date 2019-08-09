package it.crem.cms.actions;

import org.apache.log4j.Logger;

import com.itextpdf.text.Header;

import it.crem.cms.beans.PageCmsBean;
import it.crem.cms.common.CmsUtility;
import it.crem.cms.common.ContentUtility;
import it.crem.db.conf.Blocchi;
import it.crem.db.conf.BlocchiPagina;
import it.crem.db.conf.Pagina;
import it.crem.db.mng.DbMngExt;
import it.crem.server.beans.PageInfo;

public class ShowPage extends CmsAction {
	
	
	private String page = null;
	private Integer pageOid = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	private DbMngExt db = new DbMngExt();
	private ContentUtility cntUtil = new ContentUtility();  
	private CmsUtility cmsUtil = new CmsUtility();  
	
	private String[] contenuti = null;
	private String[] code = null;
	private String[] headercnt = null;
	private String[] headercode = null;
	private String[] footercnt = null;
	private String[] footercode = null;
	
	private String esito = null;
	private String html = null;
	private PageCmsBean pcb = null;
	 
	public String execute(){
		
		String outMsg = null;
		
		pcb = cmsUtil.getPage(pageOid, null);
		contenuti = pcb.getContenuti();
		code = pcb.getCode();
		headercnt = pcb.getHeadercnt();
		headercode = pcb.getHeadercode();
		footercnt = pcb.getFootercnt();
		footercode = pcb.getFootercode();
		
		esito = pcb.getEsito();
		html = pcb.getHtml();
		logger.debug("si esce su " + pcb.getOutMsg());
		return pcb.getOutMsg();
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public Integer getPageOid() {
		return pageOid;
	}


	public void setPageOid(Integer pageOid) {
		this.pageOid = pageOid;
	}


	public String[] getContenuti() {
		return contenuti;
	}


	public void setContenuti(String[] contenuti) {
		this.contenuti = contenuti;
	}


	public String getEsito() {
		return esito;
	}


	public void setEsito(String esito) {
		this.esito = esito;
	}


	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	public String[] getCode() {
		return code;
	}


	public void setCode(String[] code) {
		this.code = code;
	}


	public String[] getHeadercnt() {
		return headercnt;
	}


	public void setHeadercnt(String[] headercnt) {
		this.headercnt = headercnt;
	}


	public String[] getHeadercode() {
		return headercode;
	}


	public void setHeadercode(String[] headercode) {
		this.headercode = headercode;
	}


	public String[] getFootercnt() {
		return footercnt;
	}


	public void setFootercnt(String[] footercnt) {
		this.footercnt = footercnt;
	}


	public String[] getFootercode() {
		return footercode;
	}


	public void setFootercode(String[] footercode) {
		this.footercode = footercode;
	}


	public PageCmsBean getPcb() {
		return pcb;
	}


	public void setPcb(PageCmsBean pcb) {
		this.pcb = pcb;
	}
}
