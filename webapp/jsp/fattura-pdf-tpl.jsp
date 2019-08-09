<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html id="document">
<head id="head">
<link href="<s:property value="url"/>/ronco/css/style.css" rel="stylesheet" type="text/css" />
<link href="<s:property value="url"/>/ronco/css/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/calendar.js"></script>
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="<s:property value="url"/>/ronco/js/my-calendar.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js" />
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

<div id="container" class="centrato" >
<table >
<tr>
<td>
<img src="<s:property value="url"/>/ronco/images/logo2-mini.png"></img>

</td>

<td align="left" style="width:512px">
<ul style="list-style-type:none">
<li><b>ASSOCIAZIONE SPORTIVA DILETTANTISTICA</b></li>
<li><b>SCI-CALCIO-TENNIS RONCOVILLAGE</b></li>
<li><b>Via Per Roncoscaglia snc</b></li>
<li><b>41029 SESTOLA (Modena)</b></li>
<li><b>P.I. 03212570364 - C.F. 94133750367</b></li>
<li><b>Cell. 393 9535260</b></li>
</ul>
</td>
</tr>
</table> 


<div id="toolbar">
<table border="1">
<tr>
<td class="pbutton" align="center"><a href="searchForm" >Iscritti<a/></td>
<td class="pbutton" align="center"><a href="presenzeForm" >Presenze<a/></td>
<td class="pbutton" align="center"><a href="listaTipi">Promozioni</a></td>
<td class="pbutton" align="center"><a href="getQuadro">Quadro Pagamenti</a></td>
<td class="pbutton" align="center"><a href="showRegistro">Registro Pagamenti</a></td>
<td class="pbutton" align="center"><a href="home">Pubblico</a></td>
<td class="pbutton" align="center"><a href="logout">Logout</a></td>
</tr>
</table>

</div>

<div id="block" >
<tiles:insertAttribute name="body"/>

</div>
</div>
</body>
</html>
