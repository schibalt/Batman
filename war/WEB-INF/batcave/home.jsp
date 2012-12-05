<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- flowplayer depends on jQuery 1.4+ (for now) -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<!-- include flowplayer -->
<script src="js/flowplayer.min.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
	<span><object width="640" height="360" id="undefined"
			name="undefined"
			data="http://releases.flowplayer.org/swf/flowplayer-3.2.15.swf"
			type="application/x-shockwave-flash">
			<param name="movie"
				value="http://releases.flowplayer.org/swf/flowplayer-3.2.15.swf" />
			<param name="allowfullscreen" value="true" />
			<param name="allowscriptaccess" value="always" />
			<param name="flashvars"
				value='config={"playlist":[{"url":"video/batman_aa_gadgets_trlr_no_esrb.webm","autoPlay":false}]}' />
		</object> </span>
	<%@ include file="footer.html"%>
</body>
</html>
