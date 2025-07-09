<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<h3>LOGIN</h3>
<b><i>${message}${param.error}</i></b>

<form action="/account/login" method="post">
    <input name="username" placeholder="Username?"><br><br>
    <input name="password" placeholder="Password?" type="password"><br><br>
    <button>Login</button>
</form>
