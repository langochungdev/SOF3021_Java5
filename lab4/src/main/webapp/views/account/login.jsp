<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="col-lg-4 m-auto">
        <h2 class="text-center">Login</h2>
        <div class="mb-3">
            <form action="/account/login" method="post">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="username" value="${savedUsername}" />

                <label class="form-label">Password</label>
                <input type="text" class="form-control" name="password" value="${savedPassword}" />

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="remember" value="true" />
                    <label class="form-check-label"> Remember me </label>
                </div>

                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
