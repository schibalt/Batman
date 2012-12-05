<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="batcave.css" />
</head>
<script type="text/javascript">
	function getCookie(c_name) {
		var i, x, y, ARRcookies = document.cookie.split(";");
		for (i = 0; i < ARRcookies.length; i++) {
			x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
			y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
			x = x.replace(/^\s+|\s+$/g, "");
			if (x == c_name) {
				return unescape(y);
			}
		}
	}

	function setCookie(c_name, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value = escape(value)
				+ ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
		document.cookie = c_name + "=" + c_value;
	}

	function checkCookie() {
		var username = getCookie("username");
		if (username != null && username != "") {
			alert("Welcome again " + username);
		} else {
			username = prompt("Please enter your name:", "");
			if (username != null && username != "") {
				setCookie("username", username, 365);
			}
		}
	}
	function displayName() {
		username = getCookie("username");
		if (username != null && username != "") {
			document.getElementById("demo").innerHTML = username;
		} else {
			document.getElementById("demo").innerHTML = "Please log in to display name.";

		}
	}

	function submitName() {
		document.getElementById("demo").innerHTML = "Welcome "
				+ document.getElementById("username2").value;
		setCookie("username", document.getElementById("username2").value, 1);
	}
</script>

<body>
	<%@ include file="header.jsp"%>
	<h3>Create User Account:</h3>
	<div class="signup">
		<form method="post" action="AddUser.jsp">
			<div class="left">E-mail:</div>
			<div class="right">
				<input type="email" name="usremail">
			</div>
			<div class="left">Password:</div>
			<div class="right">
				<input type="password" name="pwd2">
			</div>
			<div class="left">Full Name:</div>
			<div class="right">
				<input type="text" id="username2">
			</div>
			<div class="left">Credit Card #:</div>
			<div class="right">
				<input type="number" name="quantity" min="1000000000000000"
					max="9999999999999999">
			</div>
			<div class="left">Birthday:</div>
			<div class="right">
				<input type="date" name="bday">
			</div>
		</form>
		<br />
		<button type="button" onclick="submitName()">Submit</button>  
		<p id="demo">Log in to display name.</p>
		<br />
	</div>
	<%@ include file="footer.html"%>
</body>
</html>