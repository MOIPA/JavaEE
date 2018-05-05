<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/5
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头像上传</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uploadAvatar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font/pen.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">

</head>
<body>
<%
    Cookie aidCookie = new Cookie("aid", request.getParameter("aid"));
    response.addCookie(aidCookie);
%>
<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/uplodaAvatar">
    <div class="container">
        <h1>请选择头像
            <small>点击铅笔修改</small>
        </h1>
        <div class="avatar-upload">
            <div class="avatar-edit">
                <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg" />
                <label for="imageUpload"></label>
            </div>
            <div class="avatar-preview">
                <div id="imagePreview" style="background-image: url(http://localhost:8080/WeChatBuy/img/account.png);">
                </div>
            </div>
        </div>
    </div>
    <input type="submit" class="btn-block btn-danger" value="上传头像">
</form>

<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#imagePreview').css('background-image', 'url('+e.target.result +')');
                $('#imagePreview').hide();
                $('#imagePreview').fadeIn(650);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $("#imageUpload").change(function() {
        readURL(this);
    });
</script>
</body>
</html>
