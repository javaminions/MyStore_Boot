<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/categories.css">
<link rel="stylesheet" href="styles/snackbar.css">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		console.log("category");
		var urlParams = new URLSearchParams(window.location.search);
		var category = urlParams.get("filterCategory");
		if (category != null && category != "") {
			filterSelection(category);
		} else {
			filterSelection("all");
		}
		
		function myFunction() {
			  var x = document.getElementById("snackbar");
			  x.className = "show";
			  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
			}

		var supplyResponse = '${supplierRestockResponse}'; 

		if(supplyResponse != null && supplyResponse != "") {
			console.log(supplyResponse);
			myFunction(); 
		}
	});
</script>
<body>

	<div class="top">
		<a href="/"><img alt="Costco Logo"
			src="https://javaminions.github.io/images/BossCo.png"
			style="width: 20%; height: auto;"></a>
	</div>

	<h2 style="text-align: center">Products</h2>
	<div class="container">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark bg-white">
			<form class="form-inline" action="categories" method="post">
				<div class="wrap">
					<a href="/" class="homeButton"><i class="fas fa-home"></i></a>
				</div>
				<input type="hidden" name="hiddenSearch" value=""> <input
					class="form-control mr-sm-2" style="margin-left: 50px;" type="text"
					placeholder="Search" id="searchInput" name="searchInput">
				<div class="wrap">
					<!-- <button class="btn" style="color: white; background-color: rgb(0, 115, 166)" type="submit">Search</button> -->
					<input class="btn fonts" type="submit" id="searchButton"
						value="Search" class="button2">

				</div>
				<div class="wrap">
					<a href="showall" class="cart"><i class="fas fa-shopping-cart"></i><span
						class='badge badge-warning' id='lblCartCount'>${cartCount}</span></a>
				</div>
			</form>
		</nav>
	</div>
	<br>

	<div id="myBtnContainer">
		<button href="categories" class="btn fonts active"
			onclick="filterSelection('all')">Show all</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('apparel')">Apparel</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('accessories')">Accessories</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('sports')">Sports Equipment</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('outdoors')">Outdoors</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('groceries')">Groceries</button>
		<button href="categories" class="btn fonts"
			onclick="filterSelection('clearance')">Clearance</button>
	</div>
	<div class="container">
		<c:if
			test="${isProductsFiltered != 'yes' || isProductsFiltered == null}">
			<c:forEach var="product" items="${products}">
				<c:choose>
					<c:when test="${product.inventory=='0'}">
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

				<div class="filterDiv ${product.category} ${product.code}">
					<div class="card" style="width: 18rem;">
						<a href="wishlistAdd?prodcode=${product.code}"
							class="card-link text-danger d-flex justify-content-end"
							style="padding: 10px 10px 0 0;"> <i class="fas fa-heart"></i>
						</a> <img class="card-img-top" src="${product.img}" alt="Vans">
						<div class="card-body">
							<h4 class="card-title">${product.name}</h4>
							<h6 class="card-subtitle mb-2 text-muted" style="${theColor}">Status:
								${stock}</h6>
							<p class="card-text">${product.description}</p>
							<div class="options d-flex flex-fill">
								<select class="custom-select mr-1">
									<option selected>Color</option>
									<option value="1">Green</option>
									<option value="2">Blue</option>
									<option value="3">Red</option>
								</select> <select class="custom-select ml-1">
									<option selected>Size</option>
									<option value="1">41</option>
									<option value="2">42</option>
									<option value="3">43</option>
								</select>
							</div>
							<c:if test="${user.isAdmin() == true}">
								<div class="quantity">
									<p>Stock: ${product.inventory}</p>
								</div>
							</c:if>
							<div
								class="buy d-flex justify-content-between align-items-center">
								<div class="price text-success">
									<h5 class="mt-4">${product.getPriceCurrencyFormat()}</h5>
								</div>

								<a
									href="addtocart?action=addtocart&amp;prodcode=${product.code}"
									class="btn btn-danger mt-3 cartButton ${disableButton}"><i
									class="fas fa-shopping-cart"></i> Add to Cart</a>
							</div>
									<c:if test="${user.isAdmin() == true}">
									<form action="restock" method="post">  
								<input type="hidden" name="prodCode" id="prodCode" value="${product.code}">
								<div class="row justify-content-end" style="margin-top: 5px">
									<div class="col-sm-12">
										<div class="input-group">
											<input type="text" class="form-control"
												placeholder="Quantity..." name="restockQuantity" id="restockQuantity">
											<div class="input-group-append">
											    <button type="submit" onclick="myFunction()" class="btn btn-primary"><i class="fas fa-plus"></i> Restock</button>
											</div>
										</div>
									</div>
								</div>
								</form>
							</c:if>				
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>

		<c:if test="${isProductsFiltered == 'yes'}">
			<div style="margin-right: 1%; margin-top: 0.5%;">
				<p>Filters:</p>
				<a href="categories" class="btn btn-outline-info"
					style="height: 40px; font-family: Montserrat, Charcoal, sans-serif;"><i
					class="fas fa-times"></i> ${filter}</a>
			</div>

			<c:forEach var="product" items="${filteredProducts}">
				<c:choose>
					<c:when test="${product.inventory=='0'}">
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

				<div class="filterDiv ${product.category} ${product.code}">
					<div class="card" style="width: 18rem;">
						<a href="wishlistAdd?prodcode=${product.code}"
							class="card-link text-danger d-flex justify-content-end"
							style="padding: 10px 10px 0 0;"> <i class="fas fa-heart"></i>
						</a> <img class="card-img-top" src="${product.img}" alt="Vans">
						<div class="card-body">
							<h4 class="card-title">${product.name}</h4>
							<h6 class="card-subtitle mb-2 text-muted" style="${theColor}">Status:
								${stock}</h6>
							<p class="card-text">${product.description}</p>
							<div class="options d-flex flex-fill">
								<select class="custom-select mr-1">
									<option selected>Color</option>
									<option value="1">Green</option>
									<option value="2">Blue</option>
									<option value="3">Red</option>
								</select> <select class="custom-select ml-1">
									<option selected>Size</option>
									<option value="1">41</option>
									<option value="2">42</option>
									<option value="3">43</option>
								</select>
							</div>
							<c:if test="${user.isAdmin() == true}">
								<div class="quantity">
									<p>${product.inventory}</p>
								</div>
							</c:if>
							<div
								class="buy d-flex justify-content-between align-items-center">
								<div class="price text-success">
									<h5 class="mt-4">${product.getPriceCurrencyFormat()}</h5>
								</div>

								<a
									href="addtocart?action=addtocart&amp;prodcode=${product.code}"
									class="btn btn-danger mt-3 cartButton ${disableButton}"><i
									class="fas fa-shopping-cart"></i> Add to Cart</a>
							</div>				
								<c:if test="${user.isAdmin() == true}">
								<form action="restock" method="post">  
								<input type="hidden" name="prodCode" id="prodCode" value="${product.code}">
								<div class="row justify-content-end" style="margin-top: 5px">
									<div class="col-sm-12">
										<div class="input-group">
											<input type="text" class="form-control"
												placeholder="Quantity..." name="restockQuantity">
											<div class="input-group-append">
											    <button type="submit" onclick="myFunction()" class="btn btn-primary"><i class="fas fa-plus"></i> Restock</button>
											</div>
										</div>
									</div>
								</div>
								</form>
							</c:if>		
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
			<div id="snackbar"><a href="fulfillment" id="orderStatus">Request sent! ${supplierRestockResponse}  <span id="theIcon"><i class="fas fa-angle-double-right"></i></span></a></div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="scripts/categories.js"></script>
	<script src="scripts/cart.js"></script>
</body>
</html>