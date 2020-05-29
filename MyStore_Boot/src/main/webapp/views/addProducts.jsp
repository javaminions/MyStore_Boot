<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register With Us</title>
<link rel="stylesheet" href="styles/register.css" type="text/css"/>
 <script src="scripts/login.js" charset="utf-8"></script>
</head>
<body>
<%@ include file="/views/navbar.jsp" %>
<div class="registrationContainer">
<h2>Add a Product Here:</h2>

<br><br><br>
<div id="registration">
<form action="addproduct" method="post">  
          
    <label class="pad_top">Code:</label>
    <input required type="text" name="code"><br><br>
    
    <label class="pad_top">Name:</label>
    <input required type="text" name="name"><br><br>
    
    <label class="pad_top">Description:</label>
    <input required type="text" name="description"><br><br>
    
    <label class="pad_top">Inventory:</label>
    <input required type="text" name="inventory"><br><br>
    
    <label class="pad_top">Price:</label>
    <input required type="text" name="price"><br>
    
    <label class="pad_top">Category:</label>
    <input required type="text" name="category"><br>
    
    <label class="pad_top">Img Link:</label>
    <input required type="text" name="img"><br>
    
    <label>&nbsp;</label><br>
    <input required type="submit" value="Add Product" class="margin_left">
</form>
</div>
<br>
</div>

<%@ include file="/views/Footer.html" %>
</body>
</html>