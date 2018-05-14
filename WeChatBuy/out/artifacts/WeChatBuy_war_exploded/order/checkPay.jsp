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
                    审核买家提交的交易截图
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="${pageContext.request.contextPath}/index.jsp">退出审核</a>
                </p>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        订单id
                    </th>
                    <th>
                        账户名
                    </th>
                    <th>
                        email
                    </th>
                    <th>
                        头像
                    </th>
                    <th>
                        交易截图
                    </th>
                    <th>
                        订单主题
                    </th>
                    <th>
                        是否通过
                    </th>
                </tr>
                </thead>
                <tbody class="infoBody">
                <c:forEach items="${userPayList}" var="list">
                    <tr class="info">
                        <td>
                            <a href="${pageContext.request.contextPath}/orderDetail?orderid=${list.orderid}">${list.orderid}</a>
                        </td>
                        <td>
                                ${list.account}
                        </td>
                        <td>
                                ${list.email}
                        </td>
                        <td>
                                <img style="width: 60px" src="${pageContext.request.contextPath}/userPic${list.uiconsrc}">
                        </td>
                        <td>
                            <img style="width: 160px" src="${pageContext.request.contextPath}/ByerPayedPic${list.picurl}">
                        </td>
                        <td>
                                ${list.ordertheme}
                        </td>
                        <td>
                            <input type="button" value="通过" name="${list.orderid}" id="${list.aid}" src="${list.orderid}" class="btn btn-primary passbtn">
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
        var aid = this.id;
        var orderid = this.name;
        var thisEle = this;
        alert(aid + "==" + orderid);

        $.ajax({
            "async":false,
            "url":"${pageContext.request.contextPath}/passUserPay",
            "data":{
                "orderid":orderid,
                "aid":aid
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
