<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
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
<table>
<tr><td colspan="5" align="center"><b>Lista Pagamenti Ricevuti</b></td></tr>
<tr><td>Numero</td><td>Cognome</td><td>Nome</td><td>Data</td><td>Ammontare</td><td>Modalit&agrave;</td><td colspan="2">Azioni</td></tr>
<s:iterator var="p" value="objlist" status="stat">

<tr>
<td><s:property value="numero"/></td>
<td><s:property value="ragazzo.cognome" /></td>
<td><s:property value="ragazzo.nome" /></td>
<td><s:property value="formattedData"/></td>
<td>&nbsp;&nbsp;&euro; <s:property value="formattedAmount"/></td>
<td><s:property value="tipo"/></td>

<td><a href="viewRagazzo?oid=<s:property value="ragazzo.oid" />&code=<s:property value="ragazzo.code" />">Guarda Ragazzo</a></td>
<td><a href="viewPagamento?oid=<s:property value="oid" />" >Visualizza</a></td>
</tr>
</s:iterator>
<tr><td colspan="5" align="right"><a href="downloadRegistro?anno=<s:property value="anno"/>"><input type="button" value="scarica"></a></td></tr>

</table>

</div>