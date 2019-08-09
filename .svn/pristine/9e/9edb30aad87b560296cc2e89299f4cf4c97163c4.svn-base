<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
function fill(){
	return true;
}
</script>
<div id="blockcnt" >

 
 
<s:form name="saveTipo" action="saveTipo"  method="POST" onsubmit="return fill();" >
<s:hidden name="oid" value="%{tipologia.oid}"/>


<s:textfield label="Forma pagamento/frequenza" name="forma" value="%{tipologia.forma}" />
<s:textfield label="Costo Totale Periodo (individuale):" name="costo" value="%{tipologia.costoTotale}" />
<s:select label="Tipo Periodo" headerKey="%{tipo}" headerValue="%{tipo}" name="tipo"  list="tipi" />
<s:select label="Numero Settimane Periodo" headerKey="%{numSettimane}" headerValue="%{numSettimane}" name="numSettimane"  list="numeroSettimane" />
<s:checkbox label="Familiare(prevede più fratelli)" name="familiare" fieldValue="true" value="%{tipologia.familiare}" />
<s:checkbox label="Mensa" name="mensa" fieldValue="true" value="%{tipologia.mensa}" />
<s:checkbox label="Giorno completo" name="fullDay" fieldValue="true" value="%{tipologia.fullDay}" />
<s:submit value="salva" /> 

</s:form>
</div>
