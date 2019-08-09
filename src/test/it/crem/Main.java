package test.it.crem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.xerces.impl.dv.util.Base64;

import it.ash.graphical.Dimension;
import it.ash.graphical.ImageMng;
import it.crem.common.Utility;
import it.crem.db.conf.Allegati;
import it.crem.db.conf.Foto;
import it.crem.db.conf.GruppiFoto;
import it.crem.db.mng.DbMng;
import it.crem.db.mng.DbMngExt;

public class Main {
	
	public static void main(String[] args){
		try{
			DbMngExt db = new DbMngExt();
			//String rootpath = "/var/www/roncoweb/foto/2016/foto";
			//String rooturl = "/roncoweb/foto/2016/foto";
			String rootpath =Utility.RONCO.getString("ronco.area.foto.old");
			String rooturl = Utility.RONCO.getString("ronco.area.foto.url.old");
			
			Integer w = Integer.parseInt(Utility.RONCO.getString("ronco.img.width"));
			Integer h = Integer.parseInt(Utility.RONCO.getString("ronco.img.height"));
			Integer iconw = Integer.parseInt(Utility.RONCO.getString("ronco.img.icon.width"));
			Integer iconh = Integer.parseInt(Utility.RONCO.getString("ronco.img.icon.height"));
			//String outFotoDir = "/var/www/roncoweb/foto/2016/areafoto";
			//String outIconDir = "/var/www/roncoweb/foto/2016/areaicone";
			String outFotoDir = Utility.RONCO.getString("ronco.area.foto");
			String outIconDir = Utility.RONCO.getString("ronco.area.icone");;
			
			
			int max = 1000;
			
			File root = new File (rootpath);
			if (root.isDirectory()){
				String[] list = root.list();
				if (list!=null){
					
					for (int i=0;i<list.length;i++){
						String dirName = list[i];
						String dir = root+"/"+dirName;
						System.out.println("dir:  " +dir);
						HashMap<String,String> map = new HashMap<String,String>();
						map.put("path", rootpath);
						map.put("cartella", dirName);
						System.out.println("cerco " + rootpath + "/"+dirName);
						GruppiFoto gf  = null;
						List gfList = db.getListObject("GruppiFoto", map);
						if ((gfList!=null)&&(gfList.size()>0)){
							gf = (GruppiFoto)gfList.get(0);
							System.out.println("trovato gruppi");
						}else{
							System.out.println("NO gruppi");
						}
						if (gf!=null){
							System.out.println("trovato gruppo");
							File dirFile = new File(dir);
							String[] files = dirFile.list();
							if (files!=null){
							int lun = files.length;
								if (lun>max)
									lun = max;
								for (int j=0;j<lun;j++){
									System.out.println("file " +files[j]);
									File target = null;
									Foto foto = new Foto();
									foto.setGruppo(gf);
									String url = rooturl + "/"+files[j];
									
									String fp = dir + "/"+files[j];
									String nfp = outFotoDir + "/"+files[j];
									String nifp =  outIconDir+ "/icon-"+files[j];
									String iurl = rooturl + "/icon-"+files[j];
									String name = "";
									ImageMng mng = new ImageMng(fp);
									mng.updStringType();
									String ext = mng.getOutType();
									Dimension dim = mng.getDimension();
									
									if (nfp.indexOf(".")>0){
										nfp = nfp.substring(0,nfp.lastIndexOf("."))+"."+ext;
									}
									target = new File(nfp);
									if (dim.getWidth()>w){
											
										mng.updResizeByWidth(w);
										mng.setTarget(nfp);
										mng.resizeByWidth(nfp, w);
										
									
									}else{
										File source = new File(fp);
										
										FileUtils.copyFile(source, target);
										mng.setWidth(dim.getWidth());
										mng.setHeight(dim.getHeight());
										
									}
									
									name = target.getName();
									foto.setName(name);
									foto.setPath(nfp);
									foto.setMime("image/"+ext);
									foto.setWidth(Double.valueOf(mng.getWidth()+""));
									foto.setHeight(Double.valueOf(mng.getHeight()+""));
									if (nifp.indexOf(".")>0){
										nifp = nifp.substring(0,nfp.lastIndexOf("."))+"."+ext;
									}
									mng.updResizeByHeight(iconh);
									mng.setTarget(nifp);
									mng.resizeByHeight(nifp, iconh);
									foto.setIconPath(nifp);	
									foto.setIconHeight(Double.valueOf(mng.getHeight()+""));
									foto.setIconWidth(Double.valueOf(mng.getWidth()+""));
									foto.setUrl(url);
									foto.setIconUrl(iurl);
									foto.setIconName("icon-"+name);
									foto.setCreation(Calendar.getInstance().getTime());
									int oid = db.insertObject(foto);
									System.out.println("Inserito " +oid);
									
								}
							}
							
						}
					}
				}
			}
			
		}
		catch (Exception E){
			E.printStackTrace();
		}
	}	
			
			
			
			
	

}
