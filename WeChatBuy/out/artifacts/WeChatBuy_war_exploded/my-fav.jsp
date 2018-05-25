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
                                            <input type="button" value="${item.orderstatus}" class="btn btn-primary setStatus">
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
                <br>
                <label class="label label-success" style="font-size: 20px;margin: auto auto">获利总价：<%=request.getAttribute("totalPrice")%></label>
                <br>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title" data-toggle="collapse" data-parent="#panel-354436"
                           href="#panel-element-x">我卖出的</a>
                    </div>
                    <div id="panel-element-x" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        成交订单编号
                                    </th>
                                    <th>
                                        成交订单主题
                                    </th>
                                    <th>
                                        成交价格
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${soldList}" var="item3">
                                    <tr class="info">
                                        <td>
                                            <a href="${pageContext.request.contextPath}/orderDetail?orderid=${item3.orderid}">${item3.orderid}</a>
                                        </td>
                                        <td>
                                                ${item3.ordertheme}
                                        </td>
                                        <td>
                                                ${item3.price}
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
        // this.disabled="true";
        var orderid = this.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.firstChild.nextSibling.innerText;
        if(thisEle.value=="待确认买家付款信息"){
            window.location.href = "${pageContext.request.contextPath}/checkbyer?orderid="+orderid;
        }else if(thisEle.value=="买家已付款"){
            $.ajax({
                "url":"${pageContext.request.contextPath}/sendGoods",
                "dataType":"json",
                "type":"post",
                "success":function(data){
                    if(data.data=="success") {
                        thisEle.value = '发货等待接收';
                        alert("买家发货成功");
                    }
                    else{
                        alert("服务器繁忙");
                    }
                },
                "data":{
                    "orderid":orderid
                }
            });

        }
    });
</script>
<script>
    $("#panel-element-170998").on("click",".setStatus",function(){
        var thisEle = this;
        // select account.aid,account.uiconsrc,account.account,account.email,ByerPayPic.picurl,theorder.ordertheme from account,ByerPayPic,theorder where account.aid = ByerPayPic.aid and ByerPayPic.orderid=theorder.orderid;
        // this.disabled="true";
        var orderid = this.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.firstChild.nextSibling.innerText;
        if(thisEle.value=="发货等待接收"){
            $.ajax({
                "url":"${pageContext.request.contextPath}/receiveGoods",
                "dataType":"json",
                "type":"post",
                "success":function(data){
                    if(data.data=="success") {
                        thisEle.value = '买家已收货';
                        alert("买家收货成功");
                    }
                    else{
                        alert("服务器繁忙");
                    }
                },
                "data":{
                    "orderid":orderid
                }
            });

        }
    });
</script>
</body>
</html>
