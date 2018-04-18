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
            $("#myform").validate({
                rules:{
                    "uname":{
                        "required":true
                    }
                },
                messages:{
                    "uname":{
                        "required":"请输入名字"
                    }
                }
            });
        });
    </script>
</head>
<body>
    <form id="myform">
        <input type="text" placeholder="name" name="uname">
        <br />
        <input type="submit" value="submit">
    </form>
</body>
</html>