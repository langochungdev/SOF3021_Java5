<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="table-responsive">
	<table class="table table-primary">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>edit</th>
		</tr>
		<c:forEach var="item" items="${items}">

			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><a href="/category/edit/${item.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>