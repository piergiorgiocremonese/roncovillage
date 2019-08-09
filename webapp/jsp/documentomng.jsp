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

<form action="uploadDoc" name="uploadDoc"  enctype="multipart/form-data" method="POST" onsubmit="return fill();" >
<table id="table" border="0" id="tableForm">

<s:hidden name="op" value="%{op}"/>
<s:if test="%{oid!=null}">
<s:hidden name="oid" value="%{oid}"/>
</s:if>
<s:else>
<!-- il campo oid non impostato -->
</s:else>
<tr><td>Anno</td><td><input type="text" value="<s:property value="anno" />" name="anno" /></td></tr>
<tr><td>Nome</td><td><input type="text" value="<s:property value="nome" />" name="nome" /></td></tr>
<tr><td>Tipo</td><td><input type="text" value="<s:property value="tipo" />" name="tipo" /></td></tr>
<!--<tr><td>Keywords</td><td>-->
<s:select label="Keywords" 
		headerKey="%{keywords}" headerValue="%{keywords}"
		list="keytype" 
		name="keywords" />

<!--</td></tr>-->
<tr><td>Descrizione</td><td><input type="text" value="<s:property value="doc.descrizione" />" name="descrizione" /></td></tr>
<tr><td>Nome File</td><td><input type="text" value="<s:property value="fileName" />" name="fileName" /></td></tr>

<tr><td>Documento:</td><td><input type="file" name="fileUpload" value="" /></td></tr>
<!--<tr id="last"><td><a href="javascript:add()">Aggiungi</a></td></tr>-->
<tr><td><input type="submit" value="Upload" /></td></tr>
</table>
<form>
