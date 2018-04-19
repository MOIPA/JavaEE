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
    <title>注册</title>
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

            $.validator.addMethod(
                "CheckUser",
            function(value,element,params){
                var flag=false;
                $.ajax({
                    "url":"${pageContext.request.contextPath}/CheckUserName",
                    "async":false,
                    "data":{"username":value},
                    "dataType":"json",
                    "type":"POST",
                    "success":function (data) {
                        flag=data.isAccountExist;
                    }
                });

                return !flag;
            });

           $("#loginform").validate({
               rules:{
                   "account":{
                       "rangelength":[5,11],
                       "required":true,
                       "CheckUser":true
                   },
                   "password":{
                       "rangelength":[5,10],
                       "required":true
                   },
                   "confirmPassword": {
                       "required": true,
                       "rangelength": [5, 10],
                       "equalTo":"#password"
                   },
                   "email":{
                       "required":true,
                       "email":true
                   },
                   "phone":{
                       "required":true,
                       "rangelength": [11, 11]
                   }
               },
               messages:{
                   "account":{
                       "rangelength": "账号需要在5到11位之间",
                       "required":"账号不能为空",
                       "CheckUser":"用户已注册"
                   },
                    "password":{
                        "rangelength":"密码需要在5-10位之间",
                        "required":"账号不能为空"
                    },
                   "confirmPassword":{
                       "rangelength":"密码需要在5-10位之间",
                       "required":"密码不能为空",
                       "equalTo":"两次密码不一致"
                   },
                   "email":{
                       "required":"邮箱不能为空",
                       "email":"邮箱格式不正确"
                   },
                   "phone":{
                       "required":"手机号不能为空",
                       "rangelength": "手机号格式不正确"
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

            <form class="form" id="loginform" action="${pageContext.request.contextPath}/signUp" method="post">
                <input type="text" placeholder="账号" name="account" id="account">
                <input type="password" placeholder="密码" name="password" id="password">
                <input type="password" placeholder="确认密码" name="confirmPassword" id="confirmPassword">
                <input type="text" placeholder="邮箱" name="email" id="email">
                <input type="text" placeholder="手机" name="phone" id="phone">
                <input type="radio" name="identity" id="identity1" value="commonuser" >普通用户
                <input type="radio" name="identity" id="identity2" value="seller" >商家
                <br/>
                <button type="submit" id="login-button">注册</button>

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
