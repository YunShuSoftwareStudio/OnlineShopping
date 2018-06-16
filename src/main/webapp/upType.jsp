<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
    request.setAttribute("id",request.getParameter("id"));
    request.setAttribute("name",request.getParameter("name"));
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
                        <form action="${basePath}typeServlet" method="post">
                            <input type="hidden" name="id" value="${id}">
                            <table align="center">
                                <thead>
                                <tr>
                                    <td>类别名</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><input type="text" name="name" value="${name}"></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="添加"></td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/produ.js"></script>
</html>