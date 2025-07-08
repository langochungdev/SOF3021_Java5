<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Title</title>
			<!-- Required meta tags -->
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

			<!-- Bootstrap CSS v5.2.1 -->
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
				crossorigin="anonymous" />
		</head>

		<body>
			<div class="container">
				<div class="table-responsive-md">
					<table class="table table-primary">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Amount</th>
								<th>Edit</th>
							</tr>
						</thead>
						<c:forEach var="item" items="${cart.items}">
							<form action="/cart/update/${item.id}" method="post">
								<input type="hidden" name="id" value="${item.id}">
								<tr>
									<td>${item.id}</td>
									<td>${item.name}</td>
									<td>${item.price}</td>
									<td><input name="qty" value="${item.qty}" onblur="this.form.submit()"
											style="width: 50px;" /></td>
									<td>${item.price * item.qty}</td>
									<td><a href="/cart/remove/${item.id}">remove</a> <br>
										<a href="/cart/add/${item.id}">Add To Cart</a>
									</td>
								</tr>
							</form>
						</c:forEach>
					</table>
					<a href="/cart/clear">Clear</a> <br>
					<a href="/item/index">Add more</a> <br>
					<form action="/cart/update/${item.id}" method="post"></form>
				</div>
			</div>

			<!-- Bootstrap JavaScript Libraries -->
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
				integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
				crossorigin="anonymous"></script>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
				integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
				crossorigin="anonymous"></script>
		</body>

		</html>