<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/24
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/navigator.css">
</head>
<style>

    .header_logo {
        z-index: 999;
        position: fixed;
        background-color: #30a6e6;
        height: 8%;
        width: 100%;
    }

</style>
<body>
<div class="header_logo">
    <img src="${pageContext.request.contextPath}/img/logo.png" style="float: left;height: 60px" />
    <!--<span class="iconfont icon-back"></span>-->
    <%--<div class="header_navigator">--%>
    <nav class="dropdownmenu" style="margin-left: 25%;margin-top: 0px;">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index">主页</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="#">发布</a>
                <ul id="submenu">
                    <li><a href="${pageContext.request.contextPath}/order/postOrder.jsp">订单</a></li>
                    <li><a href="${pageContext.request.contextPath}/order/postActivity.jsp">活动</a></li>
                </ul>
            </li>
            <li><a href="#">新闻</a></li>
            <li><a href="#">联系我们</a></li>
        </ul>
    </nav>
    <button id="btn_signoff" class="btn-block btn-danger" style="float: right;margin-right: 30px;width: 60px;height: 38px;border-radius: 5px;margin-top: 10px;">注销</button>
    <%--</div>--%>
</div>
</body>
<script>
    var signOffBtn = document.getElementById("btn_signoff");
    signOffBtn.onclick = function(){
        window.location.replace("${pageContext.request.contextPath}/signoff");
    };
</script>
</html>
