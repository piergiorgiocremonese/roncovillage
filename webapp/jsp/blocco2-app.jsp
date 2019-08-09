<%@taglib prefix="s" uri="/struts-tags" %>



<script>
function showModuli(jsonstring){
	var html = '<ul>';
	var json = JSON.parse(jsonstring);
	if (json.hasOwnProperty('iscrizione')){
		html = html + '<li> Modulo di iscrizione con la liberatoria per la privacy:';
		html = html + '<a href="'+json.iscrizione+'"><input type="button" value="Scarica Modulo Iscrizione" name="scarica"/></a></li>';
	}
	if (json.hasOwnProperty('liberatoria')){
		html = html + '<li> Informativa trattamento dati personali:
		html = html + '<a href="'+json.liberatoria+'"><input type="button" value="Scarica Informativa" name="scarica"/></a></li>';
	}
	if (json.hasOwnProperty('vaccinazioni')){
		html = html + '<li> Modulo relativo alla copertura sanitaria (vaccinazioni):
		html = html + '<a href="'+json.vaccinazioni+'"><input type="button" value="Scarica Informativa" name="scarica"/></a></li>';
	}
	html = html + '</ul>
}

</script>

<div id="info">


<script>
jsonstring=<s:property value="contenuti[1]"/>;
<s:property value="code[1]"/>

</script>

