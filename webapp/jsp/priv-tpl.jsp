<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
<link href="css/ronco.css" rel="stylesheet" type="text/css" />
<link href="css/calendar.css" rel="stylesheet" type="text/css" />
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<script type="text/javascript" src="/ronco/js/calendar.js"></script>
<script type="text/javascript" src="/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="/ronco/js/my-calendar.js"></script>
<!--<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>-->
<script type="text/javascript" src="/ronco/js/jquery.min.js"></script>
<script type="text/javascript" src="/ronco/plugin/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="/ronco/plugin/tinymce-init.js"></script>
 
</head>

<title><tiles:insertAttribute name="titlearea"/></title>

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
<img src="images/banner-top.jpg"/>
</div>
<div id="toolbar">
<table border="1">

<tr>
<td class="pbutton" align="center"><a href="periodi" >Settimane<a/></td>
<td class="pbutton" align="center"><a href="searchForm" >Iscritti<a/></td>
<td class="pbutton" align="center"><a href="presenzeForm" >Presenze<a/></td>
<td class="pbutton" align="center"><a href="listaTipi">Promozioni</a></td>
<td class="pbutton" align="center"><a href="getQuadro">Quadro Pagamenti</a></td>
<td class="pbutton" align="center"><a href="showRegistro">Registro Pagamenti</a></td>
<td class="pbutton" align="center"><a href="listaGruppi?op=mng">Gestione Gallery</a></td>
<td class="pbutton" align="center"><a href="showArchivio">Archivio</a></td>
<td class="pbutton" align="center"><a href="home">Pubblico</a></td>
<td class="pbutton" align="center"><a href="logout">Logout</a></td>
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