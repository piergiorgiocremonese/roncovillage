<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">


function checkform(){
        var x= document.getElementById('updPagamento_amount').value;
        x.replace('.',',');
        document.getElementById('updPagamento_amount').value=x;
        return true;
}



function stampa(){
	//var header = document.getElementById('header').innerHTML;
	//var tb = document.getElementById('toolbar').innerHTML;
	//document.getElementById('header').innerHTML='';
	//document.getElementById('toolbar').innerHTML='';
	window.print();
	//document.getElementById('header').innerHTML=header;
	//document.getElementById('toolbar').innerHTML=tb;
	
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
<p><center><b>Pagamento</b></center></p>
<s:form name="updPagamento" action="updPagamento" method="POST" onsubmit="javascript:checkform()">
<s:hidden name="oid" value="%{pagamento.oid}" />
<s:hidden name="nuovoPagamento" value="false" />

<s:textfield label="Importo" name="amount" value="%{pagamento.amount}" />
<s:select label="Modalita pagamento" name="tipo" headerKey="%{pagamento.tipo}" headerValue="%{pagamento.tipo}" list="tipiPagamento" />
<s:textfield label="Riferimento" name="riferimento" value="%{pagamento.riferimento}" />
<!--<s:textfield label="Data Pagamento" name="dataPagamento" value="%{pagamento.formattedData}" />-->
<tr><td>Data Pagamento</td><td><input id="dataPagamento" type="text" name="dataPagamento" value="<s:property value="pagamento.formattedData" />"  onclick="return showCalendar('dataPagamento', 'calendario', '%d/%m/%Y');"></td></tr>
<tr><td>Causale</td><td><textarea name="causale" rows="5" cols=40/>
<s:if test="%{pagamento.causale==''}">
Per attivita' sportiva svolta a RoncoVillage da <s:property value="pagamento.ragazzo.cognome"/>&nbsp;<s:property value="pagamento.ragazzo.nome"/> 
</s:if>
<s:else>
<s:property value="pagamento.causale"/> 
 </s:else>
</textarea></td></tr>
<tr id="button-row">
<td><input type="button" value="Back" onclick="javascript:goBack();"/></td>
<td><input type="button" value="Stampa Fattura" onclick="javascript:stampa();"/></td>
</tr>
<s:submit value="Aggiorna" name="aggiorna"/>
</s:form>
<div id="calendario" ></div>
</div>
