<%@ page import="com.tr.domin.User" %><%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/4
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布成功</title>
</head>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<body style="text-align: center">
    <a id="show_time" class="text-success" style="width: 100%;height: 100%;margin-top: 40%" href="${pageContext.request.contextPath}/index"></a>
</body>
<script>
    var t = 10;
    function tick(){
        if(t==0) {
            location="${pageContext.request.contextPath}/index";
        }
        document.getElementById("show_time").innerHTML ="发布成功"+ t + "秒后跳转到首页......或点击立刻跳转";
        t--;
    }

    setInterval("tick()", 1000);
</script>
</html>
