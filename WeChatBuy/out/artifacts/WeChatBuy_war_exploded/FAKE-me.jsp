<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/5/8
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container" style="padding-top: 6%">

    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <img alt="140x140" src="postedPic${uiconsrc}" width="200px" height="200px" class="img-circle"/>
                <br>
                <br>
                <a class="btn btn-sm btn-lg" href="${pageContext.request.contextPath}/uploadAvatar.jsp?account=${account}">修改头像</a>
                <br>
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>
                        注意!
                    </h4> <strong>个人信息!</strong> 请谨慎修改. <a href="#" class="alert-link">修改
                    link</a>
                </div>
                <table class="table">
                    <tbody>
                    <tr class="info">
                        <td>
                            账户：
                        </td>
                        <td>
                            ${account}
                        </td>
                    </tr>
                    <tr class="info">
                        <td>
                            社区：
                        </td>
                        <td>
                            ${cname}
                        </td>
                    </tr>
                    <tr class="info">
                        <td>
                            id：
                        </td>
                        <td>
                            ${aid}
                        </td>
                    </tr>
                    <tr class="info">
                        <td>
                            身份：
                        </td>
                        <td>
                            ${identity}
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
