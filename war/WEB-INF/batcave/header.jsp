<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/batcave.css" />
<title>I am Batman</title>
<script src="js/batstore.js" type="text/javascript"></script>
<script src="js/zachcookie.js" type="text/javascript"></script>
<link href="css/gstyle_buttons.css" type="text/css" rel="stylesheet" />
<jsp:useBean id="cart" class="com.batman.server.cart.ShoppingCart" scope="session" />
</head>
<body>
	<div class="header">
		<table width="100%">
			<tr>
				<td><a href="home"><img class="logo"
						src="images\batcave-logo.png" alt="bat cave logo" width="400" /></a></td>
				<td id='credentialEntry' class="credentialEntry">
					<ul class="navlist">
						<li><p id="goodEmail"></p> <a class="generallinks">Email</a></li>
						<li><input onchange="validateEmail()" id="email" type="text" /></li>
					</ul> <br />
					<ul class="navlist">
						<li><a class="generallinks">Password</a></li>
						<li><input id="password" type="password" /></li>
					</ul>
					<ul class="navlist">
						<li><p id="badLogin"></p></li>
						<li><input class="button" type="submit" onclick="login()"
							value="Log in" /></li>
					</ul>
				</td>
			</tr>
		</table>
		<div class="cart">
			<a href="cart"><img src="images\batshopping_cart.png"
				alt="bat cart logo" width="50" /></a> ($<jsp:getProperty property="totalPrice" name="cart"/>)
		</div>
		<br />
		<span>
			<ul class="navlist">
				<li><a class="generallinks" onmouseover="" href="home">Home</a></li>
				<li id="active"><a class="generallinks" href="location"
					id="current">Location</a></li>
				<li><a class="generallinks" href="account">Account</a></li>
				<li><a class="generallinks" href="store">Store</a></li>
				<li><a class="generallinks" href="help">Help</a></li>
			</ul>
		</span>
	
		<script>
			checkCookieOnLoad();
		</script>
	</div>
</body>
</html>