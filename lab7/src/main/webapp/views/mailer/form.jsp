<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gửi Email</title>
</head>
<body>
    <h2>Gửi Email</h2>
    <form action="/mailer/send" method="post" enctype="multipart/form-data">
        <label>From:</label><br>
        <input type="text" name="from" value="langochungse23@gmail.com"><br><br>

        <label>To:</label><br>
        <input type="text" name="to"><br><br>

        <label>CC (phân cách bởi dấu phẩy):</label><br>
        <input type="text" name="cc"><br><br>

        <label>BCC (phân cách bởi dấu phẩy):</label><br>
        <input type="text" name="bcc"><br><br>

        <label>Subject:</label><br>
        <input type="text" name="subject"><br><br>

        <label>Body:</label><br>
        <textarea name="body" rows="8" cols="50"></textarea><br><br>

        <label>Đính kèm:</label><br>
        <input type="file" name="attachments" multiple><br><br>

        <button type="submit">Gửi Email</button>
    </form>
</body>
</html>
