<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>
    <div id = "header">
        <t:insertAttribute name="header"></t:insertAttribute>
    </div>
    <div id="content">
        <t:insertAttribute name="body"></t:insertAttribute>
    </div>
    <div id="footer">
        <t:insertAttribute name="footer"></t:insertAttribute>
    </div>
</body>
</html>