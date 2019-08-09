<%@taglib prefix="s" uri="/struts-tags" %>


<p><center>Lista Pagine</center></p>

<table>

<s:iterator  value="lista" status="stat">
	<tr>
	<td><s:property value="nome"/></td>
	<td><a target="_blank" href="mngPage?pageOid=<s:property value="oid"/>" >Gestisci Pagina</a></td>
	</tr>
</s:iterator>

<tr><td colspan=2"><a href="mngPage?op=new" >Aggiungi Pagina</a></td></tr>
</table>

