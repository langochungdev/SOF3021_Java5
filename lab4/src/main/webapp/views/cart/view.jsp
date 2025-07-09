<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <div class="table-responsive-md">
            <table class="table table-bordered table-striped align-middle">
                <thead class="table-primary text-center">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Amount</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.items}">
                        <form action="/cart/update/${item.id}" method="post">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.price}</td>
                                <td>
                                    <input name="qty" value="${item.qty}" onblur="this.form.submit()"
                                           style="width: 60px;" class="form-control form-control-sm d-inline-block text-center" />
                                </td>
                                <td>${item.price * item.qty}</td>
                                <td>
                                    <a href="/cart/remove/${item.id}" class="btn btn-sm btn-danger mb-1">Remove</a><br>
                                    <a href="/cart/add/${item.id}" class="btn btn-sm btn-success">Add to Cart</a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

            <div class="d-flex gap-2">
                <a href="/cart/clear" class="btn btn-warning">Clear Cart</a>
                <a href="/item/index" class="btn btn-primary">Add More Items</a>
            </div>
        </div>
    </div>
</body>
</html>
