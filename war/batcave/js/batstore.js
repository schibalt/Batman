var itemTable = new Array();
itemTable[0] = new Array();
itemTable[1] = new Array();
itemTable[2] = new Array();
itemTable[3] = new Array();
itemTable[4] = new Array();

itemTable[0][0] = "BATARANG";
itemTable[0][1] = "BATCLAW";
itemTable[0][2] = "CRYPTOGRAPHIC SEQUENCER";
itemTable[0][3] = "EXPLOSIVE GEL";
itemTable[0][4] = "GRAPPLING GUN";
itemTable[0][5] = "LINE LAUNCHER";
itemTable[0][6] = "REMOTE-CONTROLLED BATARANG";
itemTable[0][7] = "REMOTE ELECTRICAL CHARGE GUN";

itemTable[1][0] = "15";
itemTable[1][1] = "200";
itemTable[1][2] = "300";
itemTable[1][3] = "400";
itemTable[1][4] = "200";
itemTable[1][5] = "400";
itemTable[1][6] = "100";
itemTable[1][7] = "300";

itemTable[2][0] = "batarang.shtml";
itemTable[2][1] = "batarang.shtml";
itemTable[2][2] = "batarang.shtml";
itemTable[2][3] = "batarang.shtml";
itemTable[2][4] = "grappling.shtml";
itemTable[2][5] = "batarang.shtml";
itemTable[2][6] = "batarang.shtml";
itemTable[2][7] = "batarang.shtml";

itemTable[3][0] = "replace.jpg";
itemTable[3][1] = "1000px-AC_Batclaw.jpg";
itemTable[3][2] = "1000px-AC_Cryptograpic_Sequencer_V2.jpg";
itemTable[3][3] = "1000px-AC_Explosive_Gel.jpg";
itemTable[3][4] = "1000px-AC_Grappling_Gun.jpg";
itemTable[3][5] = "1000px-AC_Line_Launcher.jpg";
itemTable[3][6] = "1000px-AC_Remote_Controlled_Batarang.jpg";
itemTable[3][7] = "1000px-AC_Remote_Electrical_Charge_Gun.jpg";

itemTable[4][0] = 0;
itemTable[4][1] = 1;
itemTable[4][2] = 2;
itemTable[4][3] = 3;
itemTable[4][4] = 4;
itemTable[4][5] = 5;
itemTable[4][6] = 6;
itemTable[4][7] = 7;

function listItems(itemIdx) {

	document.write("<td width=\"15%s\"><a class=\"itemlink\" href=\""
			+ itemTable[2][itemIdx] + "\">" + itemTable[0][itemIdx]
			+ "<br/><img class=\"itempic\" src=\"" + itemTable[3][itemIdx]);

	if ((itemIdx + 1) % 4 == 0) {

		/*
		 * if (itemIdx == 3) {
		 * 
		 * document .write("\" width=\"180\" /><br/>$" + itemPrices[itemIdx] + "</a>
		 * <input class=\"button\" onclick=\"incrementCart()\" type=\"submit\"
		 * value=\"Add to cart\"/></td>" + "<td>wayne tech<br/><br/><img
		 * src=\"photo-111090.jpg\" alt=\"waynetech\" width=\"100\" />" + "<br/><br/>GCPD<br/><br/><img
		 * src=\"a79a309889af516d3a473b3c5beed9af.jpg\" alt=\"GCPD\"
		 * width=\"100\" />" + "<br/><br/>FBI<br/><br/><img
		 * src=\"a79a309889af516d3a473b3c5beed9af.jpg\" alt=\"FBI\"
		 * width=\"100\" /></td></tr><tr>"); } else {}
		 */

		/*
		 * document.write("\" width=\"180\" /><br/>$" + itemTable[1][itemIdx] + "</a>
		 * <input class=\"button\" onclick=\"incrementCookie(\'" +
		 * itemTable[0][itemIdx] + "\')\" type=\"submit\" value=\"Add to
		 * cart\"/></td></tr><tr>");
		 */
		document
				.write("\" width=\"180\" /><br/>$"
						+ itemTable[1][itemIdx]
						+ "</a>   <input class=\"button\" onclick=\"incrementCart(\'"
						+ itemTable[0][itemIdx]
						+ "\')\" type=\"submit\" value=\"Add to cart\"/></td></tr><tr>");

	} else {
		/*
		 * document.write("\" width=\"180\" /><br/>$" + itemTable[1][itemIdx] + "</a>
		 * <input class=\"button\" onclick=\"incrementCookie(\'" +
		 * itemTable[0][itemIdx] + "\')\" type=\"submit\" value=\"Add to
		 * cart\"/></td>");
		 */
		document.write("\" width=\"180\" /><br/>$" + itemTable[1][itemIdx]
				+ "</a>   <input class=\"button\" onclick=\"incrementCart(\'"
				+ itemTable[0][itemIdx] + "\')\" value=\"Add to cart\"/></td>");
		// document.write(itemNames[itemIdx] + " " + itemPrices[itemIdx] +
		// "<br/>");
	}
}

function setCart() {
	// alert(getCookie('orderQuantity'));
	document.getElementById('cartItemQty').innerHTML = getCookie('orderQuantity');
}

function validateEmail() {

	var email = document.getElementById('email');
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (!filter.test(email.value)) {
		// alert('Please provide a valid email address');
		document.getElementById('goodEmail').innerHTML = "✘ ";
		document.getElementById("goodEmail").style.color = "#FF0000";
		email.focus;
	} else {
		document.getElementById('goodEmail').innerHTML = "✓ ";
		document.getElementById("goodEmail").style.color = "#00FF00";
		// alert("good email");
	}
	return false;
}

function incrementCart(itemName) {
	// alert(itemName);
	document.itemForm.buttonName.value = itemName;
	// alert(document.getElementById('cartItemQty').innerHTML);
	document.getElementById('cartItemQty').innerHTML = parseInt(document
			.getElementById('cartItemQty').innerHTML, 10) + 1;
	itemForm.submit();
}

function emptyCart() {
	//alert("empty cart");
	document.cartForm.actionType.value = "empty";
	cartForm.submit();
}

function submitOrder() {
	//alert("submit order");
	document.cartForm.actionType.value = "order";
	cartForm.submit();
}

var users = new Array();
var password = "cloud";

users[0] = "andrew@cloudclass.com";
users[1] = "zach@cloudclass.com";
users[2] = "jp@cloudclass.com";

function login() {

	var client = document.getElementById('email').value;

	for ( var i = 0; i < users.length; i++) {
		// alert(users[i] == client);

		if (users[i] == client
				&& document.getElementById('password').value == password) {

			document.getElementById('credentialEntry').innerHTML = 'Welcome, '
					+ client;
			document.getElementById('badLogin').innerHTML = '';
			return true;
			// alert('logged in');
		} else {

			document.getElementById('badLogin').innerHTML = 'Bad login';
			document.getElementById("badLogin").style.color = "#FF0000";

			// alert('bad login');
		}
	}
	return false;
}