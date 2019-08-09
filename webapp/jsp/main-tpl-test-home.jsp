<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
<link href="<s:property value="#session['URL']"/>/ronco/css/style.css" rel="stylesheet" type="text/css" />
<link href="<s:property value="#session['URL']"/>/ronco/css/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar.js"></script>
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar-it.js"></script>
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/my-calendar.js"></script>
<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/ronco.js"></script>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
 <script>tinymce.init({ selector:'textarea' });</script>
</head>

<title><tiles:insertAttribute name="titlearea"/></title>
<meta name="description" content="RoncoVillage: Il camp estivo di Sestola per i bambini fino a 14 anni" />
<meta name="keywords" content="Camp Estivo, Sestola, Roncoscaglia, Giochi per bimbi Sestola" />
</head>
<body>
<script type="text/javascript">

/*
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

function updateInfoArray(k,a){
	var text='<ul>';
	for (var i=0;i<a.length;i++){
		text = '<li>'+a[i]+'<li>';
	}
	text = text + '</ul>';
	document.getElementById(k).innerHTML=text;
}

function updateInfo(info){
	var s = JSON.parse(info);
	var keys = [];
   	for(var k in s) {
   		if Array.isArray(s[k]){
   			updateInfoArray(k,s[k]);
   	}else{
   		document.getElementById(k).innerHTML=s[k];
   	}
   	
}
*/
</script>

<div id="container" class="centrato">
<div id="header">
<tiles:insertAttribute name="header"/>
</div>
<div id="toolbar">
<tiles:insertAttribute name="toolbox"/>

</div>

<div id="block" >
<div style="position:absolute;left:0px;top:0px">
<tiles:insertAttribute name="blocco1"/>
</div>


<div style="position:absolute;top:0px;left:840px;width:440px;height:630px;color:red">
<tiles:insertAttribute name="blocco2"/>	
</div>
<div style="position:absolute;top:20px;left:890px;color:red">
<tiles:insertAttribute name="blocco5"/>
</div>

<div style="position:absolute;top:620px;left:0px;width:480px;height:640px">
<tiles:insertAttribute name="blocco3"/>
</div>

<div style="position:absolute;left:430px;top:620px">
<tiles:insertAttribute name="blocco4"/>
</div>
<div style="position:absolute;left:230px;top:1300px">
<tiles:insertAttribute name="footer"/>
</div>
</div><!-- close block -->
</div><!-- close container -->
</body>
</html>
