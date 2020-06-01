<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fulfillments</title>
</head>
<body>
	<%@ include file="/views/navbar.jsp"%>
	<h2 style="text-align: center">Inventory Fulfillments</h2>
	<c:if test="${supplierOrders != null}">
		<table class="table table-striped" style="margin: 1% 5% 2% 5%; width: 90%;">
		<thead>
				<tr>
					<th scope="rowgroup" colspan="4" style="background-color: darkgrey; color: white; border-radius: 3px;">Fulfillments</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Product Code</th>
					<th scope="col">Quantity</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${supplierOrders}">
					<c:choose>
						<c:when test="${order.status.equals('FULFILLED')}">
							<c:set var="statusColor" scope="session" value="blue" />
						</c:when>
						<c:when test="${order.status.equals('RECEIVED')}">
							<c:set var="statusColor" scope="session" value="red" />
						</c:when>
						<c:otherwise>
							<c:set var="statusColor" scope="session" value="green" />
						</c:otherwise>
					</c:choose>

					<tr>
						<th scope="row">${order.id}</th>
						<td>${order.productcode}</td>
						<td>${order.quantity}</td>
						
						<td style="color: ${statusColor}">${order.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<%@ include file="/views/Footer.html"%>
</body>
</html>