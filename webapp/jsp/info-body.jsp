<%@taglib prefix="s" uri="/struts-tags" %>
<div id="info-blk" style="position:relative;left:25px;width:1230px">
<br/><br/>

<p><center><b>CENTRO ESTIVO RONCOVILLAGE 2017</b></center></p>
<br/><br/>
<p>Il <b>Camp Estivo Roncovillage</b>, in collaborazione con il Comune di Sestola, &egrave; rivolto a bambini dai 5/6 anni in su di tutte le famiglie residenti e agli ospiti che trascorrono una vacanza sul nostro territorio.
La sede del Centro Estivo &egrave; presso il Centro Sportivo Roncovillage a Roncoscaglia 
(Sestola) dal luned&igrave; al venerd&igrave; dalle ore 8,00 alle ore 17,30 a partire dal primo luned&igrave; del mese di luglio per protrarsi anche nel mese di agosto.
&Egrave; presente un servizio navetta da Sestola per Roncoscaglia e viceversa.
I pasti sono direttamente preparati nella cucina del centro sportivo.
<br/>
Sono possibili:
<ul>
<li>Turni settimanali</li>
<li>Ingressi giornalieri</li>
<li>Turni antimeridiani con pasto</li>
<li>Turni antimeridiani senza pasto</li>
</ul>
</p>
<br/><br/>
<p>
Le attivit&agrave; sono tenute da personale qualificato con indirizzo didattico, ludico ricreativo e di avviamento allo sport .
<br/>
Le quote di iscrizione:
<ul>
<li>1 settimana &euro; 130,00</li>
<li>2 settimane &euro; 250,00</li>
<li>3 settimane &euro; 360,00</li>
<li>4 settimane &euro; 460,00</li>
<li>5 settimane &euro; 540,00</li>
<li>6 settimane &euro; 600,00</li>
</ul>

</p>
<p>
<br/>
Per 2 fratelli :
<ul>
<li>1 settimana &euro; 240,00</li>
<li>2 settimane &euro; 460,00</li>
<li>3 settimane &euro; 640,00</li>
<li>4 settimane &euro; 800,00</li>
<li>5 settimane &euro; 900,00</li>
<li>6 settimane &euro; 1000,00</li>
</ul>

</p>
<p>
Ingresso giornaliero &euro; 35,00<br/>
Turno antimeridiano con pasto &euro; 110,00 a settimana</br>
Turno antimeridiano senza pasto &euro; 90,00  a settimana</br>
</p>
<p>
Le quote comprendono:
<ul>
<li>Tutti i pasti</li>
<li>Ingresso in piscina</li>
<li>Servizio navetta</li>
<li>Assicurazione</li>
<li>Gite ed escursioni guidate</li>

</ul>
</p>
<p>Iscriviti direttamente sul sito: <a href="/ronco/iscrizione">Iscrizione</a>, poi scarica e compila i moduli necessari per la formalizzazione da consegnare al Camp firmati.</p>
<ul>
<!--
<li>modulo di iscrizione con la liberatoria per la privacy: <a href="download?file=/var/docs/ronco/moduloiscrizioneroncovillage2018.pdf" target="_blank" ><input type="button" value="Scarica Modulo Iscrizione" name="scarica"/></a></li>
<li>modulo relativo alla copertura sanitaria (vaccinazioni):<a href="download?file=/var/docs/ronco/vaccinazioni.pdf" target="_blank" ><input type="button" value="Scarica Modulo Sanitario" /></a></li>
-->
<s:if test="%{iscrizione.url!=null}">
<li>modulo di iscrizione con la liberatoria per la privacy:
<a href="<s:property value="iscrizione.url"/>"><input type="button" value="Scarica Modulo Iscrizione" name="scarica"/></a>
</li>
</s:if>
<s:if test="%{liberatoria.url!=null}">
<li>informativa trattamento dati personali:
<a href="<s:property value="liberatoria.url"/>"><input type="button" value="Scarica Informativa" name="scarica"/></a>
</li>
</s:if>
<s:if test="%{vaccinazioni.url!=null}">
<li>modulo relativo alla copertura sanitaria (vaccinazioni):
<a href="<s:property value="vaccinazioni.url"/>"><input type="button" value="Scarica Modulo Sanitario" /></a>
</li>
</s:if>
</ul>

 <!-- 
 il modulo di iscrizione con la liberatoria per la privacy a: <a href="<s:property value="iscrizione.url"/>&mimetype=<s:property value="iscrizone.mime" />"  target="_blank" > Modulo </a> da riconsegnare direttamente al Camp compilato.</p>


<p>Scarica e compila il modulo relativo alla copertura sanitaria (vaccinazioni): <a href="" target="_blank" > Modulo Sanitario</a> da riconsegnare direttamente al Camp compilato.</p>
 -->
</div>