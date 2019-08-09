<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
<link href="<s:property value="#session['URL']"/>/ronco/css/ronco.css" rel="stylesheet" type="text/css" />
<link href="<s:property value="#session['URL']"/>/ronco/css/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar.js"></script>
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/my-calendar.js"></script>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
 <script>tinymce.init({ selector:'textarea' });</script>
</head>

<title><tiles:insertAttribute name="titlearea"/></title>
<meta name="description" content="RoncoVillage: Il camp estivo di Sestola per i bambini fino a 14 anni" />
<meta name="keywords" content="Camp Estivo, Sestola, Roncoscaglia, Giochi per bimbi Sestola" />
</head>
<body>
<script type="text/javascript">


function goBack() {
    window.history.back();
}


function cambia(id,stato){
	var x = document.getElementById(id);
	//alert(x.innerHTML);
	if (stato == 'ok'){
		var text = '<td>Fratello: </td><td><input type="text" name="fratellonome" value=""/></td>';
		x.innerHTML=text;
	}else{
		x.innerHTML='';
	}
	//alert('fine cambio');
}



</script>

<div id="container" class="centrato">
<div id="header">
<!--
<div id="header-left" >
<img src="images/muro2-mini.jpg"/>
</div>
<div id="header-center" class="imgcent" >
<img src="images/logo2-mini.png" style="position:absolute;left:50%;top:50%;margin-left:-125px;margin-top:-90px;"/>
</div>
<div id="header-right" >
<img src="images/campo-mini.jpg"/>
</div>
-->
<a href="home">
<img src="<s:property value="#session['URL']"/>/ronco/images/banner-top.jpg"/>
</a>
</div>
<div id="toolbar">
<table border="1">

<tr>
<td class="button" align="center"><a href="iscrizione" >Registrazione<a/></td>
<td class="button" align="center"><a href="info">Informazioni</a></td>
<td class="button" align="center"><a href="showDocs">Modulistica</a></td>
<td class="button" align="center"><a href="listaGruppi">Gallery</a></td>
<td class="button" align="center"><a href="contatti">Contattaci</a></td>
<td class="button" align="center"><a href="posizione" target="blank">Dove Siamo</a></td>
<td class="button" align="center"><a href="privateHome">Area Privata</a></td>
</tr>
</table>

</div>

<div id="block" >
<tiles:insertAttribute name="body"/>
<!--<img src="images/body.jpg"/>!-->
<p>
<center>
<b>Asd Roncovillage Via Per Roncoscaglia 41029 Sestola (Mo) P.Iva : 03212570354 C.F. 94133750367 </b>
&nbsp;<a href="<s:property value="#session['PRIVACY']" />" >
Privacy Policy
</a>
</center>
</p>
</div><!-- close block -->
</div><!-- close container -->
</body>
</html>
