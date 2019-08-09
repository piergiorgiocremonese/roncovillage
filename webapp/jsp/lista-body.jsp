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
<tr><td colspan="5" align="center"><b>Lista Richieste per periodo <s:property value="periodo" /></b></td></tr>
<tr><td>&nbsp;</td><td>Cognome</td><td>Nome</td><td>Anno di nascita</td><td>Stato</td><td>Saldo</td><td colspan="3">Azioni</td></tr>
<s:iterator var="p" value="partecipanti" status="stat">

<tr>
<td><s:property value="#stat.index+1"/></td>
<td><s:property value="ragazzi.cognome" /></td><td><s:property value="ragazzi.nome" /></td><td><s:property value="ragazzi.annoNascita" /></td>
<td><s:property value="stato" /></td>
<td><s:property value="ragazzi.pagamento"/></td>
<td><a href="viewRagazzo?oid=<s:property value="ragazzi.oid" />&code=<s:property value="ragazzi.code" />&anno=<s:property value="anno"/>">Guarda</a></td>
<td><a href="listaPagamenti?ragazzoOid=<s:property value="ragazzi.oid" />&anno=<s:property value="anno"/>" >Pagamenti</a></td>
<td><a href="listaPresenze?oid=<s:property value="ragazzi.oid" />&anno=<s:property value="anno"/>" >Presenze</a></td>
</tr><
</s:iterator>
<tr><td colspan="5" align="right"><a href="downloadPeriodo"><input type="button" value="scarica"></a></td></tr>

</table>

</div>