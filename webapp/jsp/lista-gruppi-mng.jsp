<%@taglib prefix="s" uri="/struts-tags" %>


<p><center>Lista Gruppi Foto</center></p>
<table border="1">

<s:iterator var="g" value="gruppi" status="stat">
<tr>

	<td colspan="2"><img src="<s:property value="icona"/>"></td>
	<td><a  href="showGruppo?gruppoOid=<s:property value="oid"/>"> Guarda Gruppo </a></td>
	<td><a  href="listaFoto?gruppoOid=<s:property value="oid"/>"> Guarda Lista Foto </a></td>
	<td><a  href="showAlbum?tipo=single&oid=<s:property value="oid"/>"> Sfoglia Foto </a></td>
	<td><a  href="showAlbum?tipo=large&oid=<s:property value="oid"/>"> Guarda Album Plain </a></td>
	

</tr>
</s:iterator>

<tr><td colspan="2"><a href="showGruppo">Aggiungi Gruppo</a></td></tr>
<tr><td colspan="2">Sezione Documenti</td></tr>
<tr><td colspan="2"><a href="showDoc">Aggiungi Documento</a></td></tr>
<tr><td colspan="2"><a href="showDocList">Lista Documenti in Archivio</a></td></tr>
<tr><td colspan="2"><a href="mngPageList">Lista Pagine Publiche</a></td></tr>

</table>

