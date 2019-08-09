<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">

var privato = false;
var listaPeriodi = new Array();
function aggiornaPeriodo(id){
		//alert('aggiorno periodo ' + id);
        var x = document.getElementById('periodo'+id);
        if (x.hasAttribute('checked')){
                x.removeAttribute('checked');
                }
        else{
                x.setAttribute('checked',true);
                }
}

function ck(){
	alert('tarallo');
}


function clean(s){
	var ns = "";
	for (var i=0;i<s.length;i++){
		var c = s.charAt(i);
		if (s.charCodeAt(i)>122){
			
			var x = s.charCodeAt(i);
			switch (x){
				case 130:
						c="e'";
						break;
					case 133:
						c ="a'";
						break;
					case 138:
						c="e'";
						break;
					case 141:
						c = "i'";
						break;
					case 149:
						c="o'";
						break;
					case 151:
						c="u'";
						break;
					case 160:
						c="a'";
						break;
					case 161:
						c="i'";
						break;
					case 162:
						c="o'";
						break;
					case 163:
						c="u'";
						break;
					case 242:
						c="o'";
						break;
					case 224:
						c="a'";
						break;
					case 232:
						c="e'";
						break;
					case 233:
						c="e'";
						break;
						
					case 249:
						c="u'";
						break;
					default:
						c=" ";
						break;
			}
		}
		ns = ns + c;
		
	}
	return ns;
}

function fill(){
	alert('check form');
	var nrv = document.getElementById('nomeRagazzo').value;
	var cnrv = document.getElementById('cognomeRagazzo').value;
	var npv = document.getElementById('nomePadre').value;
	var nmv = document.getElementById('nomeMadre').value;
	var cnpv = document.getElementById('cognomePadre').value;
	var cnmv = document.getElementById('cognomeMadre').value;
	var tcv = document.getElementById('telefonoCasa').value;
	var cpv = document.getElementById('cellPadre').value;
	var cmv = document.getElementById('cellMadre').value;
	var dnv = document.getElementById('data_nascita').value;
	var cnv = document.getElementById('citta_nascita').value;
	var cfpv = document.getElementById('codfisc_padre').value;
	var cfmv = document.getElementById('codfisc_madre').value;
	var emv = document.getElementById('emailMadre').value;
	var epv = document.getElementById('emailPadre').value;
	var addrv = document.getElementById('indirizzo').value;
	var capv = document.getElementById('cap').value;
	var cittav = document.getElementById('citta').value;
	
	if ((nrv == '')||(cnrv=='')){
			alert('manca nome Ragazzo');
			return false;
	}else{
		var nnrv = clean(nrv);
		if (nrv != nnrv){
			alert('Nome corretto per carattere speciale');
			document.getElementById('nomeRagazzo').value=nnrv;
		}
		var ncnrv = clean(cnrv);
		if (ncnrv != ncnrv){
			alert('Cognome corretto per carattere speciale');
			document.getElementById('cognomeRagazzo').value=ncnrv;
		}
	}
	if ((npv == '')&&(nmv=='')){
		alert('manca nome almeno un Genitore');
		return false;
	}else{
		if ((npv != '')&&(cnpv == '')){
			alert('Nome genitore (Padre) non completo');
			return false;
		
		} else {
			if ((nmv != '')&&(cnmv == '')){
				alert('Nome Genitore (Madre) non completo ');
				return false;
			} 
		
		}
	}
	if ((tcv == '')&&(cpv=='')&&(cmv == '')){
		alert('manca contatto telefonico per almeno un Genitore');
		return false;
	}
	if ((epv == '')&&(emv=='')){
		alert('manca email per almeno un Genitore');
		return false;
	}
	
	if ((dnv == '')||(cnv=='')){
		alert('dati nascita non completi: data e/o citta');
		return false;
	}
	if ((cfpv == '')&&(cfmv=='')){
		alert('Manca un Codice Fiscale: indicare quello da riportare nella ricevuta');
		return false;
	}
	
	if ((addrv == '')||(capv == '')||(cittav == '')){
		alert('Manca indirizzo o indirizzo incompleto');
		return false;
	}
	//alert('definit ' + listaPeriodi.length);
	if (!privato){
	var num = 0;
	for (var i=0;i<listaPeriodi.length;i++){
		var x = document.getElementById(listaPeriodi[i]);
        if (x.hasAttribute('checked')){
        	num++;
        }
      //  alert('numero periodi = '+num);
        
	}
	if (num==0){
        	alert('Non sono stati specificati periodi da frequentare: per favore selezionare almeno un periodo');
        	return false;
    }
	}
	return true;
}

	

function getElement(type,name, label){
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
	var el = document.getElementById('tableForm');
	el.appendChild(getElement('file','fileUpload','Documento'));
	el.appendChild(getElement('text','fileName','Nome File'));
	el.appendChild(getElement('text','fileDesc','Descrizione'));
	el.appendChild(getElement('text','fileType','Tipo'));

	//el.appendChild(fel);
}


function verificaPeriodo(num,max){
	if (num>=max){
		alert('settimana gia completa: aggiornare stato settimana');
		return false;
	}
	/*
	else{
		alert('nuova iscrizione possibile');
	}
	*/
	
}

function avanti(divprev,divnext){
	document.getElementById(divprev).style['visibility']="hidden";
	
	document.getElementById(divnext).style['visibility']="visible";
	document.getElementById(divprev).style['top']="-300px";
	document.getElementById(divprev).style['left']="20px";
	
	//pe.style.left="30px"
	
}
</script>
<div id="blockcnt" >

 <s:set var="login" value="%{#session.LOGIN}"/>
 
 <s:set var="active" value=""/>
 <s:if test="%{#login==null}">
 <s:set var="active">disabled</s:set>
 </s:if>
 <s:set var="myaction">registra</s:set>
 <s:if test="%{code!=null}">
 <s:set var="myaction">aggiorna</s:set>
 </s:if>
  <s:if test="%{admin}">
 <script>
 privato = true;
 </script>
 </s:if>
<s:form name="registra" action="%{#myaction}" enctype="multipart/form-data" method="POST" onsubmit="return fill();" >
<table border="0" id="tableForm">
<s:hidden name="oid" value="%{ragazzo.oid}"/>
<s:hidden name="code" value="%{code}"/>
<s:hidden name="anno" value="%{anno}"/>

<s:hidden name="pageOid" value="%{pageOid}"/>

<tr><td colspan="1"><center><b>Scheda di iscrizione</b></center></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
</table>
<div id="dati-ragazzo" style="visibility:visible;" >
<table border="1">
<tr><td>Settimana (Selezionare le settimane desiderate)</td><td>&nbsp;</td></tr>
<s:iterator value="periodiList" status="stat">
<tr>
<td>Periodo: <s:property value="ordine"/>: <s:property value="formattedInizio"/>-<s:property value="formattedFine"/></td>
<td>
<s:if test="%{attivo}">
<s:if test="%{confermatoChecked=='checked'}">
Confermato
<input type="hidden" name="settimanaOid" value="<s:property value="oid"/>" />
<input type="hidden" name="settimanaStatoOid" value="<s:property value="oid"/>" />
<input type="hidden" name="tipologiaOid" value="<s:property value="tipologia.oid"/>" />
</s:if>
<s:else>
<input id="periodo<s:property value="#stat.index"/>" type="checkbox" name="settimanaOid" value="<s:property value="oid"/>" <s:property value="checked"/>  onclick="aggiornaPeriodo('<s:property value="#stat.index" />')" />

</s:else>
</s:if>
<s:else>
<s:if test="%{libero}">
<input id="periodo<s:property value="#stat.index"/>" type="checkbox" name="settimanaOid" value="<s:property value="oid"/>" <s:property value="checked"/>  onclick="aggiornaPeriodo('<s:property value="#stat.index" />')" />
</s:if>
<s:else>
<input id="periodo<s:property value="#stat.index"/>" type="checkbox" name="settimanaOid" value="<s:property value="oid"/>" <s:property value="checked"/>  onclick="aggiornaPeriodo('<s:property value="#stat.index" />')" disabled="disabled"/>
Settimana Completa
</s:else>
</s:else>

<s:else>

</s:else>

</td>

</tr>


<script>
listaPeriodi[<s:property value="#stat.index"/>]='periodo<s:property value="#stat.index"/>';
</script>


<!--<s:checkbox  label="Periodo %{ordine}: %{formattedInizio}-%{formattedFine}" name="settimana" fieldValue="%{ordine}" value="%{attivo}" />-->
</s:iterator>
<!-- 
<tr><td>Periodo 1</td><td>4-8 Luglio<input type="checkbox" name="settimana" value="1"/></td></tr>
<tr><td>Periodo 2</td><td>11-15 Luglio<input type="checkbox" name="settimana" value="2"/></td></tr>
<tr><td>Periodo 3</td><td>18-22 Luglio<input type="checkbox" name="settimana" value="3"/></td></tr>
<tr><td>Periodo 4</td><td>25-29 Luglio<input type="checkbox" name="settimana" value="4"/></td></tr>
<tr><td>Periodo 5</td><td>1-5 Agosto<input type="checkbox" name="settimana" value="5"/></td></tr>
<tr><td>Periodo 6</td><td>8-12 Agosto<input type="checkbox" name="settimana" value="6"/> <i>(Questa Settimana avr&agrave; luogo solo al raggiungimento del numero minimo di partecipanti)</i></td></tr>
 -->
<s:if test="%{login!=null}">
<s:textfield name="stato" label="Situazione" value="%{ragazzo.email}"/>

</s:if>
<tr><td colspan="1"><center><b>Dati Ragazzo</b></center></td></tr>
<tr><td>*Nome</td><td><input id="nomeRagazzo" type="text" name="nome" value="<s:property value="ragazzo.nome" />" /></td></tr>
<tr><td>*Cognome</td><td><input id="cognomeRagazzo" type="text" name="cognome" value="<s:property value="ragazzo.cognome" />" /></td></tr>
<tr><td>*Indirizzo</td><td><input id="indirizzo" type="text" name="indirizzo" value="<s:property value="ragazzo.indirizzo" />" /></td></tr>
<tr><td>*Citt&agrave;(indicare anche la Provincia se non capoluogo)</td><td><input id="citta" type="text" name="citta" value="<s:property value="ragazzo.citta" />" /></td></tr>
<tr><td>*CAP</td><td><input id="cap" type="text" name="cap" value="<s:property value="ragazzo.cap" />" /></td></tr>



<!-- <tr><td>Classe ferquentata</td><td>
<select name="classe" value="" />
<option value="p1">Prima primaria</option>
<option value="p2">Seconda primaria</option>
<option value="p3">Terza primaria</option>
<option value="p4">Quarta primaria</option>
<option value="p5">Quinta primaria</option>
<option value="s1">Prima media</option>
<option value="s2">Seconda media</option>
<option value="s3">Terza media</option>
</select>
</td></tr> -->

<s:select label="Classe Frequentata" name="classe" headerKey="%{classe}" headerValue="%{classe}" list="classi"  emptyOption="true" />
<tr><td>*Data di Nascita(gg/mm/aaaa)</td><td><input id="data_nascita" type="text" name="nascita" value="<s:property value="ragazzo.formattedDataNascita" />"  onclick="return showCalendar('data_nascita', 'calendario', '%d/%m/%Y');"></td></tr>
<tr><td>*Citt&agrave; di Nascita</td><td><input id="citta_nascita" type="text" name="cittaNascita" value="<s:property value="ragazzo.cittaNascita" />"  ></td></tr>
<s:if test="%{ragazzo.familiari}">
<tr><td>Altri Fratelli iscritti:</td><td>Si<input id="fatellisi" type="radio" name="fratelli" value="si" onchange="javascript:cambia('fratello','ok')" checked/>&nbsp;No<input id="fratellino" type="radio" name="fratelli" value="no" onchange="javascript:cambia('fratello','ko')"  /> </td></tr>
</td></tr>
<tr id="fratello">
<td><input type="text" name="fratellonome" value="<s:property value="ragazzo.fratelli"/>" /></td>
</tr>
</s:if>
<s:else>
<tr><td>Altri Fratelli iscritti:</td><td>Si<input id="fatellisi" type="radio" name="fratelli" value="si" onchange="javascript:cambia('fratello','ok')"/>&nbsp;No<input id="fratellino" type="radio" name="fratelli" value="no" onchange="javascript:cambia('fratello','ko')" checked /> </td></tr>
</td></tr>
<tr id="fratello"></tr>
</s:else>
<tr id="button-row-1"><td colspan="2"><input type="button" value="avanti" onclick="javascript:avanti('dati-ragazzo','dati-genitori')" /></td></tr>

<tr><td colspan="2">&nbsp;</td><tr>
<tr><td colspan="2">PS: I campi con asterisco sono obbligatori; indicare inoltre almeno un riferimento e un codice fiscale</td></tr>	  

</table>
<div id="calendario" ></div>
</div>
<div id="dati-genitori" style="position:absolute;visibility:hidden;top:100px;left:10px">
<table>
<tr><td colspan="1"><center><b>Dati Genitori</b></center></td></tr>
<tr><td>Nome Padre</td><td><input id="nomePadre" type="text" name="nomepadre" value="<s:property value="ragazzo.nomePadre" />" /></td></tr>
<tr><td>Cognome Padre</td><td><input id="cognomePadre" type="text" name="cognomepadre" value="<s:property value="ragazzo.cognomePadre" />" /></td></tr>

<tr><td>Codice Fiscale Padre</td><td><input id="codfisc_padre" type="text" name="codfiscpadre" value="<s:property value="ragazzo.codifiscPadre" />" /></td></tr>

<tr><td>Nome madre</td><td><input id="nomeMadre"  type="text" name="nomemadre" value="<s:property value="ragazzo.nomeMadre" />" /></td></tr>
<tr><td>Cognome madre</td><td><input id="cognomeMadre"  type="text" name="cognomemadre" value="<s:property value="ragazzo.cognomeMadre" />" /></td></tr>
<tr><td>Codice Fiscale Madre</td><td><input id="codfisc_madre" type="text" name="codfiscmadre" value="<s:property value="ragazzo.codfiscMadre" />" /></td></tr>
<tr><td>Nome accompagnatore</td><td><input type="text" name="accompagnatore" value="<s:property value="ragazzo.accompagnatore" />" /></td></tr>
<tr><td>Telefono casa</td><td><input id="telefonoCasa" type="text" name="telcasa" value="<s:property value="ragazzo.telcasa" />" /></td></tr>
<tr><td>Cellulare padre</td><td><input id="cellPadre"  type="text" name="cellpadre" value="<s:property value="ragazzo.cellPadre" />" /></td></tr>
<tr><td>Cellulare madre</td><td><input id="cellMadre" type="text" name="cellmadre" value="<s:property value="ragazzo.cellMadre" />" /></td></tr>
<tr><td>Telefono lavoro padre</td><td><input type="text" name="telwp" value="" /></td></tr>
<tr><td>Telefono lavoro madre</td><td><input type="text" name="telwm" value="" /></td></tr>
<tr><td>Telefono accompagnatore</td><td><input type="text" name="telacc" value="" /></td></tr>
<tr><td>email padre</td><td><input id="emailPadre" type="text" name="emailpadre" value="<s:property value="ragazzo.emailPadre" />" /></td></tr>
<tr><td>email madre</td><td><input id="emailMadre" type="text" name="emailmadre" value="<s:property value="ragazzo.emailMadre" />" /></td></tr>
<tr><td colspan="2"><b>Attenzione: </b>sono obbligatori almeno una email, un telefono e un Codice Fiscale dei genitori.<br/> La email specificata sar&agrave; utilizzata per le comunicazioni compreso invio ricevuta attribuita al codice fiscale indicato.</td></tr>
<tr id="button-row-2"><td colspan="2"><input type="button" value="avanti" onclick="javascript:avanti('dati-genitori','dati-generali')" /></td></tr>
<tr><td colspan="2">&nbsp;</td><tr>
<tr><td colspan="2">PS: I campi con asterisco sono obbligatori; indicare inoltre almeno un riferimento e un codice fiscale</td></tr>	  
</table>

</div>




<div id="dati-generali" style="position:absolute;top:10px;left:10px;visibility:hidden">
<table border="1">
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="1"><center><b>Dati Generali</b></center></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="1"><center><b>Allergie</b></center></td></tr>
<tr><td>Allergie alimentari</td><td><input type="text" name="allal" value="<s:property value="ragazzo.allergie" />" /></td></tr>
<tr><td>Precauzioni sanitarie</td><td><textarea name="allsan" rows="5" cols=40/><s:property value="ragazzo.intolleranze" /></textarea></td></tr>
 <s:if test="%{#login!=null}">
<tr><td>Sconto</td><td><input type="text" name="sconto" value="<s:property value="ragazzo.sconto"/>" /></td></tr>
</s:if>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="1"><center><b>Documentazione generale</b></center></td></tr>


<tr><td colspan="2">Aggiungere se possibile la documentazione necessaria (copia libretto sanitari, eventuali certificati medici, etc). </td></tr>
<s:iterator value="ragazzo.allegati" status="stat" >
<tr><td><s:property value="nome"/></td><td>
<s:if test="%{mime=='image/jpeg'}">
<a target="_blank" href="showImage?file=<s:property value="path"/>" >Guarda</a>
</s:if>
<s:else>
<a target="_blank" href="download?file=<s:property value="path"/>" >Guarda</a>
</s:else>

</td></tr>
</s:iterator>
<s:file name="fileUpload" label="Documentazione" size="80" />
<s:textfield name="fileName" label="Nome documento" value="" size="80"/>

<s:textfield name="fileType" label="Tipo" value=""/>
<s:textfield name="fileDesc" label="Descrizione" value=""/>
<tr id="altro"></tr>
<tr><td colspan="2"><input type="button" value="Aggiungi documento" name="altro" onclick="javascript:add()"></button> </td></tr>
<s:if test="%{#login==null}">
 
<tr><td colspan="1" align="right">	
<input type="submit" name="registra" value="registra"></td><td>
<input type="button" name="test" value="prova" onclick="javascript:ck()"/>
</td></tr> 

</s:if>
<s:else>
<tr>
<td><a href="deleteRagazzo?oid=<s:property value="ragazzo.oid"/>" ><input type="button" name="delete" value="delete"/></a></td>
<td>
<input type="submit" name="registra" value="registra"/>

</td>
</tr>
</s:else>
<tr><td colspan="2">&nbsp;</td><tr>
<tr><td colspan="2">PS: I campi con asterisco sono obbligatori; indicare inoltre almeno un riferimento e un codice fiscale</td></tr>	  

</table>
</div>
</s:form>

</div>

