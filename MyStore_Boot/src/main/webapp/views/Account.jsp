<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Information</title>
<link rel="stylesheet" href="styles/register.css" type="text/css"/>
 <script src="scripts/login.js" charset="utf-8"></script>
</head>
<body>
<%@ include file="/views/navbar.jsp" %>
<div class="registrationContainer">
<h1>Account Information</h1>
<h2>Update your info here</h2>


<br>

<div id="registration">
<form action="updateUser" method="post">  
          
    <label class="pad_top">Email</label>
    <input required type="email" name="email" value="${user.email}"><br><br>
    
    <label class="pad_top">First Name</label>
    <input required type="text" name="firstName" value="${user.firstName}"><br><br>
    
    <label class="pad_top">Last Name</label>
    <input required type="text" name="lastName" value="${user.lastName}"><br><br>
    
    <label class="pad_top">Username</label>
    <input required type="text" name="username" value="${user.username}"><br><br>
    
    <label class="pad_top">Password</label>
    <input required type="password" name="password"><br>
  
    <label>&nbsp;</label><br>
    <input required type="submit" value="Update" class="margin_left_update">
     <label>&nbsp;</label><br>
</form>
</div>
<br>
</div>

<%@ include file="/views/Footer.html" %>
</body>
</html>