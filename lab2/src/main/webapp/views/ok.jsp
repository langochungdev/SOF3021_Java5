<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form method="post">
        <button formaction="/ok1">OK 1</button>
        <button formaction="/ok2">OK 2</button>
        <button formaction="/ok3">OK 3</button>
    </form>
    <p>Kết quả: ${noidung}</p>
</body>

</html>