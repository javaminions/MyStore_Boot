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
<div class="message">${message}<br></div>
<h1>Don't have an account?</h1>
<h2>Register with us!</h2>


<br><br><br>

<div id="registration">
<form action="registerUser" method="post">  
          
    <label class="pad_top">Email:</label>
    <input required type="email" name="email"><br><br>
    
    <label class="pad_top">First Name:</label>
    <input required type="text" name="firstName"><br><br>
    
    <label class=pad_top">Last Name:</label>
    <input required type="text" name="lastName"><br><br>
    
    <label class="pad_top">Username:</label>
    <input required type="text" name="userName"><br><br>
    
    <label class="pad_top">Password:</label>
    <input required type="password" name="password"><br>
  
    <label>&nbsp;</label><br>
    <input required type="submit" value="Register" class="margin_left">
</form>
</div>
<br>
<p>All ready have an account?</p>
<form action="signin" method="get">
<input type="submit" value="Sign In" class="margin_left">
</form>
</div>


<%@ include file="/views/Footer.html" %>
</body>
</html>