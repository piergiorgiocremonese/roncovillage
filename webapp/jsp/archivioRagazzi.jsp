<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">

function ckAll(){
	 var list = document.getElementsByTagName("input");
	 var no=0;
	 for (var i=0;i<list.length;i++){
	 	var x = list[i];
	 	if (x.getAttribute("type")=='checkbox'){
	 		x.setAttribute("checked","true");
	 	}else{
	 	}
	 }
	
}

function fill(){
	var nrv = document.getElementById('nomeRagazzo').value;
	var cnrv = document.getElementById('cognomeRagazzo').value;
	var npv = document.getElementById('nomePadre').value;
	var nmv = document.getElementById('nomeMadre').value;
	var tcv = document.getElementById('telefonoCasa').value;
	var cpv = document.getElementById('cellPadre').value;
	var cmv = document.getElementById('cellMadre').value;
	if ((nrv == '')||(cnrv=='')){
			alert('manca nome Ragazzo');
			return false;
	}
	if ((npv == '')&&(cnrv=='')){
		alert('manca nome almeno un Genitore');
		return false;
	}
	if ((tcv == '')&&(cpv=='')&&(cmv == '')){
		alert('manca contatto per almeno un Genitore');
		return false;
	}
	return true;
}

	

function getElement(type,name, label){
	alert('creo'+name);
	var tr = document.createElement('tr');
	var tdl = document.createElement('td');
	var l = document.createTextNode(label);
	tdl.appendChild(l);
	var td = document.createElement('td');
	var i = document.createElement('input');
	i.setAttribute('type',type);
	i.setAttribute('name',name);
	i.setAttribute('size','80');
	td.appendChild(i);
	tr.appendChild(tdl);
	tr.appendChild(td);
	return tr;
}


function add(){
	alert('aggiungo elelmenti');
	var el = document.getElementById('tableForm');
	el.appendChild(getElement('file','fileUpload','Documento'));
	el.appendChild(getElement('text','fileName','Nome File'));
	el.appendChild(getElement('text','fileDesc','Descrizione'));
	el.appendChild(getElement('text','fileType','Tipo'));

	//el.appendChild(fel);
}

</script>
<div id="blockcnt" >
<form action="inform" method="POST">
<table>
<tr><td><input type="button" value="Select All" onclick="ckAll()")/><td><input type="submit" value="send"></td></tr>

<tr><td colspan="5" align="center"><b>Lista Iscritti</b></td></tr>

<tr><td>&nbsp;</td><td>Cognome</td><td>Nome</td><td>Anno di nascita</td><td colspan="1">Azioni</td></tr>
<s:iterator var="p" value="listaRagazzi" status="stat">
<tr>
<td><s:property value="#stat.index+1" /> <input type="checkbox" name="advice" value="<s:property value="oid"/>"/></td>
<td><s:property value="cognome" /></td>
<td><s:property value="nome" /></td><td><s:property value="annoNascita" /></td>

<td><a target="_blank" href="viewRagazzo?oid=<s:property value="oid" />&code=<s:property value="code" />&anno=<s:property value="anno"/>" >Guarda</a></td>
<td><a target="_blank" href="listaPresenze?oid=<s:property value="oid" />&code=<s:property value="code" />&anno=<s:property value="anno"/>" >Presenze</a></td></td>
<td><a target="_blank" href="listaPagamenti?oid=<s:property value="oid" />&code=<s:property value="code" />&anno=<s:property value="anno"/>" >Pagamenti</a></td></td>


</tr>
</s:iterator>
</table>
</form>

</div>