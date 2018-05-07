<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/5
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadAvatar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font/pen.css">
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="container" style="padding-top: 6%">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <img alt="140x140" src="v3/default3.jpg" />
            <div class="list-group">
                <a href="#" class="list-group-item active">我的设置</a>
                <div class="list-group-item">
                    <button class="btn btn-primary" id="changeAvatar">修改头像</button>
                </div>
                <div class="list-group-item">
                    <button class="btn btn-primary" id="changeInfo">修改个人信息</button>
                </div>
                <div class="list-group-item">
                    <button class="btn btn-primary" id="myFollow">我参与的</button>
                </div>
                <div class="list-group-item">
                    <button class="btn btn-primary" id="myPost">我发布的</button>
                </div>
            </div>
        </div>
        <iframe class="col-md-8 column" id="iframe_show" src="http://localhost:8080/${pageContext.request.contextPath}/uploadAvatar.jsp">
        </iframe>
    </div>
</div>

</body>
</html>
