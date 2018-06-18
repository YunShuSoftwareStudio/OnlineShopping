<%@ page import="top.shop.service.impl.FruitTypeServiceImpl" %>
<%@ page import="top.shop.entity.FruitType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
    List<FruitType> fruitTypes = null;
    try {
        fruitTypes = FruitTypeServiceImpl.getFruitTypeService().showAllFruitType();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    request.setAttribute("fruitTypeList", fruitTypes);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>最新资讯</title>
    <link href="css/touch.css" rel="stylesheet">
    <link href="css/share.css" rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
</head>
<body>
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">
        <div class="headr-nav">
            <ul>
                <li><a href="index.jsp">首页</a></li>
                <li><a href=""></a></li>
                <li><a href="${basePath}ProduServlet">全部产品</a></li>
                <li><a href=""></a></li>
                <li><a href="touch.jsp" style="color: #4AB344"><span style="color: #4AB344">联系我们</span></a></li>
            </ul>
            <div class="sptopfoot">
                <div class="spbottom">
                </div>
            </div>
        </div>
        <div class="headr-right">
            <i class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i>
            我的购物车 ∨
            <div class="hr-car">
                <i class="iconfont" style="font-size: 40px;margin-right: 10px">&#xe633;</i>
                您的购物车内暂时没有任何产品。
            </div>
        </div>
    </div>
</div>
<!--顶部导航结束-->
<!--banner图片-->
<div class="her-banner">

</div>
<!--banner图片结束-->
<div class="content">
    <!--建议开始-->
    <div class="recommand clear">
        <div class="rec-cont clear">
            <div class="rec-left">
                <div class="classily">
                    <div class="cltop">
                        <p>产品分类</p>
                    </div>
                    <div class="cltcon">
                        <p><a href="${basePath}ProduServlet">全部</a></p>
                        <c:forEach items="${fruitTypeList}" var="fruitType">
                            <p><a href="${basePath}ProduServlet?typeId=${fruitType.id}">${fruitType.name}</a></p>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="rec-right">
                <div class="rec-top">
                    <div class="rt-left">
                        <img src="images/tou-1.png">
                    </div>
                    <div class="rt-right">
                        <span style="line-height: 32px;">
                            <span style=""><div style="">
                                <span style="color: rgb(51, 51, 51); font-size: 18px; background-color: transparent;">
                                    向越来越多的人提供最好吃的水果
                                </span><br style=""></div><div style=""><span style="">
                                <p style="color: rgb(0, 0, 0); font-family: 宋体; font-size: 12px;">
                                    <span style="font-size: 14px; font-family: 微软雅黑; color: rgb(51, 51, 51);">
                                        FRESH蔬果（集团）有限公司以蔬果、水果、粮油、肉类、冻品、水产、南北干货以及花卉等农产品批发市场经营管理、生鲜配送为主力业态。
                                    </span></p>
                                <p style="color: rgb(0, 0, 0); font-family: 宋体; font-size: 12px;"><span
                                        style="font-size: 14px; font-family: 微软雅黑; color: rgb(51, 51, 51);">
                                    用毕生精力致力于水果产业链和水果专营连锁业态的发展，为消费者提供最好吃的水果。开拓创新立宏愿，决心“一生只做一件事，一心一意做水果”。
                                </span></p></span><p style="color: rgb(0, 0, 0); font-family: 宋体; font-size: 12px;"></p></div></span><div
                                style="">
                            <p style="color: rgb(0, 0, 0); font-family: 宋体; font-size: 12px;"></p></div></span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--建议结束-->
</div>
<!--底部-->
<div class="footer">
    <div class="ft-con">
        <div class="ft-top">
            <img src="images/fot-1.jpg">
        </div>
        <div class="ft-bo">
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>正品保证</p>
                <p>7天无理由退换</p>
                <p>退货返运费</p>
                <p>7X15小时客户服务</p>

            </div>
            <div class="ft-b">
                <h3>支付方式</h3>
                <p>公司转账</p>
                <p>货到付款</p>
                <p>在线支付</p>
                <p>分期付款</p>

            </div>
            <div class="ft-b">
                <h3>商家服务</h3>
                <p>商家入驻</p>
                <p>培训中心</p>
                <p>广告服务</p>
                <p>服务市场</p>

            </div>
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>免运费</p>
                <p>海外配送</p>
                <p>EMS</p>
                <p>211限时达</p>

            </div>

        </div>
        <div class="banq">
            <p>©2018 果然新鲜</p>
            <p><a href="${basePath}fruitServlet">管理登录</a></p>
        </div>

    </div>
</div>
</body>
<script src="js/touch.js"></script>
</html>