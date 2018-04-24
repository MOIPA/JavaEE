<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/4/20
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/iconfont.css" />
    <link rel="stylesheet" href="css/navigator.css" />
    <!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">-->
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        body {
            width: 100%;
            margin: 0px auto;
        }

        .header {
            min-width: 1250px;
            /*background-color: darkgray;*/
            height: 450px;
            width: 100%;
            /*border-radius:10px;*/
        }

        .header_broadcast {
            height: 70%;
            width: 1250px;
            margin: 0px auto;
            margin-top: 7%;

            /*background-color: chocolate;*/
        }

        .header_navigator {
            /*background-color: aqua;*/
            width: 800px;
            height: 15%;
            margin: 0px auto;
        }

        .main_body {
            min-width: 1250px;
            /*background-color: cadetblue;*/
            /*height: 800px;*/
            width: 100%;
        }
    </style>
    <style>
        .glyphicon-chevron-right:before {
            content: "\e080";
        }

        .icon-back {
            position: absolute;
            top: 17%;
            z-index: 5;
            display: inline-block;
            /*margin-top: -10px;*/
            font-size: 120px;
            margin-left: -90px;
        }
        .icon-more {
            position: absolute;
            top: 17%;
            z-index: 5;
            display: inline-block;
            /*margin-top: -10px;*/
            font-size: 120px;
            margin-right: -90px;
        }
    </style>
</head>

<body class="container-fluid">


<jsp:include page="head.jsp"/>

<div class="header">

    <div class="header_broadcast" >
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/img/c.jpg" alt="First slide">
                    <div class="carousel-caption">标题 1</div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/c.jpg" alt="Second slide">
                    <div class="carousel-caption">标题 2</div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/c.jpg" alt="Third slide">
                    <div class="carousel-caption">标题 3</div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="iconfont icon-back" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="iconfont icon-more" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    </div>
</div>
<div class="main_body container-fluid" >
    <div class="main_body_content container-fluid">
        <!-- 热门订单 -->
        <div class="container-fluid">
            <div class="col-md-12">
                <h2>热门订单&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
            </div>
            <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
                <img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
            </div>
            <div class="col-md-10">
                <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                    <a href="product_info.htm">
                        <img src="products/hao/middle01.jpg" width="400px" height="200px" style="display: inline-block;">
                    </a>
                </div>

                <c:forEach items="${hotOrderList}" var="orderItem">
                    <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                        <a href="product_info.htm">
                            <img src="img/x.JPG" alt="${orderItem.rorderpicsrc}" width="130" height="130" style="display: inline-block;">
                        </a>
                        <p><a href="product_info.html" style='color:#666'>${orderItem.ordertheme}</a></p>
                        <p><font color="#E4393C" style="font-size:16px">${orderItem.ordertime}</font></p>
                    </div>
                </c:forEach>



            </div>
        </div>

        <!-- 广告条 -->
        <div class="container-fluid">
            <img src="products/hao/ad.jpg" width="100%"/>
        </div>

        <!-- 最新订单 -->
        <div class="container-fluid">
            <div class="col-md-12">
                <h2>最新订单&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
            </div>
            <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
                <img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
            </div>
            <div class="col-md-10">
                <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                    <a href="product_info.htm">
                        <img src="products/hao/middle01.jpg" width="400px" height="200px" style="display: inline-block;">
                    </a>
                </div>

                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>
                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>

                <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="product_info.htm">
                        <img src="img/x.JPG" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="foot.jsp"/>

</body>

</html>
