<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/7
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center">
<a id="show_time" class="text-success" style="width: 100%;height: 100%;margin-top: 40%" href="${pageContext.request.contextPath}/index"></a>
</body>
<script>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    var t = 5;
    function tick(){
        if(t==0) {
            location="${pageContext.request.contextPath}/index";
        }
        document.getElementById("show_time").innerHTML ="${pageContext.request.getParameter("data")}====>"+ t + "秒后跳转到首页......或点击立刻跳转";
        t--;
    }
    setInterval("tick()", 1000);
</script>
</html>
