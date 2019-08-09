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


function checkform(){
	var x= document.getElementById('registraPagamento_amount').value;
	x.replace('.',',');
	document.getElementById('registraPagamento_amount').value=x;
	return true;
}
</script>
<div id="blockcnt" >
<table>
<tr><td colspan="5" align="center"><b>Lista Pagamenti effettuati per  <s:property value="ragazzo.nome" />&nbsp;<s:property value="ragazzo.cognome" /></b> anno: <s:property value="anno" /></td></tr>
<tr><td>Riferimento</td><td>Modalita</td><td>Ammontare</td><td>Data</td><td></td></tr>
<s:iterator var="p" value="pagamenti" status="stat">
<tr>
<td><s:property value="riferimento" /></td>
<td><s:property value="tipo" /></td>
<td><s:property value="amount" /></td><td><s:property value="formatDate" /></td>
<td><a href="viewPagamento?oid=<s:property value="oid" />" >Visualizza</a></td> 
</tr>
</s:iterator>
</table>

<s:if test="%{showForm}">
<s:form name="registraPagamento" action="registraPagamento" method="POST" onsubmit="javascript:checkform();">
<s:hidden name="ragazzoOid" value="%{ragazzo.oid}" />
<s:hidden name="nuovoPagamento" value="true" />

<s:textfield label="Importo" name="amount" value="%{totDaPagare}" />
<s:select label="Modalita pagamento" name="tipo" headerKey="" headerValue="" list="tipiPagamento" />
<s:textfield label="Riferimento" name="riferimento" value="" />
<tr><td>Data Pagamento</td><td><input id="dataPagamento" type="text" name="dataPagamento" value="<s:property value="dataPagamento" />"  onclick="return showCalendar('dataPagamento', 'calendario', '%d/%m/%Y');"></td></tr>
<tr><td>Causale</td><td>
<textarea name="causale" rows="5" cols=40/>

Per attivita' sportiva svolta a RoncoVillage da <s:property value="ragazzo.nome" />&nbsp; <s:property value="ragazzo.cognome" />
</textarea>
</td></tr>

<!--<s:textfield label="Data Pagamento" name="dataPagamento" value="%{dataPagamento}" />-->
<s:submit value="Registra" name="registra" />
</s:form>



</s:if>
<div id="calendario" ></div>
</div>
