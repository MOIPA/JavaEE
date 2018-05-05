<%@ page import="com.tr.domin.Order" %><%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/5
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigator.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<style>
    body {
        margin-top: 20px;
        margin: 0 auto;
    }

    .carousel-inner .item img {
        width: 100%;
        height: 300px;
    }
</style>
<body>
<jsp:include page="../head.jsp"/>
<%--<%--%>
    <%--Order order = (Order) request.getAttribute("detailInfo");--%>
    <%--System.out.println(order.getPosttime());--%>
<%--%>--%>
<div class="container" style="padding-top:6%">
    <div class="row">
        <div style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
            <a href="${pageContext.request.contextPath}/index">首页&nbsp;&nbsp;&gt;</a>
            <a>详情页面</a>
        </div>

        <div style="margin: 0 auto;height:380px; width: 950px;">
            <div class="col-md-6">
                <img style="opacity: 1; width: 400px; height: 350px;" title=""
                     class="medium"
                     src="${pageContext.request.contextPath }/postedPic/${detailInfo.rorderpicsrc}">
            </div>

            <div class="col-md-6">
                <div>
                    <strong>${detailInfo.ordertheme}</strong>
                </div>
                <div
                        style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
                    <div>参与者：${detailInfo.followers}</div>
                </div>

                <div style="margin: 10px 0 10px 0;">
                    发布日期<p >${detailInfo.posttime}</p>
                    <strong style="color: #ef0101;">截至日期:${detailInfo.ordertime}</strong>
                </div>

                <div style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
                    <form class="bs-example bs-example-form" role="form">
                        留言<div class="input-group">
                                <span class="input-group-addon">@</span>
                                <input type="text" class="form-control" placeholder="您的留言">
                            </div>
                        <br>
                        <div class="input-group">
                            <input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;" value="点击参与" type="submit">
                        </div>
                    </form>
                    <%--<div style="margin: 20px 0 10px 0;; text-align: center;">--%>
                        <%--<a href="cart.htm">--%>
                            <%----%>
                        <%--</a>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div style="width: 950px; margin: 0 auto;">
            <div style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                <strong>主题</strong>
            </div>

            <div>
                <p>${detailInfo.ordercontent}</p>
            </div>

            <div style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                <strong>图片展示</strong>
            </div>
            <div style="margin-top: 10px; width: 900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <c:forEach items="${urlLists}" var="url">
                            <td width="30%"><img style="width: 100%;" src="postedPic${url}" alt=""></td>
                        </c:forEach>
                    </tr>
                </table>
            </div>

            <div style="background-color: #d3d3d3; width: 900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th><strong>商品评论</strong></th>
                    </tr>
                    <tr class="warning">
                        <th>暂无商品评论信息 <a>[发表商品评论]</a></th>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div style="background-color: #d3d3d3; width: 900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th><strong>商品咨询</strong></th>
                    </tr>
                    <tr class="warning">
                        <th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</body>
</html>
