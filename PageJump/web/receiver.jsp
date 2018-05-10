<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/10
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收者</title>
</head>
<body style="text-align: center">

<%
    String name = request.getParameter("name");
    String outS = "";
    outS += "<br>使用java内嵌脚本获取的值" + name;

    Cookie[] cookies = request.getCookies();
    for (Cookie c :
            cookies) {
        if (c.getName().equals("cookieInfo")) {
            outS += "<br>使用cookie获取的值" + c.getValue();
        }
    }

    outS += "<br>使用session获取的值" + session.getAttribute("sessionInfo");
    outS += "<br>使用Application获取的值" + application.getAttribute("application");
//    outS += "<br>使用request获取的值" + request.getAttribute("request");


    response.getWriter().write(outS);
%>
    <br>
    <input type="text" id="js">
    <br>
    <input type="text" id="h5">

    <jsp:useBean id="user" class="bean.UserBean" scope="session"></jsp:useBean>
    <p>
        姓名<jsp:getProperty name="user" property="name" />
        年龄<jsp:getProperty name="user" property="age" />
    </p>
    <p>使用JSP普通方式接收参数</p>
姓名：<%=user.getName()%><br> 年龄：<%=user.getAge()%><br>

</body>

<script>

    // var currentUrl = window.location.href;
    function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
        if (r != null) return unescape(r[2]);
        return null;
    }

    var txtH5 = document.getElementById("js");
    txtH5.value = "使用js技术获取的值" + GetQueryString("name");

    var txtJS = document.getElementById("h5");
    txtJS.value = "使用h5技术获取的值" + localStorage.getItem("age");


</script>
</html>
