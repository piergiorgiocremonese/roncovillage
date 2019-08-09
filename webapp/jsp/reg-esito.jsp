<%@taglib prefix="s" uri="/struts-tags" %>

<div id="blockcnt" >

<center>Registrazione avvenuta con successo</center>
<table border="1">
<tr><td colspan="2"><center>Dati Ragazzo</td></tr>
<tr><td>Nome</td><td><s:property value="ragazzo.nome"/></td></tr>
<tr><td>Cognome</td><td><s:property value="ragazzo.cognome"/></td></tr>
<tr><td>Indirizzo</td><td><s:property value="ragazzo.indirizzo"/></td></tr>
</table>
<p>
<b>Scarica i moduli di iscrizione e sanitario da consegnare firmati al Camp: </b>

<ul>
<s:if test="%{docList['iscrizione'] != null}">
<li>modulo di iscrizione con la liberatoria per la privacy: <a href="<s:property value="docList['iscrizione']"/>" target="_blank" ><input type="button" value="Scarica Modulo Iscrizione" name="scarica"/></a></li>
</s:if>
<s:if test="%{docList['vaccinazioni'] != null}">
<li>modulo relativo alla copertura sanitaria (vaccinazioni):<a href="<s:property value="docList['vaccinazioni']"/>" target="_blank" ><input type="button" value="Scarica Modulo Sanitario" /></a></li>
</s:if>
<s:if test="%{docList['liberatoria'] != null}">
<li>informativa per la privacy: :<a href="<s:property value="docList['liberatoria']" />" target="_blank" ><input type="button" value="Scarica Informativa per la Privacy" /></a></li>
</s:if>
</ul>
<!-- 
<a href="download?file=/var/docs/ronco/moduloiscrizioneroncovillage2018.pdf" target="_blank" >Scarica modulo di iscrizione</a> 
</p>
<p>
<a href="download?file=/var/docs/ronco/vaccinazioni.pdf" target="_blank" >Scarica modulo sanitario</a> 
-->
</p>

</div>
