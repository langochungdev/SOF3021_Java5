<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div class="mb-3 d-flex gap-2">
		<button class="btn btn-primary" formaction="/category/create">Create</button>
		<button class="btn btn-success" formaction="/category/update">Update</button>
		<button class="btn btn-danger" formaction="/category/delete/${item.id}">Delete</button>
		<button class="btn btn-secondary" formaction="/category/index">Reset</button>
	</div>
</form:form>
