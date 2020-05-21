<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
</head>
<body>
<%@ include file="/views/navbar.jsp" %>

<div id="content">
	<h1>Thank you for your order!</h1><br> 
	<p>Your order number is <strong>${orderid}</strong>.</p>
	<br><br><br>
	
	<a href="donechecking"><button type="submit" name="button">Continue Shopping</button></a>
	</div>
	
<%@ include file="/views/Footer.html" %>

</body>
</html>