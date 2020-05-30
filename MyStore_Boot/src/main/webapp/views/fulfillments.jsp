<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fulfillments</title>
</head>
<body>
<%@ include file="/views/navbar.jsp" %>
<h2>Welcome to fulfillments page</h2>
<c:if test="${supplierOrders != null}">
<c:forEach var="order" items="${supplierOrders}">
	<p>${order.toString()}</p>	
</c:forEach>
</c:if>
<%@ include file="/views/Footer.html" %>
</body>
</html>