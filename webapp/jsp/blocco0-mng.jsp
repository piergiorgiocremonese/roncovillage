<%@taglib prefix="s" uri="/struts-tags" %>





<s:property escape="false" value="lista[0].info"/>
<p><a href="editBlock?bloccoOid=<s:property value="lista[0].oid" />" target="_blank" >Edit Bloccco <s:property value="lista[0].nome" /> </a></p>


