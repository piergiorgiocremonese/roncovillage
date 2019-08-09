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

function showInfo(){

	alert("periodi richiesti inconsistenti con forma di pagamento");
	document.getElementById('textArea').innerHTML="<p>periodi richiesti inconsistenti con forma di pagamento</p>";
}

</script>
<div id="blockcnt" >
<table>
<tr><td colspan="5" align="center"><b>Stato Pagamenti</b></td></tr>
<tr><td></td><td>Nome</td>
<td>Numero Periodi</td>
<td>Costo</td>
<td>Costo Scontato</td>
<td>Sconto</td>
<td>Pagato</td>
<td>Rimanenza</td>
</tr>
<s:iterator var="p" value="schede" status="stat">
<s:if test="%{ok}">
<s:if test="%{resto>0}">
<font color="red">
<tr>
<td><s:property value="#stat.index+1"/>&nbsp;</td>
<td class="kotext">
<a class="kotext" href="viewRagazzo?oid=<s:property value="ragazzo.oid"/>&code=<s:property value="ragazzo.code" />" >
<s:property value="ragazzo.cognome" />&nbsp;<s:property value="ragazzo.nome" />
</a></td>
<td class="kotext" align="center"><s:property value="numeroPeriodi" /></td>
<td class="kotext"><s:property value="dovutoNoSconto" /></td>
<td class="kotext"><s:property value="dovutoSconto" /></td>
<td class="kotext"><s:property value="sconto" /></td>
<td class="kotext"><s:property value="pagato" /></td>
<td class="kotext"><s:property value="resto" /></td>
</tr>
</font>
</s:if>
<s:else>
<font color="green">
<tr>
<td><s:property value="#stat.index+1"/>&nbsp;</td>
<td class="oktext">
<a class="oktext" href="viewRagazzo?oid=<s:property value="ragazzo.oid"/>&code=<s:property value="ragazzo.code" />" >
<s:property value="ragazzo.cognome" />&nbsp;<s:property value="ragazzo.nome" />
</a></td>
<td class="oktext" align="center"><s:property value="numeroPeriodi" /></td>
<td class="oktext"><s:property value="dovutoNoSconto" /></td>
<td class="oktext"><s:property value="dovutoSconto" /></td>
<td class="oktext"><s:property value="sconto" /></td>
<td class="oktext"><s:property value="pagato" /></td>
<td class="oktext"><s:property value="resto" /></td>
</tr>
</font>
</s:else>
</s:if>
<s:else>
<font color="blue">
<tr>
<td onmouseover="javascript:showInfo()">*&nbsp;<s:property value="#stat.index+1"/>&nbsp;</td>
<td class="unconstext">
<a class="unconstext" href="viewRagazzo?oid=<s:property value="ragazzo.oid"/>&code=<s:property value="ragazzo.code" />" >
<s:property value="ragazzo.cognome" />&nbsp;<s:property value="ragazzo.nome" />
</a></td>
<td class="unconstext" align="center"><s:property value="numeroPeriodi" /></td>
<td class="unconstext"><s:property value="dovutoNoSconto" /></td>
<td class="unconstext"><s:property value="dovutoSconto" /></td>
<td class="unconstext"><s:property value="sconto" /></td>
<td class="unconstext"><s:property value="pagato" /></td>
<td class="unconstext"><s:property value="resto" /></td>
</tr>
</font>

</s:else>
</s:iterator>
<tr><td colspan="5" align="right"><a href="downloadQuadro?anno=<s:property value="anno"/>"><input type="button" value="scarica"></a></td></tr>
</table>
<div id="textArea"></div>
</div>
