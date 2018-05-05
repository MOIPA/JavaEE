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
</head>
<body>
<jsp:include page="../head.jsp"/>
<%--<%--%>
    <%--Order order = (Order) request.getAttribute("detailInfo");--%>
    <%--System.out.println(order.getPosttime());--%>
<%--%>--%>
<div class="container">
    <div class="row">
        <div style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
            <a href="./index.htm">首页&nbsp;&nbsp;&gt;</a> <a href="./蔬菜分类.htm">蔬菜&nbsp;&nbsp;&gt;</a>
            <a>无公害蔬菜</a>
        </div>

        <div style="margin: 0 auto; width: 950px;">
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
                    发布日期<strong style="color: #ef0101;">${detailInfo.posttime}</strong> 截至日期
                    <del>${detailInfo.ordertime}</del>
                </div>

                <div style="margin: 10px 0 10px 0;">
                    促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
                           style="background-color: #f07373;">限时抢购</a>
                </div>

                <div
                        style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
                    <div style="margin: 5px 0 10px 0;">白色</div>

                    <div
                            style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
                        购买数量: <input id="quantity" name="quantity" value="1"
                                     maxlength="4" size="10" type="text">
                    </div>

                    <div style="margin: 20px 0 10px 0;; text-align: center;">
                        <a href="cart.htm"> <input
                                style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
                                value="加入购物车" type="button">
                        </a> &nbsp;收藏商品
                    </div>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/productListByCid?cid=${cid }&currentPage=${currentPage}">返回列表页面</a>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div style="width: 950px; margin: 0 auto;">
            <div
                    style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                <strong>商品介绍</strong>
            </div>

            <div>
                <img
                        src="${pageContext.request.contextPath }/${product.pimage}">
            </div>

            <div
                    style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                <strong>商品参数</strong>
            </div>
            <div style="margin-top: 10px; width: 900px;">
                <table class="table table-bordered">
                    <tbody>
                    <tr class="active">
                        <th colspan="2">基本参数</th>
                    </tr>
                    <tr>
                        <th width="10%">级别</th>
                        <td width="30%">标准</td>
                    </tr>
                    <tr>
                        <th width="10%">标重</th>
                        <td>500</td>
                    </tr>
                    <tr>
                        <th width="10%">浮动</th>
                        <td>200</td>
                    </tr>
                    </tbody>
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
