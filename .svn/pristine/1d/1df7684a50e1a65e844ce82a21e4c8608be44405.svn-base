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
<s:form name="aggiorna" action="aggiorna" enctype="multipart/form-data" method="POST" onsubmit="return fill();" >
<s:hidden name="oid" value="%{ragazzo.oid}"/>
<s:hidden name="code" value="%{code}"/>

<table border="1" id="tableForm">
<tr><td colspan="2"><center>Periodo</td></tr>
<s:iterator value="periodiList" >

<s:checkbox  label="Periodo %{ordine}: %{formattedInizio}-%{formattedFine}" name="settimana" fieldValue="%{ordine}" value="%{attivo}" />
</s:iterator>
<tr><td colspan="2"><center>Dati Ragazzo</td></tr>
<tr><td>Nome</td><td><input id="nomeRagazzo" type="text" name="nome" value="<s:property value="ragazzo.nome"/>" /></td></tr>
<tr><td>Cognome</td><td><input id="cognomeRagazzo" type="text" name="cognome" value="<s:property value="ragazzo.cognome"/>" /></td></tr>
<tr><td>Indirizzo</td><td><input type="text" name="indirizzo" value="<s:property value="ragazzo.indirizzo"/>" /></td></tr>
<tr><td>Classe ferquentata</td><td>
</td></tr>
<tr><td>Anno di Nascita</td><td><input id="data_nascita" type="text" name="nascita" value="<s:property value="ragazzo.annoNascita"/>" ></td></tr>
<tr><td>Altri Fratelli iscritti:</td><td></td></tr>
</td></tr>
<tr><td colspan="2"><center>Dati Genitori</td></tr>
<tr><td>Nome Padre</td><td><input id="nomePadre" type="text" name="nomepadre" value="<s:property value="ragazzo.padre"/>" /></td></tr>
<tr><td>Codice Fiscale Padre</td><td><input type="text" name="codfiscpadre" value="<s:property value="ragazzo.codfiscPadre"/>" /></td></tr>

<tr><td>Nome madre</td><td><input id="nomeMadre"  type="text" name="nomemadre" value="<s:property value="ragazzo.madre"/>" /></td></tr>
<tr><td>Codice Fiscale Madre</td><td><input type="text" name="codfiscmadre" value="<s:property value="ragazzo.codfiscMadre"/>" /></td></tr>
<tr><td>Nome accompagnatore</td><td><input type="text" name="accompagnatore" value="<s:property value="ragazzo.accompagnatore"/>" /></td></tr>
<tr><td>Telefono casa</td><td><input id="telefonoCasa" type="text" name="telcasa" value="<s:property value="ragazzo.telcasa"/>" /></td></tr>
<tr><td>Cellulare padre</td><td><input id="cellPadre"  type="text" name="cellpadre" value="<s:property value="ragazzo.cellPadre"/>" /></td></tr>
<tr><td>Cellulare madre</td><td><input id="cellMadre" type="text" name="cellmadre" value="<s:property value="ragazzo.cellMadre"/>" /></td></tr>
<!-- <tr><td>Telefono lavoro padre</td><td><input type="text" name="telwp" value="" /></td></tr>
<tr><td>Telefono lavoro madre</td><td><input type="text" name="telwm" value="" /></td></tr>
<tr><td>Telefono accompagnatore</td><td><input type="text" name="telacc" value="" /></td></tr>-->
<tr><td>email padre</td><td><input id="emailPadre" type="text" name="emailpadre" value="<s:property value="ragazzo.cellPadre"/>" /></td></tr>
<tr><td>email madre</td><td><input id="emailMadre" type="text" name="emailmadre" value="<s:property value="ragazzo.cellMadre"/>" /></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2"><center>Dati Generali</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2"><center>Allergie</td></tr>
<tr><td>Allergie alimentari</td><td><input type="text" name="allal" value="<s:property value="ragazzo.allergie"/>" /></td></tr>
<tr><td>Precauzioni sanitarie</td><td><textarea name="allsan" rows="5" cols=40/><s:property value="ragazzo.intolleranze"/></textarea></td></tr>
<tr id="altro">Documentazione</tr>
<s:iterator value="ragazzo.allegati" status="stat" >
<tr><td><s:property value="nome"/></td><td><a target="_blank" href="download?file=<s:property value="path"/>" >Guarda</a></td></tr>
</s:iterator>
<tr><td colspan=2">Aggiungere Documentazione</td></tr>
<s:file name="fileUpload" label="Documentazione" size="80" />
<s:textfield name="fileName" label="Nome documento" value="" size="80"/>

<s:textfield name="fileType" label="Tipo" value=""/>
<s:textfield name="fileDesc" label="Descrizione" value=""/>

<tr><td colspan="2"><input type="submit" name="aggiorna" value="aggiorna"/></td></tr>
 </table>
 </s:form>
</div>

