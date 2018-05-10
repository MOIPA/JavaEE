<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/10
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.UserBean" %>
<html>
<head>
    <title>sender</title>
</head>
<body style="text-align: center">


<p type="text">java bean技术 发送tzq 18</p>
<p type="text">application技术 发送theApplication</p>
<p type="text">localStorage技术 发送18</p>
<p type="text">request 存值 发送theRequest</p>


<jsp:useBean id="user" class="bean.UserBean" scope="session"/>

<%
    //bean技术
    user.setName("tzq");
    user.setAge("18");

    //application技术
    application.setAttribute("application", "theApplication");

%>
发送者
<br>

<input id="data" type="text" placeholder="url技术要发送的数据"/>
<br>
<button id="click">js技术发送数据到接受页面</button>

</body>

<script>

    //js技术
    var btn = document.getElementById("click");
    var data = document.getElementById("data");
    btn.onclick = function () {
        // alert(data.value);
        window.location.href = "http://localhost:8080/PageJump/receiver.jsp?name=" + data.value;
    }

    //h5技术
    localStorage.setItem("age", "18");
</script>
</html>
