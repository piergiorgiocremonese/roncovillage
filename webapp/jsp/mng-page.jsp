<%@taglib prefix="s" uri="/struts-tags" %>
<script>

function add(){
	alert('aggiungo file')
	var table = document.getElementById('table');
	var e = document.getElementById('last');
	var tr= document.createElement("tr");
	var td1= document.createElement("td");
	var lab = document.createTextNode("Foto");
	td1.appendChild(lab);
	tr.appendChild(td1);
	var td2= document.createElement("td");
	var i = document.createElement("input");
	i.setAttribute("type","file");
	i.setAttribute("name","fileUpload");
	i.setAttribute("value","");
	td2.appendChild(i);
	tr.appendChild(i);
	table.insertBefore(tr,table.childNodes[table.childNodes.length-1]);
}
function fill(){
	return true;
}

</script>
<p><center>Caricamento Documento Sezione Modulistica</center></p>

<form action="updPage" name="updPage"  method="POST" onsubmit="return fill();" >
<table id="table" border="0" id="tableForm">
<s:textfield name="nome" label="Nome" />
<s:textfield name="paginaId" label="Identificativo" />
<s:hidden name="op" value="%{op}"/>
<s:if test="%{pageOid!=null}">
<s:hidden name="pageOid" value="%{pageOid}"/>

<tr><td>Template: </td><td><s:property value="pagina.template.nome" /></td></tr>
<tr><td>Info Pagina: </td><td><s:property value="pagina.template.descrizione" /></td></tr>
<s:hidden name="templateOid" value="%{pagina.template.oid}"/>


</s:if>
<s:else>

<s:select label="Template: " 
		name="templateOid"
		headerKey="%{template.oid}" headerValue="%{template.nome}"
		list="templateList"
		listValue="nome" 
		listKey="oid"/>
		
<!-- il campo oid non impostato -->
</s:else>
<tr>
<td colspan="2">
<table>
<tr><td>blocco</td><td>tipo</td><td>elemento</td><td>azione</td></tr>
<s:iterator var="b" value="lista">
<tr>
<td><s:property value="bloccoId" /></td>
<td><s:property value="tipo" /></td>
<td>&nbsp;</td>
<td><a href="editBlock?bloccoOid=<s:property value="oid" />&pageOid=<s:property value="pageOid" />" >Edit Block</td>
</tr>
</s:iterator>
</table>
</td>
</tr>
<tr><td><a href="editPage?pageOid=<s:property value="pageOid" />" ><input type="button" name="edit" value="Edit"/> </a></td><td><input type="submit" value="Update" /></td></tr>
</table>
<form>
