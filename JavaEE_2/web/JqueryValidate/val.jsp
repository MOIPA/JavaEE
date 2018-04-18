<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/17
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>表单验真</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="text/javascript">
        // $(document).ready(function(){
        //     alert("b");
        // });
        $(function(){
            //自定义校验规则
            //value:输入的内容，element:背校验的元素对象，params:规则对应的参数值
            //对输入的username进行ajax判断
            $.validator.addMethod(
                "isExist",
                function(value,element,params){
                    var flag=false;
                    $.ajax({
                        "url":"${pageContext.request.contextPath}/checkUserName",
                        "async":false,
                        "data":{"username":value},
                        "dataType":"json",
                        "type":"POST",
                        "success":function(data){
                                // if(data.isNameExist=='true')flag=true;
                                // alert(flag);
                                flag=data.isNameExist;
                            }
                        });
                    // alert(!flag);
                    //返回false代表校验器失败 否则通过
                    return !flag;
            });
            $("#myform").validate({
                rules:{
                    "uname":{
                        "required":true
                    },
                    "pwd":{
                        "isExist":true
                    }
                },
                messages:{
                    "uname":{
                        "required":"请输入名字"
                    },
                    "pwd":{
                        "isExist":"用户存在"
                    }
                }
            });

        });
    </script>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
    <form id="myform">
        <input type="text" placeholder="name" name="uname">
        <input type="text" placeholder="pwd" name="pwd">
        <br />
        <input type="submit" value="submit">
    </form>
</body>
</html>