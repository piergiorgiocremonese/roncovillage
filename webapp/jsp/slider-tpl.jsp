<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html;  charset=iso-8859-15"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>RoncoVillage Test</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link href="css/animate.min.css" rel="stylesheet"> 
	<link href="css/ronco-day.css" rel="stylesheet" />	
	
	<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar.js"></script>
	<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/calendar-it.js"></script>
	<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/my-calendar.js"></script>
	<script type="text/javascript" src="<s:property value="#session['URL']"/>/ronco/js/ronco.js"></script>
	<script src="<s:property value="#session['URL']"/>/ronco/js/jquery.js"></script>
    <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
   
    <![endif]-->
	<script>
		var current=0;
		function updImage(list){
			//var myData = JSON.parse(info);
			var e = document.getElementById('albumfoto');	
			e.setAttribute("src",list.images[current].src);
			current++;
			if (current>=list.images.length)
				current=0;
			
		} 
	</script>
  </head>
  <body>	
	<header id="header">
        <nav class="navbar navbar-default navbar-static-top" role="banner">
            <div class="container">
                <div class="navbar-header">
               
                
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
               		</button>
                   <div class="navbar-brand">
						<div style="position:absolute;top:-15px;left:75px">
						<tiles:insertAttribute name="header0"/>
						</div>
				  </div>
                </div>				
                <div class="navbar-collapse collapse">							
			<div class="menu" ><!-- Blocco 1 header1-->
			<ul class="nav nav-tabs" role="tablist" >
				<tiles:insertAttribute name="header4"/>
			</ul>	
			</div>
			<div id="top-info" style="position:absolute;top:0px;right:180px;color:black"><!-- Blocco 2 header2-->
				<tiles:insertAttribute name="header1"/>		
			</div>
			<div id="brand2"  style="position:absolute;right:50px">><!-- Blocco 3 header3-->
				<tiles:insertAttribute name="header2"/>	
			</div>	
			<div id="bot-info" style="position:absolute;top:40px;right:150px;color:black"><!-- Blocco 4 header4 -->
				<tiles:insertAttribute name="header3"/>	
			</div>
		</div>		
            </div><!--/.container-->
        </nav><!--/nav-->		
    </header><!--/header-->	
	
	<div id="album" class="slider" style="position:absolute;top:60px;margin:auto;height:720px;width:100%">	
	<!-- Blocco 0 main content slide-->
			
		<img id="albumfoto" src="" style="position:absolute;margin:auto;top:0;left:0;right:0;bottom:0"/>
		<tiles:insertAttribute name="blocco0"/><!-- slider block 0 main-->	
			
	</div>
	<div id="info" style="position:absolute;left:2	0px;top:200px;margin:auto;width:100%;color:red;font-size:x-large">
														<!-- Blocco 1 main content per-blk -->		

	<tiles:insertAttribute name="blocco1"/>	<!-- period block blocco 1 main-->
	</div>
		
	<div class="sub-footer" style="position:absolute;top:780px;width:100%">
		<div class="container">
			
			<div class="col-md-8 col-md-offset-2">
				<div class="copyright"><!-- Blocco 0 footer -->
				<tiles:insertAttribute name="footer0"/>	
			</div>						
		</div>				
	</div>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   
  </body>
</html>	