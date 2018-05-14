<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gson</title>
</head>
<body style="text-align: center;">

<label>即将发送的附加的Json串:{"name":"JsonName","age":"JsonAge"}</label>
<br>
<form   action="${pageContext.request.contextPath}/gson" method="post" >
    <input type="text" name="name" placeholder="name">
    <br>
    <input type="text" name="age" placeholder="age">
    <br>
    <input name="json_t" value='{"name":"JsonName","age":"JsonAge"}' style="display: none;">
    <input type="submit" value="submit">
</form>
</body>
</html>
