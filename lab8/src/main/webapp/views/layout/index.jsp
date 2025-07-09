<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Thiết kế layout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-3">
    <tiles:insertAttribute name="header"/>
    
    <nav class="mb-3">
        <div class="d-flex justify-content-center gap-3">
            <a class="btn btn-outline-primary" href="/home/index"><s:message code="lo.mn.home"/></a>
            <a class="btn btn-outline-primary" href="/home/about"><s:message code="lo.mn.about"/></a>
            <a class="btn btn-outline-success" href="?lang=vi">Tiếng việt</a>
            <a class="btn btn-outline-success" href="?lang=en">English</a>
        </div>
    </nav>

    <div class="row">
        <div class="col-md-9">
            <tiles:insertAttribute name="body"/>
        </div>
        <div class="col-md-3">
            <tiles:insertAttribute name="aside"/>
        </div>
    </div>

    <tiles:insertAttribute name="footer"/>
</body>
</html>
