<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Shop</title>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<div class="container mt-4">
		<div class="row g-3">
			<c:forEach var="item" items="${items}">
				<div class="col-md-4">
					<div class="card h-100 shadow-sm">
						<div class="card-body">
							<h5 class="card-title">${item.name}</h5>
							<p class="card-text text-muted">$${item.price}</p>
							<a href="/cart/add/${item.id}" class="btn btn-primary">Add To Cart</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
