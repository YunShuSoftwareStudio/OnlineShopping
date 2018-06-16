<%@ page import="top.shop.service.impl.FruitTypeServiceImpl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
    request.setAttribute("id",request.getParameter("id"));
    request.setAttribute("name",request.getParameter("name"));
    request.setAttribute("price",request.getParameter("price"));
    request.setAttribute("address",request.getParameter("address"));
    try {
        request.setAttribute("FruitType",FruitTypeServiceImpl.getFruitTypeService().showAllFruitType());
    } catch (SQLException e) {
        e.printStackTrace();
    }
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
                        <form action="${basePath}fruitServlet" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="id" value="${id}">
                            <table align="center">
                                <thead>
                                <tr>
                                    <td>水果名</td>
                                    <td>价格</td>
                                    <td>分类</td>
                                    <td>图片</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><input type="text" name="name" value="${name}"></td>
                                    <td><input type="number" name="price" value="${price}"></td>
                                    <td>
                                        <select name="tid">
                                            <c:forEach var="type" items="${FruitType}">
                                                <option value="${type.id}">${type.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="file" name="address" value="${address}"></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="修改"></td>
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