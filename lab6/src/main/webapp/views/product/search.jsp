<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Search Product by Price</title>
</head>
<body>
    <h3>Search Product by Price</h3>
    <form action="/product/search" method="get">
        <input name="min" value="${param.min}" placeholder="Min price?">
        <input name="max" value="${param.max}" placeholder="Max price?">
        <button>Search</button>
    </form>
    <hr>
    <table border="1" width="100%">
        <tr>
            <th>ID</th><th>Name</th><th>Price</th><th>Date</th>
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
