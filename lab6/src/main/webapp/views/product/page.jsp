<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Category Management</title>
</head>
<body>
    <h3>PAGiNATION</h3>
    <hr>
    <table border="1" style="width: 100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Date</th>
        </tr>
        <c:forEach var="item" items="${page.content}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.createDate}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/product/page?p=0">first</a>
    <a href="/product/page?p=${page.number-1}">previous</a>
    <a href="/product/page?p=${page.number+1}">next</a>
    <a href="/product/page?p=${page.totalPages-1}">last</a>
    <ul>
        <li>Số thực thể ${page.numberOfElements}</li>
        <li>trang số ${page.number}</li>
        <li>kích thước ${page.size}</li>
        <li>tổng số thực thể ${page.totalElements}</li>
        <li>tổng số trang ${page.totalPages}</li>
    </ul>
</body>
</html>
