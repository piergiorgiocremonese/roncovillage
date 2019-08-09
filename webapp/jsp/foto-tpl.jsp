<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
<link href="<s:property value="url"/>/ronco/css/ronco.css" rel="stylesheet" type="text/css" />
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

<div id="containerfoto" >
<div id="header">

<a href="home">
<img src="<s:property value="url"/>/ronco/images/banner-top.jpg"/>
</a>
</div>

<div id="block" >
<tiles:insertAttribute name="body"/>
<!--<img src="images/body.jpg"/>!-->

</div><!-- close block -->
</div><!-- close container -->
</body>
</html>