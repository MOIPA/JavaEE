<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/25
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h2>发布活动</h2>
        <form role="form" enctype="multipart/form-data">
            <div class="form-group">
                <label for="theme">主题</label>
                <input type="text" class="form-control" id="theme" placeholder="请输入主题">
            </div>
            <div class="form-group">
                <label for="endtime">截至日期</label>
                <input type="text" class="form-control" id="endtime" placeholder="请输入日期">
            </div>
            <div class="form-group">
                <label for="desc">描述</label>
                <input type="text" class="form-control" id="desc" placeholder="请输入描述">
            </div>
            <div class="form-group">
                <label for="inputfile">上传图片</label>
                <input type="file" id="inputfile">
                <p class="help-block">这里是块级帮助文本的实例。</p>
            </div>

            <button type="submit" class="btn btn-primary btn-lg">提交</button>
        </form>
    </div>
</div>
</body>

</html>
