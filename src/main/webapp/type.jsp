<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>全部产品</title>
    <link href="css/produ.css" rel="stylesheet">
    <link href="css/share.css" rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
</head>
<body>
<div class="content">
    <!--产品推荐开始-->
    <div class="recommand clear">
        <div class="rec-cont clear">
            <div class="rec-left">
                <div class="classily">
                    <div class="cltop">
                        <p>管理功能</p>
                    </div>
                    <div class="cltcon">
                        <p><a href="${basePath}typeServlet">类别管理</a></p>
                        <p><a href="${basePath}fruitServlet">商品管理</a></p>
                        <p><a href="${basePath}userServlet">用户管理</a></p>
                    </div>
                </div>
            </div>
            <div class="rec-right">
                <div class="bd">
                    <div class="bd1" style="display: block">
                        <table border="1" align="center">
                            <thead>
                            <tr>
                                <td>类别名</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${fruitType}" var="type">
                                <tr>
                                    <td>${type.name}</td>
                                    <td>
                                        <a href="${basePath}typeServlet?delid=${type.id}">删除</a>
                                        <a href="${basePath}upType.jsp?id=${type.id}&name=${type.name}">修改</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <a href="${basePath}addType.jsp">添加类别</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/produ.js"></script>
</html>