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
    <link href="css/orange.css" rel="stylesheet">
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
                <li><a href="index.jsp">首页</a></li>
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
<!--主页内容-->
<div class="content">
    <div class="cont-top">
        <div class="cont-left">
            <div class="ctl-img">
                <img src="${basePath}images/${fruit.address}">
            </div>
        </div>
        <div class="cont-right">
            <div class="J_productTitle title g_minor">
                <span>${fruit.name}</span>
            </div>
            <div class="pic">
                <span class="ppi">价格:</span>
                <span class="f-mallUnit">￥</span>
                <span class="pcc">${fruit.price}</span>
            </div>
            <div class="fk-pd5MallCartCount">
                <div class="f-cartbuyCountWrap">
                    <span class="f-propName g_minor" style="width:75px;min-width:75px;max-width: 75px;">购买数量：</span>
                    <input type="text" value="1" class="g_itext cartBuyCount f-cartBuyCount">
                </div>
                <div class="f-buyCountBtn">
                    <div class="f-countBtn mallJian"></div>
                    <div class="f-countBtn disableMallJian"></div>
                </div>
            </div>
            <div class="fk-pd5MallActBtns">
                <div class="buttn">
                    <a href="${basePath}CartServlet?id=${fruit.id}&num=1">加入购物车</a>
                </div>
                <div class="aa buttn butto">
                    立即购买
                </div>
            </div>
        </div>
    </div>
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
<!--底部结束-->
</body>
<script src="js/orange.js"></script>
<script>

    $(function () {
        $("#login").click(function () {
            document.getElementById("login1").submit();
        });
        $('.aa').click(function () {
            alert("购买成功");
            window.location.href="${basePath}"
        })
    });
</script>
</html>