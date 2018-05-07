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
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <img alt="140x140" src="v3/default3.jpg" />
            <div class="list-group">
                <a href="#" class="list-group-item active">我的设置</a>
                <div class="list-group-item">
                    <a id="changeAvatar">修改头像</a>
                </div>
                <div class="list-group-item">
                    <a id="changeInfo">修改个人信息</a>
                </div>
                <div class="list-group-item">
                    <a id="myFollow">我参与的</a>
                </div>
                <div class="list-group-item">
                    <a id="myPost">我发布的</a>
                </div>
            </div>
        </div>
        <div class="col-md-8 column">
        </div>
    </div>
</div>

</body>
</html>
