<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
	<title>Category Management</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="col-lg-6 m-auto mt-5">
		<h3 class="text-center">Category Management</h3>

		<form:form action="/category/index" modelAttribute="item">
			<div class="mb-3">
				<label class="form-label">Category Id</label>
				<form:input cssClass="form-control" path="id" placeholder="Category Id?" />
			</div>
			<div class="mb-3">
				<label class="form-label">Category Name</label>
				<form:input cssClass="form-control" path="name" placeholder="Category name?" />
			</div>
			<hr />
			<div class="d-flex gap-2">
				<button class="btn btn-primary" formaction="/category/create">Create</button>
				<button class="btn btn-success" formaction="/category/update">Update</button>
				<a href="/category/delete/${item.id}" class="btn btn-danger">Delete</a>
				<a href="/category/index" class="btn btn-secondary">Reset</a>
			</div>
		</form:form>

		<hr>

		<div class="table-responsive mt-3">
			<table class="table table-bordered table-striped">
				<thead class="table-light">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>
								<a href="/category/edit/${item.id}" class="btn btn-sm btn-warning">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
