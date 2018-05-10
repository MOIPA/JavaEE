<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/10
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/handleForm" method="post">
    <input type="text" name="name" placeholder="name"/>
    <input type="text" name="age" placeholder="age"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
