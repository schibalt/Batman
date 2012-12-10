<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"> <jsp:directive.page
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	session="true" /> <%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><%@ page
	isELIgnored="false"%> <%@ include
	file="header.jsp"%> <c:if
	test="${fn:length(requestScope.displayItems) gt 0}">
	<table style="margin-left: auto; margin-right: auto;">
		<tr>
			<td width="20%"></td>
			<td width="20%">Item</td>
			<td width="20%">Total per Item</td>
			<td width="20%">Qty</br> </br>
			</td>
		</tr>
		<c:forEach var="item" items="${requestScope.displayItems}">
			<tr>
				<td width="20%"><a href="images/${item.image}"
					rel="lightbox[Products]" title="${item.name}"> <img width="150"
						height="100" src="images/${item.image}" />
				</a></td>
				<td width="20%">${item.name}</td>
				<td width="20%"><%@ taglib
						uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
					<fmt:formatNumber value="${item.price * item.count}"
						type="currency" currencyCode="USD" /></td>
				<td width="20%">${item.count}</br> </br>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form Action="/batcave/checkout" Method="get" name="itemForm"
		style="display: inline-table;">
		<table>
			<tr>
				<td>
					<h3>
						Your total comes to
						<jsp:getProperty property="displayPrice" name="cart" /></h3>
				</td>
				<td>
					<button name="button" value="checkout" style="font-size: 1em;">
						<h3>checkout</h3>
					</button>
				</td>
			</tr>
		</table>
	</form>
</c:if> <c:if test="${fn:length(requestScope.displayItems) eq 0}">
	<h3>The cart is empty</h3>
</c:if></jsp>
</br><%@ include file="footer.html"%>
</div>