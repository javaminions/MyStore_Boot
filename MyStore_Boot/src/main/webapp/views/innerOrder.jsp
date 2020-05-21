<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">

<title>Your Order</title>
<link rel="stylesheet" href="styles/OrdersStyle.css">
<link rel="stylesheet" href="styles/CartStyle.css">
</head>
<body>

	<div class="orders">
		<h2>Your Orders</h2>
		<c:forEach items="${orderHistory}" var="orderHistory">


			<div class="Cart">
				<span>${orderHistory.orderNumber}</span>
				<c:forEach items="${orderHistory.cart.getLineItems()}" var="item">
					<div class="item">
						<div class="item-image">
							<img src="${item.product.img}" alt="">
						</div>
						<div class="item-info">
							<span class="item-details" id="item-brand">${item.product.name}</span>
							<span class="item-details" id="item-name">${item.product.description}</span>
						</div>
						<div class="item-quantity">
							<span class="item-quantity-int">${item.quantity}</span> <a
								href="update?action=plus&amp;prodcode=${item.product.code}">+</a>
						</div>
						<div class="item-price">${item.total}</div>
						
					</div>
				</c:forEach>



				<div class="total">
					<div class="total-items">
						<span>Total Items: </span> <span id="total-items">${cart.getItemCount()}</span>
					</div>
					<div class="total-cost">
						<span>Total:</span> <span id="total-cost">${cart.getTotalCost()}</span>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>

</html>

