<%@taglib prefix="s" uri="/struts-tags" %>
<script>

function stampa(){
	if (!window.print){
		alert("Browser non supportato!");
		return;
	}
	
	
	var txtCmd = document.getElementById('command').innerHTML;
	var txtTool = document.getElementById('toolbar').innerHTML;
	var txtRep = document.getElementById('report').innerHTML;
	
	//var txtFooter = document.getElementById('footer').innerHTML;
	//var txtLeft = document.getElementById('contentLeft').innerHTML;
	//var txtToolBar = document.getElementById('toolbar').innerHTML;
	//document.getElementById('top').innerHTML='';
	document.getElementById('command').innerHTML='';
	document.getElementById('toolbar').innerHTML='';
	document.getElementById('report').innerHTML='';
	
	window.print();
	document.getElementById('command').innerHTML=txtCmd;
	document.getElementById('toolbar').innerHTML=txtTool;
	document.getElementById('report').innerHTML=txtRep;
	
	//document.getElementById('footer').innerHTML=txtFooter;
	//document.getElementById('contentLeft').innerHTML=txtLeft;
	//document.getElementById('toolbar').innerHTML=txtToolBar;
	
}




function selectAll(){
	var listp=document.getElementsByName('presente');
	for (var i=0;i<listp.length;i++){
		var e = listp[i];
		e.setAttribute("checked","checked");
				
	}
	var listm=document.getElementsByName('mensa');
	for (var i=0;i<listm.length;i++){
		var e = listm[i];
		e.setAttribute("checked","checked");
				
	}
	
	var listc=document.getElementsByName('completo');
	for (var i=0;i<listc.length;i++){
		var e = listc[i];
		e.setAttribute("checked","checked");
				
	}
}
</script>


<div id="blockcnt" >
<table>
<tr><td>Seleziona tutti (presenze/mensa/completo)</td>
<td><input type="checkbox" name="all" onclick="javascript:selectAll()" /></td>
</tr>
<s:form name="presenze" action="savePresenze" method="POST" >

<tr><td colspan="12" align="center"><b>Lista Presenze giornaliere <s:property value="periodo" /> giorno: <s:property value="sgiorno"/></b></td></tr>
<tr><td>&nbsp;</td><td>Cognome</td><td>Nome</td><td colspan="2">Presenza</td><td colspan="2">Mensa</td><td colspan="2">Completo</td><td colspan="2">Mattina</td><td colspan="2">Pomeriggio</td></tr>
<s:hidden name="sgiorno" value="%{sgiorno}"/>
<s:iterator var="p" value="registro" status="stat">

<tr>
<s:hidden name="ragazzoOid" value="%{ragazzi.oid}"/>
<td><s:property value="#stat.index+1"/></td>
<td><s:property value="ragazzi.cognome" /></td>
<td><s:property value="ragazzi.nome" /></td>

<td>Presente </td><td>

<s:if test="%{presente}">
<input type="checkbox" name="presente" value="<s:property value="ragazzi.oid"/>" checked />
</s:if>
<s:else>
<input type="checkbox" name="presente" value="<s:property value="ragazzi.oid"/>" />
</s:else>
</td>
<td>Mensa </td><td>
<s:if test="%{mensa}">
<input type="checkbox" name="mensa" value="<s:property value="ragazzi.oid"/>"  checked/>
</s:if>
<s:else>
<input type="checkbox" name="mensa" value="<s:property value="ragazzi.oid"/>"  />
</s:else>
</td>
<td>Completo </td><td>
<s:if test="%{completo}">
<input type="checkbox" name="completo" value="<s:property value="ragazzi.oid"/>" checked />
</s:if>
<s:else>
<input type="checkbox" name="completo" value="<s:property value="ragazzi.oid"/>" />
</s:else>
</td>
<td>Mattina </td><td>
<s:if test="%{mattina}" >
<input type="checkbox" name="mattina" value="<s:property value="ragazzi.oid"/>" checked/>
</s:if>
<s:else>
<input type="checkbox" name="mattina" value="<s:property value="ragazzi.oid"/>" />
</s:else>
</td>
<td>Pomeriggio </td><td>
<s:if test="%{pomeriggio}">
<input type="checkbox" name="pomeriggio" value="<s:property value="ragazzi.oid"/>" checked/>
</s:if>
<s:else>
<input type="checkbox" name="pomeriggio" value="<s:property value="ragazzi.oid"/>"/>
</s:else>
</td>
</tr>
</s:iterator>
<tr id="command">
<td colspan="2">&nbsp;</td>
<td><input type="submit" value="Salva" name="Salva"/></td>
<td ><a href="javascript:stampa()"><img src="images/print2.png" ></a></td>

</tr>

</s:form>
</table>
<ul id="report">
<li>Numero presenti a mensa:<s:property value="numeroMensa" /></li>
<li>Numero presenti mattina:<s:property value="presentiMattina" /></li>
<li>Numero presenti pomeriggio:<s:property value="presentiPomeriggio" /></li>
</ul>
</div>