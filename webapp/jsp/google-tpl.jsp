<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ronco/js/calendar.js"></script>
<script type="text/javascript" src="/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="/ronco/js/my-calendar.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<!--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>-->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKNsOUCP7d3DdPXwBSA-FogICm2lGMbTY&callback=initMap"
  type="text/javascript"></script>
<script type="text/javascript">
function initialize() {
    geocoder = new google.maps.Geocoder();

    var ronco = new google.maps.LatLng(44.238928,10.748338);
    var myOptions = {
                zoom:16,
        mapTypeId: google.maps.MapTypeId.HYBRID
                ,center: ronco
    }
   
        map = new google.maps.Map(document.getElementById("map"), myOptions);
        var marker = new google.maps.Marker({
                        position: ronco,
                                map: map,
                        title: 'Noi Siamo Qui'
        });
        elevator = new google.maps.ElevationService();
}
</script>
<title><tiles:insertAttribute name="titlearea"/></title>

</head>
<body onload="initialize()">
<script type="text/javascript">


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
<td class="button" align="center"><a href="iscrizione" >Registrazione<a/></td>
<td class="button" align="center"><a href="info">Informazioni</a></td>
<td class="button" align="center"><a href="showDocs">Modulistica</a></td>
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
