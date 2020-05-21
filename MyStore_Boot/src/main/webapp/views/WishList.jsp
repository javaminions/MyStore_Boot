<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <meta charset="utf-8">
  <title></title>
  <link rel="stylesheet" href="styles/WishListStyle.css">
</head>
<body>
<%@ include file="/views/navbar.jsp" %>
  <div class="WishList">
      <div id="WishList-title">
      <h1>WishList</h1>
      <p>Your WishList items. Click add to cart and checkout !</p>
    </div>
 <c:if test = "${wishlistProducts != null}">
    <c:forEach var="product" items="${wishlistProducts}">
    <div class="card">
      <img src="${product.img}" alt="" style="width:100%">
      <h1>${product.name}</h1>
      <p class="price">${product.getPriceCurrencyFormat()}</p>
      <p>${product.description}</p>
      <p><button>Add to Cart</button></p>
    </div>
   </c:forEach>
   </c:if>
  </div>
<%@ include file="/views/Footer.html" %>
</body>
</html>