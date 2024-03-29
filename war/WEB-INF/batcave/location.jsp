<%@ include file="header.jsp"%>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../css/base.css" type="text/css"
	media="screen">
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
</head>
<body>
	<div id="container">
		<header role="banner"> </header>
		<div role="main">
			<section id="main-content">
				<div id="map-container">
					<div id="map"></div>
					<div id="map-directions"></div>
				</div>
				<script src="http://maps.google.se/maps/api/js?sensor=false"></script>
				<script>
		    (function()
		    {
			var directionsService = new google.maps.DirectionsService(), directionsDisplay = new google.maps.DirectionsRenderer(), createMap = function(
				start)
			{
			    var travel = {
				origin : (start.coords) ? new google.maps.LatLng(
					start.lat, start.lng)
					: start.address,
				destination : "batcave",
				travelMode : google.maps.DirectionsTravelMode.DRIVING
			    // Exchanging DRIVING to WALKING above can prove quite amusing :-)
			    }, mapOptions = {
				zoom : 10,
				// Default view: downtown Stockholm
				center : new google.maps.LatLng(59.3325215,
					18.0643818),
				mapTypeId : google.maps.MapTypeId.ROADMAP
			    };

			    map = new google.maps.Map(document
				    .getElementById("map"), mapOptions);
			    directionsDisplay.setMap(map);
			    directionsDisplay.setPanel(document
				    .getElementById("map-directions"));
			    directionsService.route(travel, function(result,
				    status)
			    {
				if (status === google.maps.DirectionsStatus.OK)
				{
				    directionsDisplay.setDirections(result);
				}
			    });
			};

			// Check for geolocation support	
			if (navigator.geolocation)
			{
			    navigator.geolocation.getCurrentPosition(function(
				    position)
			    {
				// Success!
				createMap({
				    coords : true,
				    lat : position.coords.latitude,
				    lng : position.coords.longitude
				});
			    }, function()
			    {
				// Gelocation fallback: Defaults to Stockholm, Sweden
				createMap({
				    coords : false,
				    address : "Sveav�gen, Stockholm"
				});
			    });
			} else
			{
			    // No geolocation fallback: Defaults to Lisbon, Portugal
			    createMap({
				coords : false,
				address : "Lisbon, Portugal"
			    });
			}
		    })();
		</script>
			</section>
		</div>

		<footer id="page-footer" role="contentinfo">
			Created by <a href="http://robertnyman.com/">Robert Nyman</a>
		</footer>
	</div>

	<!-- Syntax highlighting -->
	<script type="text/javascript"
		src="../syntax-highlighter/scripts/shHTMLJavaScript.js"></script>
	<script type="text/javascript">
	SyntaxHighlighter.all();
    </script>

	<script>
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-56164-1' ]);
	_gaq.push([ '_trackPageview' ]);

	(function()
	{
	    var ga = document.createElement('script');
	    ga.type = 'text/javascript';
	    ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl'
		    : 'http://www')
		    + '.google-analytics.com/ga.js';
	    (document.getElementsByTagName('head')[0] || document
		    .getElementsByTagName('body')[0]).appendChild(ga);
	})();

	var sc_project = 593937, sc_partition = 4, sc_security = "175a1fec";
    </script>

	<script src="http://www.statcounter.com/counter/counter_xhtml.js"></script>
	<noscript>
		<div class="statcounter">
			<a class="statcounter" href="http://www.statcounter.com/"><img
				class="statcounter"
				src="http://c5.statcounter.com/counter.php?sc_project=593937&amp;java=0&amp;security=175a1fec"
				alt="free geoip"></a>
		</div>
	</noscript>

	<%@ include file="footer.html"%>