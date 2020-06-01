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
<h1>Create Account</h1>



<br>

<div id="registration">
 <h4> Create a new Bossco.com account.</h4>
<form action="registerUser" method="post">  
   
    <label class="pad_top">Email Address</label>
    <input required type="email" name="email"><br><br>
   
    <label class="pad_top">First Name</label>
    <input required type="text" name="firstName"><br><br>
    
    <label class="pad_top">Last Name</label>
    <input required type="text" name="lastName"><br><br>
    
    <label class="pad_top">Username</label>
    <input required type="text" name="userName"><br><br>
    
    
    <label class="pad_top">Password</label>
    <input required type="password" name="password"><br>
    <label>&nbsp;</label><br>
     <label class="container_yes">Yes, I would like to receive emails about special promotions and new product information from Bossco. 
    Bossco will not rent or sell your email address.
  	<input type="checkbox">
  	<span class="checkmark"></span>
	</label>
    <label>&nbsp;</label><br>
    <input required type="submit" value="Register" class="margin_left"><br>
   
</form>

</div>
<br>
<p>Already have an account?</p>
<form action="signin" method="get">
<input type="submit" value="Sign In" class="margin_left">
</form>
</div>


<%@ include file="/views/Footer.html" %>
</body>
</html>