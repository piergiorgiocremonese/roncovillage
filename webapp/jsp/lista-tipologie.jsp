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
<tr><td colspan="5" align="center"><b>Promozioni</b></td></tr>
<tr><td>&nbsp;</td><td>Forma</td><td>Costo</td><td>Tipo</td><td>Periodi</td><td>Azioni</td></tr>
<s:iterator var="p" value="tipologie" status="stat">

<tr>
<td><s:property value="#stat.index+1"/></td>
<td><s:property value="forma" /></td></td>
<td><s:property value="costoTotale" /></td>
<td><s:property value="tipo"/></td>
<td><s:property value="numSettimane" /></td>
<td><a href="showTipo?oid=<s:property value="oid" />" >Guarda</a></td>

</tr>
</s:iterator>
<tr>
<td>&nbsp;</td>
<td colspan="4">&nbsp;</td>
<td><a href="showTipo">Aggiungi</a></td>
</tr>
<tr><td colspan="5" align="right"><a href="downloadPeriodo"><input type="button" value="scarica"></a></td></tr>

</table>

</div>