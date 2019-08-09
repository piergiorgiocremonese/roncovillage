<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
<link href="<s:property value="url"/>/ronco/css/style.css" rel="stylesheet" type="text/css" />
<link href="<s:property value="url"/>/ronco/css/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/calendar.js"></script>
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/my-calendar.js"></script>
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
<img src="<s:property value="url"/>/ronco/images/banner-top.jpg"/>
</a>
</div>
<div id="toolbar">
<table border="1">

<tr>
<td class="button" align="center"><a href="iscrizione" >Registrazione<a/></td>
<td class="button" align="center"><a href="informazioni">Informazioni</a></td>
<td class="button" align="center"><a href="listaGruppi">Gallery</a></td>
<td class="button" align="center"><a href="contatti">Contattaci</a></td>
<td class="button" align="center"><a href="posizione">Dove Siamo</a></td>
<td class="button" align="center"><a href="privateHome">Area Privata</a></td>
</tr>
</table>

</div>

<div id="block" >
<tiles:insertAttribute name="body"/>
<!--<img src="images/body.jpg"/>!-->

</div><!-- close block -->
</div><!-- close container -->
</body>
</html>