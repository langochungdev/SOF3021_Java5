<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory By Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <div class="container mt-5">
        <h3 class="text-center mb-4">Thống kê tồn kho theo loại hàng</h3>

        <table class="table table-bordered table-striped">
            <thead class="table-light">
                <tr>
                    <th>Loại hàng</th>
                    <th>Tổng giá</th>
                    <th>Số sản phẩm</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.group.name}</td>
                        <td>${item.sum}</td>
                        <td>${item.count}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
