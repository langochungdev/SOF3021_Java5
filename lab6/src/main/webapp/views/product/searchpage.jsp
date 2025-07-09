<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Search Product with Pagination</title>
</head>
<body>
    <h3>Search by keyword with Pagination</h3>
    <form action="/product/searchPage" method="get">
        <input name="keywords" value="${param.keywords}" placeholder="Search keywords?">
        <button>Search</button>
    </form>
    <hr>
    <table border="1" width="100%">
        <tr>
            <th>ID</th><th>Name</th><th>Price</th><th>Date</th>
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

    <c:set var="kw" value="${param.keywords}" />
<a href="?keywords=${kw}&p=0">First</a>

<c:if test="${!page.first}">
    <a href="?keywords=${kw}&p=${page.number - 1}">Previous</a>
</c:if>

<c:if test="${!page.last}">
    <a href="?keywords=${kw}&p=${page.number + 1}">Next</a>
</c:if>

<a href="?keywords=${kw}&p=${page.totalPages - 1}">Last</a>

    <ul>
        <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
        <li>Trang số: ${page.number}</li>
        <li>Kích thước trang: ${page.size}</li>
        <li>Tổng số thực thể: ${page.totalElements}</li>
        <li>Tổng số trang: ${page.totalPages}</li>
    </ul>
</body>
</html>
