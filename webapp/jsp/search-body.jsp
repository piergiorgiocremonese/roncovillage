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

<s:form name="search" action="search"  method="POST" >
<s:hidden  name="anno" value="%{anno}"/>
<table border="1" id="tableForm">

<tr><td colspan="2"><center>Periodo</td></tr>

 <s:iterator value="periodiList" status="stat">

<tr>
<td>Periodo <s:property value="ordine"/></td>

<td>
	<s:property value="formattedInizio"/>-<s:property value="formattedFine"/>
	<input type="radio" name="settimana" value="<s:property value="oid"/>" />	
</td>
</tr>
</s:iterator>
<!-- 
<tr><td>Settimana</td><td>&nbsp;</td></tr>
<tr><td>Periodo 1</td><td>4-8 Luglio<input type="checkbox" name="settimana" value="uno"/></td></tr>
<tr><td>Periodo 2</td><td>11-15 Luglio<input type="checkbox" name="settimana" value="due"/></td></tr>
<tr><td>Periodo 3</td><td>18-22 Luglio<input type="checkbox" name="settimana" value="tre"/></td></tr>
<tr><td>Periodo 4</td><td>25-29 Luglio<input type="checkbox" name="settimana" value="quattro"/></td></tr>
<tr><td>Periodo 5</td><td>1-5 Agosto<input type="checkbox" name="settimana" value="cinque"/></td></tr>
<tr><td>Periodo 6</td><td>8-12 Agosto<input type="checkbox" name="settimana" value="sei"/> <i>(Questa Settimana avr&agrave; luogo solo al raggiungimento del numero minimo di partecipanti)</i></td></tr>
-->
<tr><td colspan="2"><center>Dati Ragazzo</td></tr>
<tr><td>Nome</td><td><input id="nomeRagazzo" type="text" name="nome" value="" /></td></tr>
<tr><td>Cognome</td><td><input id="cognomeRagazzo" type="text" name="cognome" value="" /></td></tr>
<tr>
<td>Attesa<input type="radio" name="stato" value="false" /></td>
<td>Comfermato<input type="radio" name="stato" value="true" /></td>	
</tr>
<tr><td>Anno di Nascita</td><td><input id="anno_nascita" type="text" name="nascita" value=""  disabled ></td></tr>

<tr><td colspan="2" align="right"><input type="submit" name="cerca" value="cerca"></td></tr> 




</table>
</s:form>
</div>
<div id="calendario" ></div>