<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">



    




function showMailBox(){
	//tinymce.init({ selector:'textarea' });
	//alert('parte lo show');
	var td = document.createElement("td");
	td.setAttribute("colspan","8");
	var ta = document.createElement("textarea");
	ta.setAttribute("id","mailtext");
	ta.setAttribute("name","mailtext");
	ta.setAttribute("row","5");
	ta.setAttribute("cols","40");
	var b = document.createElement("button");
	b.setAttribute("id","invio");
	var t =  document.createTextNode("Invia");
	b.appendChild(t)
	td.appendChild(ta);
	td.appendChild(b);
	document.getElementById('mailbox').appendChild(td);
	//var text = '<td colspan="8"><textarea id="mailtext" name="mailtext" rows="5" cols=40/></textarea><br/>';
	//text = text + '<button id="invio"/>Invia</button></td>';
	//document.getElementById('mailbox').innerHTML=text;
	tinymce.init({ selector:'textarea' });
	//tinymce.get("mailtext").insertContent('<p><img src="http://www.roncovillage.it/ronco/images/logo2-mini.png"/> </p> ');
		
	//alert('finito lo show');
	
}

function send(list,body,div){
	
	var url = '/ronco/sendMailToCustomers';	
	var par = 'mode=flat&oidList='+list+'&body='+body;
	var encoded = escape(par);
	//alert('invio ' + encoded + '   a ' + list);
	//var par = "ragazzoOid="+ragazzoOid+"&doc="+txt;
	//var xmlHttpReq = false;
    //var self = this;
    var self = new XMLHttpRequest();
	//par=escape(par);
	if (window.XMLHttpRequest) {
         self = new XMLHttpRequest();
	}else if (window.ActiveXObject) {
             self= new ActiveXObject("Microsoft.XMLHTTP");
    }
	self.open('POST',url,true);
	self.setRequestHeader('Content-type',  'application/x-www-form-urlencoded');
	//self.setRequestHeader('Content-Type',  'text/plain');
	alert('invio'+par + ' a '+list);
	//self.xmlHttpReq.setRequestHeader("Content-length", par.length);
	
    self.onreadystatechange = function() {
		if (self.readyState == 4) {
			
        	var str = self.responseText;
			document.getElementById(div).innerHTML = "Mail Inviata con successo";

		}
    }
    self.send(encoded);
     
    
		
}

function sendMail(){	
	//var textMail = document.getElementById('mailtext').value;
	var textMail = tinymce.activeEditor.getContent();
	var oidList = '';
	var list =  document.getElementsByName('advice');
	for (var i=0;i<list.length;i++){
		//alert('valore ' +list[i].value + ' vale ' + list[i].checked);
		if (list[i].checked){
			if (oidList == ''){
				oidList = list[i].value;
			}else{
				oidList = oidList + ";"+list[i].value;
			}
		}
	}
	//alert ('invio mail text ' + textMail + ' a ' + oidList);
	 send(oidList,textMail,'mailbox')
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
//tinymce.init({ selector:'textarea' });

</script>
<div id="blockcnt" >
<table>
<tr><td colspan="5" align="center"><b>Lista Iscritti</b></td></tr>
<tr><td>&nbsp;</td><td>Cognome</td><td>Nome</td><td>Anno di nascita</td><td>Stato</td><td colspan="3">Azioni</td></tr>
<s:iterator var="p" value="ragazzi" status="stat">
<tr>
<td><s:property value="#stat.index+1" /></td>
<td><s:property value="cognome" /></td>
<td><s:property value="nome" /></td><td><s:property value="annoNascita" /></td>
<td><s:property value="approved"/></td>
<td><a href="viewRagazzo?oid=<s:property value="oid" />&code=<s:property value="code" />&anno=<s:property value="anno" />">Guarda</a></td>
<td><a href="listaPagamenti?ragazzoOid=<s:property value="oid" />&anno=<s:property value="anno" />" >Pagamenti</a></td>
<td><a href="listaPresenze?oid=<s:property value="oid" />&anno=<s:property value="anno" />" >Presenze</a></td>
<td><input id="advice<s:property value="#stat.index" />" type="checkbox" name="advice" value="<s:property value="oid"/>"/></td>

</tr>
</s:iterator>
<tr>
<td>
<a href="downloadIscritti?anno=<s:property value="anno" />&periodoOid=<s:property value="periodoOid" />">
<input type="button" value="scarica" name="scarica" onclick="">
</a>
</td>
<!-- <td><input type="button" id="contatta" value="contatta" name="contatta" onclick="showMailBox()" /></td> -->
<td><input type="button" id="contatta" value="contatta" name="contatta" /></td>

<tr id="mailbox">
<!-- <td colspan="8"><textarea id="mailtext" name="mailtext" rows="5" cols=40/></textarea><br/>
'<button id="invio"/>Invia</button> -->
</td>

</tr>


</table>
</div>
<script>


	$("#contatta").click(function(){
		//alert('aggiorno mailbox');
		
		showMailBox();
		
	});




//tinymce.get("mailtext").insertContent('');
</script>

<script>

$(document).on('click', '#invio',  function(){
		var textMail =  tinymce.get("mailtext").getContent();
    	textMail = textMail + '<br/><p><img src="http://www.roncovillage.it/ronco/images/logo2-mini.png"/> </p> ';
    	//var ok = escape(textMail);
		var oidList = '';
			var list =  document.getElementsByName('advice');
		for (var i=0;i<list.length;i++){
		//alert('valore ' +list[i].value + ' vale ' + list[i].checked);
			if (list[i].checked){
				if (oidList == ''){
					oidList = list[i].value;
				}else{
					oidList = oidList + ";"+list[i].value;
				}
			}
		}
		//alert ('invio mail text ' + textMail + ' a ' + oidList);
		var url = '/ronco/sendMailToCustomers';	
	
        $.post(url,
        {
          body: textMail,
          mode: "flat",
          oidList: oidList
        },
        function(data,status){
        	var json = data;
           document.getElementById('mailbox').innerHTML='<td colspan="8">'+json.esito + ':'+json.msg+'</td>';
        });
        //alert('fatto');
    });


</script>