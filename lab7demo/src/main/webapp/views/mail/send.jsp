<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Email</title>
</head>
<body>
    <h2>Send Email</h2>
    <h1>kết quả: ${message}</h1>
    <form action="/sendEmail" method="post" enctype="multipart/form-data">
        <label for="from">From:</label><br>
        <input type="text" id="from" name="from"><br>
        
        <label for="to">To:</label><br>
        <input type="text" id="to" name="to"><br>
        
        <label for="cc">CC:</label><br>
        <input type="text" id="cc" name="cc"><br>
        
        <label for="bcc">BCC:</label><br>
        <input type="text" id="bcc" name="bcc"><br>
        
        <label for="subject">Subject:</label><br>
        <input type="text" id="subject" name="subject"><br>
        
        <label for="body">Body:</label><br>
        <textarea id="body" name="body"></textarea><br>
        
        <label for="attachments">Attachments:</label><br>
        <input type="file" id="attachments" name="attachments" multiple><br>
        
        <input type="submit" value="Send Email">
    </form>
</body>
</html>
