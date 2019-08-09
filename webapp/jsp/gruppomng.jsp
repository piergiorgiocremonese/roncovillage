<%@taglib prefix="s" uri="/struts-tags" %>
<script>
function change(){
	alert('si cambia icona');
	var table = document.getElementById('tableForm');
	var row = document.getElementById('last');
	//var tr= document.createElement("tr");
	var td1= document.createElement("td");
	var lab = document.createTextNode("Foto");
	td1.appendChild(lab);
	row.appendChild(td1);
	var td2= document.createElement("td");
	var i = document.createElement("input");
	i.setAttribute("type","file");
	i.setAttribute("name","iconFile");
	i.setAttribute("value","");
	td2.appendChild(i);
	row.appendChild(td2);
	//table.insertBefore(tr,table.childNodes[table.childNodes.length-2]);
	
	
}

function fill(){
	return true;
}
</script>
<form action="updGruppo" name="updGruppo"  enctype="multipart/form-data" method="POST" onsubmit="return fill();" >

<input type="hidden" name="gruppoOid" value="<s:property value="gruppo.oid"/>" />
<table border="0" id="tableForm">
<tr><td>Nome:</td><td><input type="text" name="nome" value="<s:property value="gruppo.nome"/>" /></td></tr>
<tr><td>Icona:</td><td><img src="<s:property value="gruppo.icona"/>" width="<s:property value="gruppo.iconwidth"/>" height="<s:property value="gruppo.iconheight"/>"/><br><a href="javascript:change()">Change</a></td></tr>
<tr id="last"></tr>
<tr><td colspan="2"><input type="submit" value="salva"/></td></tr>


</table>
</form>

<p><a href="listaFoto?gruppoOid=<s:property value="gruppo.oid"/>&op=form">Lista foto</a></p>