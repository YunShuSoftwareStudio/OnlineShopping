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
    <title>果然新鲜</title>
    <link href="css/index.css" rel="stylesheet">
    <link href="css/share.css" rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
</head>
<body>
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">

        <div class="headr-nav">
            <ul>
                <li><a href="index.jsp" style="color: #4AB344"><span style="color: #4AB344">首页</span></a></li>
                <li><a href=""></a></li>
                <li><a href="${basePath}ProduServlet">全部产品</a></li>
                <li><a href=""></a></li>
                <li><a href="touch.jsp">联系我们</a></li>
            </ul>
            <div class="sptopfoot">
                <div class="spbottom">
                </div>
            </div>
        </div>
    </div>
</div>
<!--顶部导航结束-->
<!--banner图片-->
<div class="her-banner">

</div>
<!--banner图片结束-->
<!--主页内容-->
<div class="content">
    <div class="ban-boot clear">
        <div class="ban-zs">
            <img src="images/ban-1.jpg" width="100%">
        </div>
        <div class="ban-zs">
            <img src="images/ban-2.jpg" width="100%">
        </div>
        <div class="ban-zs">
            <img src="images/ban-3.jpg" width="100%">
        </div>
    </div>
</div>
<!--每日新品特卖-->
<div class="rec-bottom clear">
    <div class="rbt-con">
        <div class="banner_1">
            <img src="images/rb-1.jpg" width="1424px">
            <img src="images/rb-2.jpg" width="1424px">
        </div>
    </div>
    <ul class="banner-bottom">

    </ul>
</div>
<div class="content">
    <div class="new-nav clear">
        <div class="nwn-con">
            <div style="text-align: center;">
                <span style="">
                    <span style="font-size: 31px;">
                        <font style="color: rgb(33, 33, 33);" color="#212121">
                        <font style="color: rgb(231, 231, 231);" color="#e7e7e7">
                            ———————
                        </font>
                            <b>&nbsp; 每日新品特卖 &nbsp;</b>
                        </font></span></span>
                <span style="font-size: 31px;">
                <font style="color: rgb(231, 231, 231);" color="#e7e7e7">
                    ———————
                </font>
            </span>
            </div>
            <div style="text-align: center;">
                <font color="#353535" style="">
                    <span style="font-size: 16px;">
                            <font style=color:#888888>
                                新鲜水果每一天，健康生活每一刻
                            </font>
                    </span>
                </font></div>

        </div>


    </div>
    <div class="new-bottom clear">
        <div class="nw-b">
            <img src="images/nw-2.jpg">
        </div>
        <div class="nw-b">
            <img src="images/nw-3.jpg">
        </div>
        <div class="nw-b">
            <img src="images/nw-4.jpg">
        </div>
        <div class="nw-b" style="margin:0">5
            <img src="images/nw-5.jpg">
        </div>
    </div>
    <!--每日新品特卖结束-->
    <!--蔬果资讯-->
    <div class="fruits">
        <div class="fru-nav">
            <div class="fk-editorb ">
                <font style="color: rgb(103, 141, 30);" color="#678d1e">蔬果资讯</font>
            </div>
            <font style="color: rgb(53, 53, 53);float: right" color="#353535">更多资讯</font>
        </div>
        <div class="fru-lift">
            <div class="frl-nav">
                <ul>
                    <li>品种</li>
                    <li>地区</li>
                    <li>价格</li>
                    <span>时间</span>
                </ul>
            </div>
            <div class="txtMarquee-top">
                <div class="bd">
                    <ul class="infoList">

                        <li><p>苹果</p>
                            <p>河南省济源市</p>
                            <p>5.5/kg</p>
                            04-09
                        </li>
                        <li><p> 西瓜</p>
                            <p> 内蒙古鄂尔多斯</p>
                            <p>10/kg</p>
                            04-09
                        </li>
                        <li><p>葡萄</p>
                            <p>新疆乌鲁木齐</p>
                            <p>19/kg</p>
                            04-09
                        </li>
                        <li><p>车厘子</p>
                            <p>河南省郑州市</p>
                            <p> 58.5/kg</p> 04-09
                        </li>
                        <li><p>菜心 </p>
                            <p>河南省新乡市</p>
                            <p> 5.5/kg</p> 04-09
                        </li>
                        <li><p>西兰花</p>
                            <p>河南省信阳市</p>
                            <p> 3.5/kg</p> 04-09
                        </li>
                        <li><p>苹果 </p>
                            <p>河南省济源市</p>
                            <p> 5.5/kg </p>04-09
                        </li>
                        <li><p>西瓜 </p>
                            <p>内蒙古鄂尔多斯</p>
                            <p>10/kg</p> 04-09
                        </li>
                        <li><p>葡萄 </p>
                            <p>新疆乌鲁木齐 </p>
                            <p>19/kg</p> 04-09
                        </li>
                        <li><p>菜心 </p>
                            <p>河南省新乡市</p>
                            <p> 5.5/kg </p>04-09
                        </li>
                        <li><p>西兰花</p>
                            <p> 河南省信阳市</p>
                            <p> 3.5/kg </p>04-09
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="fru-right">
            <div id="slideBox" class="slideBox">
                <div class="hd">
                    <!--<ul><li>蜜橘首发</li>-->
                    <!--<li>智利车厘子</li>-->
                    <!--<li>进口青苹果</li>-->
                    <!--</ul>-->
                    <ul>
                        <li>1</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                </div>
                <div class="bd">
                    <ul>
                        <li><a href="#" target="_blank"><img src="images/fr-1.jpg"/></a></li>
                        <li><a href="#" target="_blank"><img src="images/fr-2.jpg"/></a></li>
                        <li><a href="#" target="_blank"><img src="images/fr-3.jpg"/></a></li>
                    </ul>
                </div>

            </div>

        </div>
    </div>
    <!--蔬果资讯结束-->
</div>
<!--主页内容结束-->
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
<script src="js/index.js"></script>
</html>