<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">

<title>Your Order</title>
<link rel="stylesheet" href="styles/OrdersStyle.css">
</head>
<body>

<div class = "orders">
<h2>Your Orders</h2>
      <table>
           	<thead>
                <tr>
                	<th>Order ID</th>
                    <th>Product Name</th>
                    <th>Product Quantity</th>        
                </tr>
           </thead>
            
           <tbody>
                <c:forEach items="${user.id}" var="orders">
                <tr>
                	<th>${order.id}</th>
                    <td>${product.name}</td>
                    <td>${product.quantity}</td>
                </tr>
                </c:forEach>   
            </tbody>
        </table>
        </div>
    </body>
    
</html>

 