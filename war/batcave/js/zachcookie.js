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

function getLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition);
	} else {
		document.getElementById('x').innerHTML = "Geolocation is not supported by this browser.";
	}
}

function showPosition(position) {
	document.getElementById('x').innerHTML = "Latitude: "
			+ position.coords.latitude + "<br>Longitude: "
			+ position.coords.longitude;
}

function setCookie(c_name, value, exdays) {
	// alert('setting' + c_name + ' to ' + value);
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);

	var c_value = escape(value)
			+ ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
	document.cookie = c_name + "=" + c_value;
	document.location.reload(true);
}

function setItemCookies() {
	setCookie(itemTable[0][0], 0, 365);
	setCookie(itemTable[0][1], 0, 365);
	setCookie(itemTable[0][2], 0, 365);
	setCookie(itemTable[0][3], 0, 365);
	setCookie(itemTable[0][4], 0, 365);
	setCookie(itemTable[0][5], 0, 365);
	setCookie(itemTable[0][6], 0, 365);
	setCookie(itemTable[0][7], 0, 365);
}

function incrementCookie(itemname) {
	var totalQuantity = parseInt(getCookie(orderQuantity));
	var quantity = parseInt(getCookie(itemname));

	// alert(getCookie(itemname));

	totalQuantity++;
	quantity++;

	setCookie(orderQuantity, totalQuantity, 365);
	setCookie(itemname, quantity, 365);
}

function logout() {
	// alert('logging out');
	setCookie('username', '', -1);
	document.location.reload(true);

}

function checkCookie() {
	var username = getCookie("username");

	if (username != null && username != "") {
		document.getElementById('credentialEntry').innerHTML = 'Welcome, '
				+ username
				+ "<br/><input class=\"button\" onclick=\"logout()\" type=\"submit\" value=\"Log out\"/>";
	} /*
		 * username = prompt("Please enter your name:", ""); if (username !=
		 * null && username != "") {
		 * 
		 * setCookie("username", username, 365); }else { }
		 */
}

function checkCookieOnLoad() {

	var username = getCookie("username");

	if (username != null && username != "") {

		// alert(username + ' is logging in ');

		document.getElementById('credentialEntry').innerHTML = "Welcome, "
				+ username
				+ "<br/><br/><br/><input class=\"button\" onclick=\"logout()\" type=\"submit\" value=\"Log out\"/>";
		// alert(username + ' logged in');
	} /*
		 * else { username = prompt("Please enter your name:", ""); if (username !=
		 * null && username != "") {
		 * 
		 * setCookie("username", username, 365); } }
		 */
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
	document.getElementById("demo").innerHTML = "Welcome, "
			+ document.getElementById("username2").value;
	// alert(document.getElementById("username2").value);
	setCookie("username", document.getElementById("username2").value, 1);
}