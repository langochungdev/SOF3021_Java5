<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="/category/index" modelAttribute="item">
	<div class="mb-3">
		<label for="" class="form-label">Category Id</label>
		<form:input cssClass="form-control" path="id" placeholder="Category Id?" />
	</div>
	<div class="mb-3">
		<label for="" class="form-label">Category Name</label>
		<form:input cssClass="form-control" path="name" placeholder="Category name?" />
		<hr />
		<button class="btn btn-primary" formaction="/category/create">Create</button>
		<button class="btn btn-primary" formaction="/category/update">Update</button>
		<a href="/category/delete/${item.id}">Delete</a>
		<a href="/category/index">Reset</a>
</form:form>

