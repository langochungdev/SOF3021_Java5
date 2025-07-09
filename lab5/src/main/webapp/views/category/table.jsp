<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="table-responsive">
	<table class="table table-bordered table-hover">
		<thead class="table-primary">
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
						<form action="/category/edit/${item.id}" method="post" style="display:inline">
							<button class="btn btn-warning btn-sm">Edit</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
