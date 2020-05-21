<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
</head>
<body>
<%@ include file="/views/navbar.jsp" %>

<div id="content">
Hello, ${user.username}.<br>
Please select what you would like to do below:
<br><br>

<a href="addproductpage"><button type="submit" name="button">Add a Product</button></a><br>
</div>

<%@ include file="/views/Footer.html" %>
</body>
</html>