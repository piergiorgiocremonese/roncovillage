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
<form action="addFoto" name="updFoto"  enctype="multipart/form-data" method="POST" onsubmit="return fill();" >
<table id="table" border="0" id="tableForm">
<input type="hidden" name="gruppoOid" value="<s:property value="gruppo.oid"/>" />
<s:hidden name="op" value="add"/>
<tr><td>Foto:</td>
<td><input type="file" name="fileUpload" value="" /></td></tr>
<tr id="last"><td><a href="javascript:add()">Aggiungi</a></td></tr>
<tr><td><input type="submit" value="salva" /></td></tr>
</table>
<form>

<p><a href="addFoto?gruppoOid=%{gruppo.oid}&op=form">Aggiungi foto</a></p>