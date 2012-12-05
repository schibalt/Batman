<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"> <jsp:directive.page
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	session="true" /> <%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/lightbox.js"></script>
<link href="css/lightbox.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<span>
		<div class="featured">
			Featured WayneTech Products

			<form Action="/batcave/store" Method="post" name="itemForm">
				<INPUT TYPE="HIDDEN" NAME="buttonName">
					<table name="itemTable">
						<c:forEach var="item" items="${requestScope.items}">
							<tr>
								<td width="20%">
									<a href="images/${item.image}" rel="lightbox[Products]" title="${item.name}">
										<img width="150" height="100" src="images/${item.image}" />
									</a>
								</td>
								<td width="20%">
									${item.name}
								</td>
								<td width="20%">
									<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
									<fmt:formatNumber value="${item.price}" type="currency" currencyCode="USD" />
								</td>
								<td width="20%">
									Quantity</br></br>
									<input name="${item.guid}" type="number" value="1" max="99" min="1" />
								</td>
								<td width="20%">
									<div class="buttons">
										<button style="height: 50; width:100" class="action" name="button" value="${item.guid}">
											Add to Cart
										</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
			</form>
			proud affiliates
			<table>
				<tr>
					<td>Wayne Tech<br/><img src="images/photo-111090.jpg" alt="waynetech" width="100"/></td>
					<td>GCPD<br/><img src="images/a79a309889af516d3a473b3c5beed9af.jpg" alt="GCPD" width="100" /></td>
					<td>FBI<br/><img src="images/136px-US-FBI-ShadedSeal.svg.png" alt="FBI" width="100" /></td>
				</tr>
			</table>
		</div>
	</span>
	<%@ include file="footer.html"%>
</body>
</html>