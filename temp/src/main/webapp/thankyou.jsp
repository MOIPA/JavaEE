<%--
  Created by IntelliJ IDEA.
  User: tr
  Date: 19-3-5
  Time: 下午1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<html>
<head>
    <title>Thank you for registering</title>
</head>
<body>
    <p>you registration infomation is <s:property value="personBean"/></p>
    <a href="<s:url action="index" />">back to main page</a>
</body>
</html>
