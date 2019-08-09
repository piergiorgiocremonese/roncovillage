<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>RoncoVillage Test</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="RoncoVillage Template Study" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="cremonese.org" />

	<link rel="shortcut icon" href="favicon.ico">

	<!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">

	<link rel="stylesheet" href="css/style.css">
	<script src="js/ronco.js"></script>

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<script>
		var current=0;
/*
		function updImage(list){
			//var myData = JSON.parse(info);
			var e = document.getElementById('albumfoto');	
			e.setAttribute("src",list.images[current].src);
			current++;
			if (current>=list.images.length)
				current=0;
			
		} 
*/
	</script>

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<h1 id="fh5co-logo" style="position:absolute;left:0px"><a href="index.html"><img src="images/logo-125.jpg" /></a><img src="images/roncovillage.jpg"</h1>
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
							<ul class="sf-menu" id="fh5co-primary-menu">
							<tiles:insertAttribute name="header0" />
							</ul>
						</nav>
					</div>
					
					<div id="sestola-text1" style="position:absolute;top:40px;right:130px;color:white">Con il patrocinio del</div>
					<div id="sestola" style="position:absolute;top:30px;right:30px"><img src="images/sestola-81.jpg"/></div>
					<div id="sestola-text2" style="position:absolute;top:71px;right:130px;color:white">Comune di Sestola</div>
				</div>
			</header>
			
		</div>
		
		
		
		<div class="fh5co-hero">
			<div class="fh5co-overlay"> 
			
			<div id="maincnt" class="fh5co-cover text-center" data-stellar-background-ratio="0.5" style="color:red;font-size:x-large;background-image: url(images/cover_bg_1.jpg);">
				<!--<div id="info" class="desc animate-box">
				<img id="albumfoto" src="" style="position:absolute;margin:auto;top:400;left:0;right:0;bottom:0"/>
				</div>-->
				<tiles:insertAttribute name="blocco0" />
			</div>
			<div id="info"  style="position:absolute;left:400px;top:200px;margin:auto;width:100%;color:red;font-size:x-large">
				
				
			
				<tiles:insertAttribute name="blocco1" />
			
			
			</div>
			
				
			</div>
	   </div>
			
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
<!--							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
-->							</p>
<!--						<p>Copyright 2016 Free Html5 <a href="#">Listing</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>-->
					<tiles:insertAttribute name="footer0" />
						</div>
					</div>
				</div>
			</div>
		</footer>
	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->


	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>

	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>
