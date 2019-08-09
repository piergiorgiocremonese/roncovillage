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
<div id="info-blk" style="position:relative;left:25px;width:1230px">
<br/><br/>
<p><center><b>Sezione Documenti</b></center></p>

<table border="1">
<tr><td>Nome</td><td>Anno</td>td>Tipo</td><td><Keywords</td><td colspan="3">Azioni</td></tr>
<s:iterator value="list" >
<tr>
<td><s:property value="nome"/></td><td><s:property value="anno"/></td>
<td><s:property value="tipo"/></td>
<td><s:property value="keywords"/></td> 
<td><a href="<s:property value="url"/>"><input type="button" value="Scarica"/></a><td>
<td><a href="showDoc?op=upd&oid=<s:property value="oid"/>" ><input type="button" value="Modifica"/></a></td>
<td><a href="#" ><input type="button" value="Elimina"/></a></td>
</tr>
</s:iterator>
</table>



</div>