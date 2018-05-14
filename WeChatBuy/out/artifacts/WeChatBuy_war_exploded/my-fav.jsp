<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/5
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的收藏</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="container" style="padding-top: 6%">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    订单管理
                    <small>参与和发布</small>
                </h1>
            </div>
            <div class="panel-group" id="panel-354436">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-354436"
                           href="#panel-element-170998">我参与的</a>
                    </div>
                    <div id="panel-element-170998" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table table-hover">
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
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${followedList}" var="item">
                                    <tr class="info">
                                        <td>
                                            <a href="${pageContext.request.contextPath}/orderDetail?orderid=${item.orderid}">${item.orderid}</a>
                                        </td>
                                        <td>
                                                ${item.ordertheme}
                                        </td>
                                        <td>
                                                ${item.posttime}
                                        </td>
                                        <td>
                                                ${item.orderstatus}
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-354436"
                           href="#panel-element-136640">我发布的</a>
                    </div>
                    <div id="panel-element-136640" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table table-hover">
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
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${postedList}" var="item2">
                                    <tr class="info">
                                        <td>
                                            <a href="${pageContext.request.contextPath}/orderDetail?orderid=${item2.orderid}">${item2.orderid}</a>
                                        </td>
                                        <td>
                                                ${item2.ordertheme}
                                        </td>
                                        <td>
                                                ${item2.posttime}
                                        </td>
                                        <td>
                                            <input type="button" value="${item2.orderstatus}" class="btn btn-primary setStatus">
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    $("#panel-element-136640").on("click",".setStatus",function(){
        var thisEle = this;
        // select account.aid,account.uiconsrc,account.account,account.email,ByerPayPic.picurl,theorder.ordertheme from account,ByerPayPic,theorder where account.aid = ByerPayPic.aid and ByerPayPic.orderid=theorder.orderid;
        if(thisEle.value=="待确认买家付款信息"){
            this.disabled="true";
            var orderidT = this.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;

            <%--var orderid = orderidT.innerText;--%>
            window.location.href = "${pageContext.request.contextPath}/checkbyer?orderid="+orderidT.firstChild.nextSibling.innerText;
        }
    });
</script>
</body>
</html>
