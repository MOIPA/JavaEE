<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/7
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    管理面板
                </h1>
                <p>
                    审核订单模板
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/signoff">退出管理员</a>
                </p>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        订单编号
                    </th>
                    <th>
                        订单主题
                    </th>
                    <th>
                        创建时间
                    </th>
                    <th>
                        订单状态
                    </th>
                    <th>
                        审核
                    </th>
                </tr>
                </thead>
                <tbody class="infoBody">
                    <c:forEach items="${unPassedList}" var="list">
                        <tr class="info">
                            <td>
                                <a href="${pageContext.request.contextPath}/orderDetail?orderid=${item.orderid}">${list.orderid}</a>
                            </td>
                            <td>
                                    ${list.ordertheme}
                            </td>
                            <td>
                                    ${list.posttime}
                            </td>
                            <td>
                                    ${list.orderstatus}
                            </td>
                            <td>
                                    <input type="button" value="通过" src="${list.orderid}" class="btn btn-primary passbtn">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    var passBtns = document.getElementsByClassName("passbtn");
    $(".infoBody").on("click",".passbtn",function(){
        var orderstatus = this.parentNode.previousSibling.previousSibling;
        var orderid = orderstatus.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
        var thisEle = this;

        $.ajax({
            "async":false,
            "url":"${pageContext.request.contextPath}/pass",
            "data":{
                "orderid":orderid.innerText
            },
            "dataType":"json",
            "type":"post",
            "success":function(data){
                alert(data.data);
                thisEle.className = "btn btn-success";
                thisEle.value = "已通过";
                orderstatus.innerText = "已通过";
            },
            "error":function(){
                alert("服务器繁忙");
            }
        });



        // alert(this.className+" || "+orderstatus.innerText+" || "+orderid.innerText);


    });
</script>
</body>
</html>
