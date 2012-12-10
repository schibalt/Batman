<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/batcave.css" />
<script src="js/batstore.js" type="text/javascript"></script>
<script src="js/zachcookie.js" type="text/javascript"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<link href="css/gstyle_buttons.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="cart" class="com.batman.server.cart.ShoppingCart"
	scope="session" /><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="header">
		<table width="100%">
			<tr>
				<td><a href="home"><img class="logo"
						src="images\tumblr_m99mhqZV1H1r8sympo1_1280-neg.png"
						alt="bat cave logo" width="400" /></a></td>
					<td id='credentialEntry' class="credentialEntry">
				<c:if test="${ empty sessionScope.user }">
						<ul class="credlist">
							<li><p id="goodEmail"></p> <a class="credlinks">Email</a></li>
							<li><input onchange="validateEmail()" id="email" type="text" /></li>
						</ul> <br />
						<ul class="credlist">
							<li><a class="credlinks">Password</a></li>
							<li><input id="password" type="password" /></li>
						</ul>
						<ul class="credlist">
							<li>
								<button name="button" value="checkout">Log In</button>
							</li>
							<li></li>
						</ul>
				</c:if>
				<c:if test="${not empty sessionScope.user }">
					<h3 style="color:white;">Welcome home, </br>master ${sessionScope.user.name}</h3>
				</c:if>
					</td>
			</tr>
		</table>
		<%-- <div class="cart">
			<a href="cart"><img src="images\batshopping_cart.png"
				alt="bat cart logo" width="50" /></a> (<jsp:getProperty
				property="displayPrice" name="cart" />)
		</div> --%>
		<br />
		<div style="background: white; padding: 1em;">
			<ul class="navlist">
				<li><a class="generallinks" onmouseover="" href="home">Home</a></li>
				<li id="active"><a class="generallinks" href="location"
					id="current">Location</a></li>
				<li><a class="generallinks" href="account">Account</a></li>
				<li><a class="generallinks" href="store">Store</a></li>
				<li><a class="generallinks" href="cart">cart</a></li>
				<li><a class="generallinks" href="help">Help</a></li>
			</ul>