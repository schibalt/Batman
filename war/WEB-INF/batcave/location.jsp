<!DOCTYPE html>
<html>
    <head><style type="text/css">@media print {  .gmnoprint {    display:none  }}@media screen {  .gmnoscreen {    display:none  }}</style>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../css/base.css" type="text/css" media="screen">
	<style>
		#map-container {
			overflow: hidden;
		}
		#map {
			float: left;
			width: 60%;
			height: 500px;
			margin: 50px auto;
		}
		#map-directions {
			float: right;
			width: 38%;
			padding-left: 2%;
		}
	</style>
	<!--[if lte IE 8]>
		<script src="../js/html5.js"></script>
	<![endif]-->
<script type="text/javascript" src="http://maps.google.se/maps/api/js?sensor=false"></script>
	<script>
	(function () {
		var directionsService = new google.maps.DirectionsService(),
			directionsDisplay = new google.maps.DirectionsRenderer(),
			createMap = function (start) {
				var travel = {
						origin : (start.coords)? new google.maps.LatLng(start.lat, start.lng) : start.address,
						destination : "Bat Cave, NC 28792",
						travelMode : google.maps.DirectionsTravelMode.DRIVING
						// Exchanging DRIVING to WALKING above can prove quite amusing :-)
					},
					mapOptions = {
						zoom: 15,
						center : new google.maps.LatLng(35.452, -82.287),
						mapTypeId: google.maps.MapTypeId.ROADMAP,
						origin : (start.coords)? new google.maps.LatLng(start.lat, start.lng) : start.address,
						destination : "Bat Cave, NC 28792"	
					};

				map = new google.maps.Map(document.getElementById("map"), mapOptions);
				directionsDisplay.setMap(map);
				directionsDisplay.setPanel(document.getElementById("map-directions"));
				directionsService.route(travel, function(result, status) {
					if (status === google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(result);
					}
					else{
						directionsDisplay.setDirections(result);
					}
				});
			};

			// Check for geolocation support	
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function (position) {
						// Success!
						createMap({
							coords : true,
							lat : position.coords.latitude,
							lng : position.coords.longitude
						});
					}
				);
			}
	})();
</script>
<body>
	<%@ include file="header.jsp"%>
		<span>
<div id="map"></div>
<div id="map-directions"></div>
	<%@ include file="footer.html"%>
	</body>
</html>