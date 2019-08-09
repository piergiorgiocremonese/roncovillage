<%@taglib prefix="s" uri="/struts-tags" %>

<div style="position:absolute;left:0px;top:0px">
<img src="images/bosco-2.jpg"/>
</div>

<!-- 
	<div style="position:absolute;top:0px;left:840px;width:440px;height:630px;color:red;background-color:green">
-->
<div style="position:absolute;top:0px;left:840px;width:440px;height:630px;color:red;background-image:url('images/golf.jpg')">	

<div style="position:absolute;top:20px;left:50px;color:red">

<h1><b>Rivolto a tutti i bambini nati dal <s:property value="annoInizio" /> al <s:property value="annoFine" /></b></h1>
<h1><b>Periodi</b></h1>
<div style="font-size:x-large">
<s:iterator var="p" value="periodi" status="stat">
 
<ul>
<li><s:property value="p"/></li>

</ul>

</s:iterator>

<p><a href="iscrizione" style="color:red">Iscriviti Subito</a></p> 
</div>
</div>
</div>
<div style="position:absolute;top:620px;left:0px;width:480px;height:640px;background-image:url('images/gruppetto.jpg')">

</div>
<!--
<div style="position:absolute;left:0px;top:700px">
 <img src="images/muro2-little.jpg"/> 
</div>
-->
<div style="position:absolute;left:430px;top:620px">
<img src="images/campo.jpg"/>
</div>
<div style="position:absolute;left:230px;top:1300px">
<p>
<!--<center>
<b>Asd Roncovillage Via Per Roncoscaglia 41029 Sestola (Mo) P.Iva : 03212570354 C.F. 94133750367 </b>
&nbsp;<a href="<s:property value="liberatoria.url" />" >
Privacy Policy
</a>
</center>-->
</p>
<div>





