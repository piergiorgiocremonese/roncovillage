package it.crem.cms.common;

import org.apache.log4j.Logger;

import it.crem.cms.beans.PageCmsBean;
import it.crem.db.conf.BlocchiPagina;
import it.crem.db.conf.Pagina;
import it.crem.db.mng.DbMngExt;
import it.crem.server.beans.PageInfo;

public class CmsUtility {
	
	
	private Logger logger = Logger.getLogger(this.getClass());
	private DbMngExt db = new DbMngExt();
	private ContentUtility cntUtil = new ContentUtility();  
	
	
	public PageCmsBean getPage(Integer pageOid, String page){
		String[] contenuti = null;
		 String[] code = null;
		 String[] headercnt = null;
		 String[] headercode = null;
		 String[] footercnt = null;
		 String[] footercode = null;
		String outMsg  = null;
		String html = null;
		String esito = null;
		PageCmsBean pageBean = new PageCmsBean();
		Pagina pagina = null;
		if (pageOid !=null){
			logger.debug("gerco  apagina tramite pageOid: "+ pageOid);
			pagina = (Pagina)db.getObject(pageOid, "Pagina");
		}
		else if (page!=null){
			logger.debug("gerco  apagina tramite page: "+ page);
			pagina = (Pagina)db.getUniqueObject("Pagina", "paginaId", page);
		}else{
			logger.error("pagina non impostata");
			html = "<p>Errore: pagina non specificata</p>";
			esito = "KO";
			
			outMsg = "failure";
			
		}
		if (pagina == null){
			logger.error("pagina non trovata");
			html = "<p>Errore: pagina " + pageOid + " "+page + " non trovata</p>";
			esito = "KO";
			
			outMsg = "failure";
			//return outMsg;
		}
		outMsg = pagina.getTemplate().getCategoria();
		logger.debug("categoria = " +outMsg);
		if (pagina.getBlocchi()!=null){
			int hn=0;
			int fn=0;
			int mn=0;
			for (BlocchiPagina bp : pagina.getBlocchi()){
				switch (bp.getSection()){
				case "header":
					hn++;
					break;
				case "footer":
					fn++;
					break;
				case "main":
					mn++;
					break;
				case "default":
					mn++;
					break;
				}
			}
			logger.debug("si sono numnero blocchi header: "+hn+" main: " +mn + " footer "+fn);
			contenuti = new String[mn];
			code = new String[mn];
			headercnt = new String[hn];
			headercode = new String[hn];
			footercnt = new String[fn];
			footercode = new String[fn];
			for (int i=0;i<mn;i++){
				code[i]="";
				contenuti[i]="";
			}
			for (int i=0;i<hn;i++){
				headercode[i]="";
				headercnt[i]="";
			}
			for (int i=0;i<fn;i++){
				footercode[i]="";
				footercnt[i]="";
			}
		}else{
			logger.debug("non ci son  blocchi per " + pageOid + " " +pagina.getNome()+ "  tpl= " + pagina.getTemplate().getNome());
		}
		for (BlocchiPagina b: pagina.getBlocchi()){
			String tipoId = b.getBlocco().getElement().getNome();
			switch (b.getBlocco().getTipo()){
				case "content":
					if ("header".equals(b.getSection()))
						headercnt[b.getOrdine()]=b.getBlocco().getInfo();
					else if ("footer".equals(b.getSection()))
						footercnt[b.getOrdine()]=b.getBlocco().getInfo();
					else
						contenuti[b.getOrdine()]=b.getBlocco().getInfo();
					break;
				case "app":
					String divId = b.getPageElementId();
					PageInfo info = cntUtil.getAppInfo(tipoId, b.getBlocco().getOid(), divId);
					if ("header".equals(b.getSection())){
						headercnt[b.getOrdine()]=b.getBlocco().getInfo();
						headercode[b.getOrdine()] =info.getCode();
					}else if ("footer".equals(b.getSection())){
						footercnt[b.getOrdine()]=b.getBlocco().getInfo();
						footercode[b.getOrdine()] =info.getCode();
					} else{
						contenuti[b.getOrdine()]=b.getBlocco().getInfo();
						code[b.getOrdine()]=info.getCode();
					}
					//contenuti[b.getOrdine()]=info.getContent();
					//kdag9j00code[b.getOrdine()]=info.getCode();
					break;
				case "default":
					logger.error("non so casa devo fare: tipo blocco non riconsociuto: "+b.getBlocco().getTipo());
					html = "<p>Errore: tipo pagina non trovata</p>";
					esito = "KO";
					outMsg = "failure";
					break;
			}
			
		}
				
		pageBean.setContenuti(contenuti);	
		pageBean.setCode(code);
		pageBean.setHeadercnt(headercnt);	
		pageBean.setHeadercode(headercode);
		pageBean.setFootercnt(footercnt);	
		pageBean.setFootercode(footercode);
		pageBean.setEsito(esito);
		pageBean.setHtml(html);
		pageBean.setOutMsg(outMsg);
		return pageBean;
	}

}
