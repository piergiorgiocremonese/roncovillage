<%@taglib prefix="s" uri="/struts-tags" %>


<p><center>Lista Gruppi Foto</center></p>
<table>
<tr>
<s:iterator var="g" value="gruppi" status="stat">
<td><table border="1">
	<tr>
	<td colspan="2"><img src="showImage?file=<s:property value="iconaPath"/>"></td>
	</tr>
	<tr>
	<td><a target="_blank" href="showAlbum?tipo=single&oid=<s:property value="oid"/>">Sfoglia Foto</a></td>
	<td><a target="_blank" href="showAlbum?tipo=large&oid=<s:property value="oid"/>">Guarda Album Plain</a></td>
	</tr>
	</table>
</td>

</s:iterator>
</tr>
</table>
