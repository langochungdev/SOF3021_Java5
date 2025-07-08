<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>
		<head>
			<meta charset="utf-8">
			<title>Product Management</title>
		</head>
		<body>
			<form action="/product/search" method="post">
				<h3>Product Search by Price</h3>
				<div class="mb-3">
					<label for="" class="form-label">Min</label>
					<input type="text" class="form-control" name="min" value="${param.min}" />
				</div>
				<div class="mb-3">
					<label for="" class="form-label">Max</label>
					<input type="text" class="form-control" name="max" value="${param.max}" />
				</div>
				<button class="btn btn-primary">search</button>
			</form>
			<hr>
			<table border="1" style="width: 100%">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Date</th>
				</tr>
				<c:forEach var="item" items="${items}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.createDate}</td>
					</tr>
				</c:forEach>
			</table>
		</body>
		</html>