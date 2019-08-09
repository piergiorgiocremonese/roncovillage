<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
function fill(){
	return true;
}
</script>
<div id="blockcnt" >

 
 <p><center>Settimana <s:property value="periodo.ordine"/></center></p>
 
<s:form name="updPeriodo" action="updPeriodo"  method="POST" onsubmit="return fill();" >
<s:if test="%{nuovo!=true}">
<s:hidden name="periodoOid" value="%{periodo.oid}"/>

</s:if>



<s:textfield label="Ordine" name="ordine" value="%{periodo.ordine}" />
<s:textfield label="Inizio:" name="inizio" value="%{periodo.formattedInizio}" onclick="return showCalendar('updPeriodo_inizio', 'calendario', '%d/%m/%Y');"/>
<s:textfield label="Fine:" name="fine" value="%{periodo.formattedFine}" onclick="return showCalendar('updPeriodo_fine', 'calendario', '%d/%m/%Y');"/>
<s:textfield label="Numero Massimo Iscrizioni:" name="numeroMassimo" value="%{periodo.numeroMassimo}" />
<s:checkbox label="Libero" name="libero" fieldValue="true" value="%{periodo.libero}" />
<tr><td><b>Numero Iscritti (confermati):</b></td><td><s:property value="numeroCorrente"/></td></tr>
<tr><td><b>Lista Iscritti:</b></td><td><a href="search?anno=<s:property value="anno"/>&settimana=<s:property value="periodo.oid"/>">Guarda</a></td></tr>

<s:submit value="salva" /> 

</s:form>

</div>
<div id="calendario" ></div>