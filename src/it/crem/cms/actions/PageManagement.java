package it.crem.cms.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;


import it.crem.cms.common.ContentUtility;
import it.crem.common.Utility;
import it.crem.db.conf.Blocchi;
import it.crem.db.conf.BlocchiPagina;
import it.crem.db.conf.Element;
import it.crem.db.conf.Pagina;
import it.crem.db.conf.Template;
import it.crem.db.conf.TemplateElement;
import it.crem.db.mng.DbMngExt;

public class PageManagement extends CmsAction {
	
	
	private String page = null;
	private Integer pageOid = null;
	private Integer bloccoOid = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	private DbMngExt db = new DbMngExt();
	private ContentUtility cntUtil = new ContentUtility();  
	private String[] contenuti = null;
	private String[] code = null;
	private List<Object> lista = null;
	private HashMap<String,List<Object>> sections = null;
	private String esito = null;
	private String html = null;
	private Pagina pagina = null;
	private Blocchi blocco = null;
	private Integer ordine = null;
	private String bloccoId = null;
	private Integer templateOid = null;
	private Integer elementOid = null;
	
	private Integer templateElementOid = null;
	private String nome = null;
	private String paginaId = null;
	private String template = null;
	private String categoria = null;
	private String tipo = null;
	private String info = null;
	private String section = null;
	
	private String[] tplList = null;
	private String[] catList = null;
	private String[] tipoList = null;
	private List<Object> templateList = null;
	private List<Object> templateElementList = null;
	private String op = null;
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	public String getPageList(){
		lista = db.getListObject("Pagina", null);
		return SUCCESS;
	}

	
	
	
	public String showPage(){
		String outMsg = SUCCESS;
		if (pageOid!=null){
			pagina =(Pagina) db.getObject(pageOid, "Pagina");
			if (pagina!=null){
				op = "upd";
				pageOid = pagina.getOid();
				paginaId = pagina.getPaginaId();
				nome = pagina.getNome();
				HashMap<String,Object> map = new HashMap<String,Object> ();
				map.put("pagina",pagina);
				
				if (pagina.getBlocchi()!=null){
					lista = new ArrayList();
					List bplist = db.getOrderedList(BlocchiPagina.class, map, "ordine");
					if (bplist!=null)
					for (int i=0;i<bplist.size();i++){
						BlocchiPagina bp =(BlocchiPagina)bplist.get(i);
						Blocchi b = bp.getBlocco();
						logger.debug("gestione blocco " + b.getBloccoId()+" in posizione "+bp.getOrdine());
						b.setOrdine(bp.getOrdine());
						lista.add(bp.getOrdine(),bp.getBlocco());
					}
				}
			}else{
				esito = "KO";
				html = "<p>page not found:"+pageOid+"</p>";
				logger.error("Page not found "+pageOid);
				outMsg = "failure";
			}
		}
		else{
			pagina = new Pagina();
			op="add";
		}
		logger.debug("si esce da pageMng con : " +outMsg);
		catList = Utility.RONCO.getString("ronco.pagina.categorie").split(",");
		tplList = Utility.RONCO.getString("ronco.pagina.template").split(",");
		templateList = db.getList("Template", null);
		//templateElementList = db.getList(obj, map)
		return outMsg;
	}
	
	
	
	public String editPage(){
		String outMsg = "failure";
		if (pageOid!=null){
			pagina =(Pagina) db.getObject(pageOid, "Pagina");
			String[] sectionList ={"header","footer","main"};
			if (pagina!=null){
				sections = new HashMap<String, List<Object>>();
				op = "upd";
				pageOid = pagina.getOid();
				paginaId = pagina.getPaginaId();
				nome = pagina.getNome();
				lista = new ArrayList();
				
				HashMap<String,Object> map = new HashMap<String,Object> ();
				map.put("pagina",pagina);
				
				
				for (int j=0;j<sectionList.length;j++){
					
				map.put("section",sectionList[j]);
				
				List bplist = db.getOrderedList(BlocchiPagina.class, map, "ordine");
				lista = new ArrayList<Object>();
				
				if (bplist!=null){
				for (int i=0;i<bplist.size();i++){
					BlocchiPagina b =(BlocchiPagina)bplist.get(i);
					
					lista.add(b.getOrdine(), b.getBlocco());
				}
				sections.put(sectionList[j], lista);
				}
				}
				Template template = pagina.getTemplate();
				if (template != null){
					outMsg = template.getCategoriaMng();
				}else{
					esito = "KO";
					html = "<p>template not assigned page not editable: "+pageOid+"</p>";
				}
			}else{
				logger.error("page not found: "+pageOid);
				esito = "KO";
				html = "<p>page not found:"+pageOid+"</p>";
			}
			return outMsg;
		}
		
		catList = Utility.RONCO.getString("ronco.pagina.categorie").split(",");
		tplList = Utility.RONCO.getString("ronco.pagina.template").split(",");
		templateList = db.getList("Template", null);
		//templateElementList = db.getList(obj, map)
		return outMsg;
	}
	
	
	
	
	
	
	public String updPage(){
		Integer oid=null;
		catList = Utility.RONCO.getString("ronco.pagina.categorie").split(",");
		tplList = Utility.RONCO.getString("ronco.pagina.template").split(",");
		templateList = db.getList("Template", null);
		
		Boolean add = false;
		if (pageOid!=null){
			pagina =(Pagina) db.getObject(pageOid, "Pagina");
			
		}
		else{
			pagina = new Pagina();
			Template template = (Template)db.getObject(templateOid,"Template");
			pagina.setTemplate(template);
			pagina.setTemplateName(template.getNome());
			pagina.setCategoria(template.getCategoria());
			add=true;
		}
		pagina.setNome(nome);
		pagina.setPaginaId(paginaId);
		if (!add)
			oid = db.updObject(pagina);
		else
			oid = db.insertObject(pagina);
		
		return SUCCESS;
	}
	
	public String updBlock(){
		Integer oid=null;
		catList = Utility.RONCO.getString("ronco.pagina.categorie").split(",");
		tplList = Utility.RONCO.getString("ronco.pagina.template").split(",");
		tipoList =  Utility.RONCO.getString("ronco.blocco.tipo").split(",");
		pagina =(Pagina) db.getObject(pageOid, "Pagina");
		
		Boolean add = false;
		if (bloccoOid!=null){
			blocco =(Blocchi) db.getObject(bloccoOid, "Blocchi");
			tipo = blocco.getTipo();
			HashMap<String,Object> map = new HashMap();
			
			map.put("blocco", blocco);
			map.put("pagina", pagina);
			List bpList = db.getList("BlocchiPagina", map);
			if (bpList==null){
				BlocchiPagina bp = new BlocchiPagina();
				bp.setPagina(pagina);
				bp.setBlocco(blocco);
				bp.setOrdine(oid);
				bp.setSection(section);
				db.insertObject(bp);
			}else{
				logger.debug("il blocco fa parte della pagina ");
			}
		}else{
			
			
			blocco = new Blocchi();
			
			//blocco.setPagina(pagina);
			//blocco.setPaginaId(pagina.getPaginaId());
			//Element element = (Element)db.getObject(elementOid, "Element");
			TemplateElement templateElement = (TemplateElement)db.getObject(templateElementOid, "TemplateElement");
			Element element = templateElement.getElement();
			blocco.setElement(element);
			tipo = element.getTipo();
			ordine = templateElement.getOrdine();
			section = templateElement.getSection();
			add=true;
		}
		
		blocco.setTipo(tipo);
		//blocco.setOrdine(ordine);
		blocco.setBloccoId(bloccoId);
		blocco.setInfo(info);
		if (add){
			oid = db.insertObject(blocco);
			BlocchiPagina bp = new BlocchiPagina();
			bp.setPagina(pagina);
			bp.setBlocco(blocco);
			bp.setOrdine(ordine);
			oid = db.insertObject(bp);
		}
		else
			oid = db.updObject(blocco);
		if (oid!=null)
			return SUCCESS;
		else{
			return "failure";
		}
	}
	
	public String showBlock(){
		if (bloccoOid!=null){
			blocco =(Blocchi) db.getObject(bloccoOid, "Blocchi");
			pagina =(Pagina) db.getObject(pageOid, "Pagina");
			//bloccoId = blocco.getBloccoId();
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("blocco", blocco);
			map.put("pagina", pagina);
			List l = db.getList(BlocchiPagina.class, map);
			if (l!=null&&l.size()>0){
				ordine = ((BlocchiPagina)l.get(0)).getOrdine();
				section =  ((BlocchiPagina)l.get(0)).getSection();
			}
			op="upd";
		}
		else{
			blocco = new Blocchi();
			op="add";
		}
		return SUCCESS;
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

	public Integer getBloccoOid() {
		return bloccoOid;
	}

	public void setBloccoOid(Integer bloccoOid) {
		this.bloccoOid = bloccoOid;
	}

	public ContentUtility getCntUtil() {
		return cntUtil;
	}

	public void setCntUtil(ContentUtility cntUtil) {
		this.cntUtil = cntUtil;
	}

	public String[] getContenuti() {
		return contenuti;
	}

	public void setContenuti(String[] contenuti) {
		this.contenuti = contenuti;
	}

	public String[] getCode() {
		return code;
	}

	public void setCode(String[] code) {
		this.code = code;
	}

	public List<Object> getLista() {
		return lista;
	}

	public void setLista(List<Object> lista) {
		this.lista = lista;
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

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Blocchi getBlocco() {
		return blocco;
	}

	public void setBlocco(Blocchi blocco) {
		this.blocco = blocco;
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

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String[] getTplList() {
		return tplList;
	}

	public void setTplList(String[] tplList) {
		this.tplList = tplList;
	}

	public String[] getCatList() {
		return catList;
	}

	public void setCatList(String[] catList) {
		this.catList = catList;
	}

	public String[] getTipoList() {
		return tipoList;
	}

	public void setTipoList(String[] tipoList) {
		this.tipoList = tipoList;
	}

	public Integer getOrdine() {
		return ordine;
	}

	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}

	public String getBloccoId() {
		return bloccoId;
	}

	public void setBloccoId(String bloccoId) {
		this.bloccoId = bloccoId;
	}

	public Integer getTemplateOid() {
		return templateOid;
	}

	public void setTemplateOid(Integer templateOid) {
		this.templateOid = templateOid;
	}

	public Integer getTemplateElementOid() {
		return templateElementOid;
	}

	public void setTemplateElementOid(Integer templateElementOid) {
		this.templateElementOid = templateElementOid;
	}

	public List<Object> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<Object> templateList) {
		this.templateList = templateList;
	}

	public List<Object> getTemplateElementList() {
		return templateElementList;
	}

	public void setTemplateElementList(List<Object> templateElementList) {
		this.templateElementList = templateElementList;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Integer getElementOid() {
		return elementOid;
	}

	public void setElementOid(Integer elementOid) {
		this.elementOid = elementOid;
	}

	
	
	
}
