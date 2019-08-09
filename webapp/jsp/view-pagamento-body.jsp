<%@taglib prefix="s" uri="/struts-tags" %>



<script type="text/javascript">


function checkform(){
        var x= document.getElementById('updPagamento_amount').value;
        x.replace('.',',');
        document.getElementById('updPagamento_amount').value=x;
        return true;
}


function sendKO(){
	alert('non posso inviare causa manacanza indirizzo mail');
}

function send(ragazzoOid,div){
	var html = document.getElementById("document").innerHTML;
	
	//document.getElementById('header').innerHTML='<img src="images/logo.jpg">';
	document.getElementById('toolbar').innerHTML='';
	document.getElementById('lineaBottoni').innerHTML='';
	document.getElementById('head').innerHTML='<title>RoncoVillage</title>';
	
	//heads[0].innerHTML = '<title>RoncoVillage</title>';
	var els = document.getElementsByTagName('script');
	for (var i=0;i<els.length;i++){
			els[i].innerHTML='';
		}
	/*
	var euros = document.getElementsByTagName('euro');
	for (var i=0;i<euros.length;i++){
		alert('metto il simbolo &euro;');
		euros[i].innerHTML='&euro;';
		}
	*/
	var els = document.getElementsByName('periodifrequenza');
	for (var i=0;i<els.length;i++){
		var inp = els[i].getElementsByTagName('input');
		if ((inp!=null)&&(inp.length>0)){
			if (inp[0].hasAttribute('checked')){
					var v = inp[0].getAttribute("checked");
						
				}
			else{
				els[i].innerHTML='';
				}
			}
		}
	//document.getElementById('header').innerHTML=header;
	var txt = document.getElementById("document").innerHTML; 
	txt = '<html>'+txt+'</html>';
	var url = "/ronco/sendPdf?ragazzoOid="+ragazzoOid;	
	//var par = "ragazzoOid="+ragazzoOid+"&doc="+txt;
	var xmlHttpReq = false;
    var self = this;
	//par=escape(par);
	if (window.XMLHttpRequest) {
         self.xmlHttpReq = new XMLHttpRequest();
	}else if (window.ActiveXObject) {
             self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    }
	self.xmlHttpReq.open('POST',url,false);
	//self.xmlHttpReq.setRequestHeader('Content-Type',  'application/x-www-form-urlencoded');
//    self.xmlHttpReq.setRequestHeader("Content-length", par.length);

    self.xmlHttpReq.onreadystatechange = function() {
		if (self.xmlHttpReq.readyState == 4) {
			
        	var str = self.xmlHttpReq.responseText;
        	document.getElementById('document').innerHTML = html;
			document.getElementById(div).innerHTML = str;

		}
    }
     //alert('invio'+par);
    self.xmlHttpReq.send(txt);
		
}

function stampa(){
	//var header = document.getElementById('header').innerHTML;
	var tb = document.getElementById('toolbar').innerHTML;
	var l = document.getElementById('lineaBottoni').innerHTML;
	//document.getElementById('header').innerHTML='<img src="images/logo.jpg">';
	document.getElementById('toolbar').innerHTML='';
	document.getElementById('lineaBottoni').innerHTML='';
	var els = document.getElementsByName('periodifrequenza');
	for (var i=0;i<els.length;i++){
		var inp = els[i].getElementsByTagName('input');
		if ((inp!=null)&&(inp.length>0)){
			if (inp[0].hasAttribute('checked')){
					var v = inp[0].getAttribute("checked");
				
				}
			else{
				els[i].innerHTML='';
				}
			}
		}
	window.print();
	//document.getElementById('header').innerHTML=header;
	document.getElementById('toolbar').innerHTML=tb;
	document.getElementById('lineaBottoni').innerHTML=l;
	
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

function aggiorna(id){
	var x = document.getElementById('periodo'+id);
	if (x.hasAttribute('checked')){
		x.removeAttribute('checked');
		}
	else{
		x.setAttribute('checked',true);
		}
}


</script>
<div id="blockcnt" >
<br/><br/>

<table>
<tr><td colspan="3" align="center"><b>Ricevuta di Pagamento: RoncoVillage</b></td></tr>

<tr><td><b>Ricevuta Numero</b>:</td><td><s:property value="pagamento.numero"/>/<s:property value="pagamento.anno"/> &nbsp;&nbsp;<b>Importo:</b> &nbsp;&nbsp;<euro>&euro;</euro><s:property value="pagamento.formattedAmount"/></td></tr>
<tr><td><b>RICEVIAMO Da: </b></td><td><s:property value="soggetto" /></td></tr>
<tr><td>Codice Fiscale:</td><td><s:property value="codicefiscale"/></td></tr> 
<tr><td>La somma di: </td><td><euro>&euro;</euro> <s:property value="pagamento.formattedAmount"/> (<s:property value="amountAsString"/>)  </td></tr>
<tr><td colspan="3">
<s:if test="%{pagamento.causale==''}">
Per attivita' sportiva svolta a RoncoVillage da <s:property value="pagamento.ragazzo.cognome"/>&nbsp;<s:property value="pagamento.ragazzo.nome"/>
</s:if>
<s:else>
<s:property value="pagamento.causale" escapeHtml="false"/> 
 </s:else>
 </td></tr>
<tr><td>Nato a:</td><td>&nbsp;<s:property value="pagamento.ragazzo.cittaNascita"/></td></tr> 
<tr><td>Il:</td><td><s:property value="pagamento.ragazzo.formattedDataNascita" /></td>
<tr><td>Indirizzo: </td><td><s:property value="pagamento.ragazzo.indirizzo" />&nbsp;<s:property value="pagamento.ragazzo.cap" />&nbsp;<s:property value="pagamento.ragazzo.citta" /> </td></tr>
<tr><td>Periodi di Riferimento</td></tr> 


<s:iterator  value="periodiPagati" status="stat">
<!-- <tr><td><s:property value="periodi.formattedInizio"/></td><td><s:property value="periodi.formattedFine"/>&nbsp;<input type="checkbox" name="periodo" checked ></input></td></tr>-->
<tr name="periodifrequenza"><td colspan="3"><input id="periodo<s:property value="#stat.index"/>" type="checkbox" name="periodo" onclick="aggiorna('<s:property value="#stat.index" />')" checked >&nbsp;<s:property value="periodi.formattedInizio"/>&nbsp;-&nbsp;<s:property value="periodi.formattedFine"/></input></td></tr> 
</s:iterator>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td>Modalita pagamento:</td><td><s:property value="pagamento.tipo"/></td></tr>
<tr><td>Riferimento:</td><td><s:property value="pagamento.riferimento"/></td></tr>

<tr><td>Data: </td><td><s:property value="pagamento.formattedData"/></td></tr>

<tr id="lineaBottoni">
<td><a href="viewPagamento?oid=<s:property value="pagamento.oid"/>&mode=upd"><input type="button" value="Modifica" /></a></td>
<td><input type="button" value="Stampa Fattura" onclick="javascript:stampa();"/></td>
<s:if test="%{pagamento.ragazzo.emailPadre!=''}">
<td><input type="button" value="Invia Fattura via Email" onclick="javascript:send('<s:property value="pagamento.ragazzo.oid"/>','blockcnt');"/></td>

</s:if>
<s:else>
<s:if test="%{pagamento.ragazzo.emailMadre!=''}">
<td><input type="button" value="Invia Fattura via Email" onclick="javascript:send('<s:property value="pagamento.ragazzo.oid"/>','blockcnt');"/></td>
</s:if>
<s:else>
<td><input type="button" value="Invia Fattura via Email" disabled="true"  onclick="javascript:send('<s:property value="pagamento.ragazzo.oid"/>','blockcnt');"/></td>

</s:else>
</s:else>

</tr>
</table>
</div>