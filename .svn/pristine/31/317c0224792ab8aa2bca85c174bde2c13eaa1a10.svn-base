<%@taglib prefix="s" uri="/struts-tags" %>


<p><center>Lista Foto nel Gruppo</center></p>
<p>Gruppo: <s:property value="gruppo.nome" /><img src="<s:property value="icona"/>"></p>
<table>

<s:iterator  value="fotoList" status="stat">
	<tr>
	<td><s:property value="nome"/><img src="showImage?file=<s:property value="file"/>" width="<s:property value="iconwidth" />" height="<s:property value="iconheight"/>" /></td>
	<td><a target="_blank" href="showImage?file=<s:property value="file"/>" >Guarda Foto</a></td>
	</tr>
</s:iterator>

<tr><td colspan=2"><a href="addFoto?gruppoOid=<s:property value="gruppo.oid"/>">Aggiungi Foto</a></td></tr>
</table>

