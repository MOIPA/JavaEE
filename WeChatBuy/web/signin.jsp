<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/19
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link href="${pageContext.request.contextPath}/css/sign.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script>
        $("#login-button").click(function(event){
            event.preventDefault();

            $('form').fadeOut(500);
            $('.wrapper').addClass('form-success');
        });
        $(function(){
            $("#loginform").validate({
                rules:{
                    "account":{
                        "required":true
                    },
                    "password":{
                        "required":true
                    }
                },
                messages:{
                    "account":{
                        "required":"密码不能为空"
                    },
                    "password":{
                        "required":"账号不能为空"
                    }
                }
            });
        });
    </script>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <h1>Welcome</h1>

        <form class="form" id="loginform" method="post" action="${pageContext.request.contextPath}/signIn">
            <input type="text" placeholder="account" name="account" id="account">
            <label id="account-error" class="error" for="account" style="display: none">账号不能为空</label>
            <input type="password" placeholder="password" name="password" id="password">
            <label id="password-error" class="error" for="password" style="display: none">密码不能为空</label><br/>
            <button type="submit" id="login-button">Login</button>
            <br />
            <br />
            <a href="${pageContext.request.contextPath}/signup.jsp" style="font-size: 12px;margin-left: -180px;">没有账户？</a>

        </form>
    </div>

    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>

</body>
</html>
