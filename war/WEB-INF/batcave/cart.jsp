<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"> <jsp:directive.page
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	session="true" /> <%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@ include file="header.jsp"%>
<span>
	<form Action="/batcave/checkout" Method="get" name="itemForm">
		<table style="margin-left:auto;margin-right:auto;">
		  <tr>
		    <td>Your total comes to $<jsp:getProperty property="totalPrice" name="cart"/>&nbsp;&nbsp;</td>
		    <td><button class="action" name="button" value="checkout">Checkout</button></td>
		  <tr>
		</table>
	</form>
	<c:forEach var="item" items="${requestScope.displayItems}">
		${item.name} x ${item.count}</br>
	</c:forEach>
</span>
	<%@ include file="footer.html"%>
</body>
</html>