<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="styles/WishListStyle.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="/views/navbar.jsp"%>
	<div class="WishList">
		<div id="WishList-title">
			<h1>WishList</h1>
			<p>Your WishList items. Click add to cart and checkout !</p>
		</div>
		<c:if test="${wishlistProducts != null}">
			<c:forEach var="product" items="${wishlistProducts}">
				<c:choose>
					<c:when test="${product.inventory=='0' || product.inventory==null}">
						<c:set var="stock" scope="session" value="Out of stock" />
						<c:set var="theColor" scope="session"
							value="color: red !important;" />
						<c:set var="disableButton" scope="session" value="disabled" />
					</c:when>
					<c:otherwise>
						<c:set var="stock" scope="session" value="Available" />
						<c:set var="theColor" scope="session" value="" />
						<c:set var="disableButton" scope="session" value="" />
					</c:otherwise>
				</c:choose>
				<div class="card">
					<a href="wishlistDelete?prodcode=${product.code}"
						class="card-link text-danger d-flex justify-content-end"
						style="padding: 10px 10px 0 0;"> <i class="fas fa-times"></i>
					</a> <img src="${product.img}" alt="" style="width: 100%">
					<h1>${product.name}</h1>
					<p class="price">${product.getPriceCurrencyFormat()}</p>
					<p>${product.description}</p>
					<a href="addtocart?action=addtocart&amp;prodcode=${product.code}"
						class="btn btn-danger mt-3 cartButton ${disableButton}"><i
						class="fas fa-shopping-cart"></i> Add to Cart</a>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<%@ include file="/views/Footer.html"%>
</body>
</html>