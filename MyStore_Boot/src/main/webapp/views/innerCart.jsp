<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="styles/CartStyle.css">
</head>
<body>
<div class="cart-title">
	<span class="cart-name">Cart</span><span id="total-items2">&nbsp;(${cart.getItemCount()}&nbsp;item(s))</span>
	</div>
	<br>
	<div class="Cart">

		<c:forEach items="${cart.getLineItems()}" var="item">
			<div class="item">
				<div class="item-image">
					<img src="${item.product.img}" alt="">
				</div>
				<div class="item-info">
					<span class="item-details" id="item-brand">${item.product.name}</span> <br><span
						class="item-details" id="item-name">${item.product.description}</span>
				</div>
				<div class="item-quantity">
					<a href="update?action=minus&amp;prodcode=${item.product.code}">-</a>
					
					<span class="item-quantity-int">${item.quantity}</span>
					<a href="update?action=plus&amp;prodcode=${item.product.code}">+</a>
				</div>
				<div class="item-price">${item.total}</div>
				<a href="update?action=delete&amp;prodcode=${item.product.code}" class="item-price-a">Remove</a>
			</div>
		</c:forEach>

		

		<div class="total">
			<div class="total-items">
				<span>Total Item(s): </span> <span id="total-items">${cart.getItemCount()}</span>
			</div>
			<div class="total-cost">
				<span>Estimated Total:</span> <span id="total-cost">${cart.getTotalCost()}</span>
			</div>
		</div>
		<div class="checkout">
			<a href="submitorder"><button type="submit" name="button">Checkout</button></a>
		</div>
	</div>
</body>
</html>
