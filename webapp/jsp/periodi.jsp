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
<p><center>Lista Settimane anno: <s:property value="anno"/></center></p>

<table border="1" id="tableForm">

<tr><td>Settimana</td><td>Inizio</td><td>Fine</td><td>Numero massimo</td><td>Stato</td><td>Azione</td></tr>
 <s:iterator value="periodiList" status="stat">

<tr>
<td>Settimana <s:property value="ordine"/></td>

<td><s:property value="formattedInizio"/></td>
<td><s:property value="formattedFine"/></td>
<td><s:property value="numeroMassimo"/></td>
<td><s:property value="libero"/></td>
<td><a href="periodo?periodoOid=<s:property value="oid"/>">Guarda</a></td>
</tr>
	
</s:iterator>
<tr><td colspan="4"><a href="periodo">Aggiungi Periodo</a></td></tr>
</table>

</div>
<div id="calendario" ></div>
