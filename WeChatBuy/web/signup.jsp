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
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
    <style>
        .error_label {
            margin-top: -7%;
            right: 4%;
            float: right;
            position: absolute;
            display: none;
        }
        .error_label_selector{
            right: 4%;
            float: right;
            position: absolute;
            display: none;
        }
    </style>
    <script>
        $("#login-button").click(function(event){
            event.preventDefault();
            $('form').fadeOut(500);
            $('.wrapper').addClass('form-success');
        });

        $(function(){
            // alert(document.getElementById("community").innerHTML);
            $.ajax({
                "url":"${pageContext.request.contextPath}/GetCommunity",
                "dataType":"json",
                "type":"POST",
                "success":function(data){
                    for(var i=0;i<data.length;i++) {
                        $("#community").append("<option value=\""+data[i].cid+"\">"+data[i].cname+"</option>");
                    }
                    // alert(content);
                    $('#community').selectpicker('refresh');
                    $('#community').selectpicker('render');
                    // alert(document.getElementById("community").innerHTML);
                }
            });
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
                   },
                   "identity":{
                       "required":true
                   },
                   "community":{
                       "required":true
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
                        "required":"密码不能为空"
                    },
                   "confirmPassword":{
                       "rangelength":"密码需要在5-10位之间",
                       "required":"确认密码不能为空",
                       "equalTo":"两次密码不一致"
                   },
                   "email":{
                       "required":"邮箱不能为空",
                       "email":"邮箱格式不正确"
                   },
                   "phone":{
                       "required":"手机号不能为空",
                       "rangelength": "手机号格式不正确"
                   },
                   "identity":{
                       "required":"请选择身份"
                   },
                   "community":{
                       "required":"请选择社区"
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
                <input type="text" placeholder="账号" name="account" id="account"><label id="account-error" class="error error_label" for="account">账号不能为空</label>
                <input type="password" placeholder="密码" name="password" id="password"><label id="password-error" class="error error_label" for="password">密码不能为空</label>
                <input type="password" placeholder="确认密码" name="confirmPassword" id="confirmPassword"><label id="confirmPassword-error" class="error error_label" for="confirmPassword">确认密码不能为空</label>
                <input type="text" placeholder="邮箱" name="email" id="email"><label id="email-error" class="error error_label" for="email">邮箱不能为空</label>
                <input type="text" placeholder="手机" name="phone" id="phone"><label id="phone-error" class="error error_label" for="phone">手机号不能为空</label>
                <br>
                <%--<label class="radio-inline">--%>
                    <%--<input type="radio" name="identity" id="identity2" value="seller" style="float: left">商家用户--%>
                <%--</label>--%>
                <%--<br>--%>
                <%--<label class="radio-inline">--%>
                    <%--<input type="radio" name="identity" id="identity1" value="commonuser" checked="checked" style="float: left">普通用户--%>
                <%--</label>--%>
                <%--<div style="width: 300px;height: 100px;background-color: #2e6da4;margin: 0px auto">--%>
                    <select name="identity" class="selectpicker" title="用户类型"  data-style="btn-info" >
                        <option value="seller">商家用户</option>
                        <option value="commonuser">普通用户</option>
                    </select>
                <label id="identity-error" class="error error_label_selector" for="identity">请选择身份</label>
                    <div style="height: 10px;width: 100%"></div>
                    <select name="cname" id="community" class="selectpicker" title="社区选择"  data-style="btn-info" style="color: #ffffff;">
                        <%--<option value="volvo">Volvo</option>--%>
                        <%--<option value="saab">Saab</option>--%>
                        <%--<option value="fiat">Fiat</option>--%>
                        <%--<option value="audi">Audi</option>--%>
                    </select>
                <label id="community-error" class="error error_label_selector" for="community">请选择社区</label>
                <%--</div>--%>
                <%--<label class="error" for="identity" style="display:none ">您没有第三种选择</label>--%>

                <div style="height: 15px;width: 100%"></div>
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
    <script>
        //下拉组件设置
        $('.selectpicker').selectpicker('val','seller');
        // $('.selectpicker').selectpicker('val','seller');
        $('.selectpicker').selectpicker('refresh');
    </script>
</body>
</html>
