<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/10
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
</head>
<body style="text-align: center">
ajax 获取的值:<p id="ajaxT"></p>
</body>
<script>

    var res = document.getElementById("ajaxT");
    $(function(){
        // alert(document.getElementById("community").innerHTML);
        $.ajax({
            "url": "http://localhost:8080/PageJump/ajax",
            "dataType": "json",
            "type": "POST",
            "success": function (data) {
                res.innerText =  data.data;
            },
            "error":function(data) {
                alert("服务器繁忙");
            }
        });
    });
</script>
</html>
