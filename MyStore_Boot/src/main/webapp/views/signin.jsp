<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-In</title>
<link rel="stylesheet" href="styles/register.css" type="text/css"/>
 <script src="/static/scripts/login.js" charset="utf-8"></script>
</head>
<body>
<%@ include file="/views/navbar.jsp" %>
<div class="registrationContainer">
<div class="message">${message}<br></div>
<h1>Have an account already?</h1>
<h2>Sign in below!</h2>


<br><br><br>

<div id="registration">
<form action="signInUser" method="post" id="login">       
    <label class="pad_top">Username:</label>
    <input required type="text" name="userName"><br><br>
     
    <label class="pad_top">Password:</label>
    <input required type="password" name="password"> <br> <br>
    <label>&nbsp;</label><br>
    <input required type="submit" value="Sign In" class="margin_left">
</form>
</div>
<br>
<p>Don't have an account?</p>
<form action="register" method="get">
<input type="submit" value="Register" class="margin_left">
</form>
</div>


<%@ include file="/views/Footer.html" %>
</body>
</html>