<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lab1</title>
</head>
<body>
	<h1>hello spring boot</h1>
	<h2>${mes}</h2>
	<form action="create" method="post">
		<input type="text" name="name" placeholder="name"/> <br>
		<input type="text" name="pass" placeholder="password"/> <br>
		<button type="submit">ok</button>
	</form>
</body>
</html>