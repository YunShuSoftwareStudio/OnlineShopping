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
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">
        <div class="headr-nav">
            <ul>
                <li><a href="index.jsp">首页</a></li>
                <li><a href=""></a></li>
                <li><a href="${basePath}ProduServlet" style="color: #4AB344"><span
                        style="color: #4AB344">全部产品</span></a></li>
                <li><a href=""></a></li>
                <li><a href="touch.jsp">联系我们</a></li>
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
                <c:forEach items="${cartList}" var="cart" varStatus="i">
                  ${i.count}<a href="${basePath}OrangeServlet?id=${cart.id}">${cart.fruit.name}</a>
                    <a href="${basePath}CartServlet?delid=${cart.id}">删除</a>
                </c:forEach>
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
    <!--产品推荐开始-->
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
                <div class="service">
                    <div class="cltop">
                        <p>在线客服</p>
                    </div>
                    <div class="sercon">
                        <div class="qqs">
                            <p><a hidefocus="true" href="#">
                                <span class="serOnline-img0 qqImg0">&nbsp;</span>蜜桃
                            </a>
                            </p>
                            <P><a hidefocus="true" href="#">
                                <span class="serOnline-img0 qqImg0">&nbsp;</span>芒果
                            </a>
                            </P>
                        </div>
                        <div class="tims">
                            <div class="marBL-10">
                                <span class="worktime-header-img">&nbsp;</span>
                                <span class="serWorkTimeText"><b>工作时间</b></span>
                            </div>
                            <div class="serOnline-list-v "><span>周一至周五 ：8:30-17:30</span></div>
                            <div class="serOnline-list-v lastData"><span>周六至周日 ：9:00-17:00</span></div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="rec-right">
                <div class="bd">
                    <div class="bd1" style="display: block">
                        <c:forEach items="${fruitList}" var="fruit">
                            <div class="rcr">
                                <div class="rcr-top">
                                    <img src="${basePath}images/${fruit.address}" width="100%">
                                </div>
                                <div class="rcr-bot">
                                    <div class="rb-top">
                                            ${fruit.name}
                                    </div>
                                    <div class="second_P">
                                        <span class="fk-prop">￥</span>
                                        <span class="fk-prop-price">${fruit.price}
                                            <span class="fk-prop-p">.00</span>
                                        </span>
                                        <span class="second_Marketprice">￥0.00</span>
                                    </div>
                                    <div class="buy">
                                        <a class="second_mallBuy" href="${basePath}OrangeServlet?id=${fruit.id}">
                                            <span style="color: white;">购买</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--产品推荐结束-->
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
<script src="js/produ.js"></script>
</html>