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
<!--弹框-->
<div class="popup" style="display: block">
    <div class="login">
        <div class="lg-cont">
            <div class="lhd">
                <ul>
                    <li class="active">登录</li>
                    <li>注册</li>
                </ul>
                <div class="lhdfoot">
                    <div class="lhdbottom">
                    </div>
                </div>

            </div>
            <div class="lbd">
                <div class="lbd1" style="display: block">
                    <form id="login1" action="${basePath}login" method="post">
                        <div id="memberLoginAcct" class="J_memberLoginItem memberLoginDialogItem">
                            <input name="username" id="memberAcct" class="generateInput memberAcctInput" type="text" value=""
                                   placeholder="账号">
                        </div>
                        <div id="memberLoginPwd" class="J_memberLoginItem memberLoginDialogItem itemSpace">
                            <input name="password" id="memberPwd" class="generateInput memberPwdInput" type="password" placeholder="密码"
                                   }>
                        </div>
                        <div class="loginButton loginButton">
                            <div class="middle" id="login">登陆</div>
                        </div>
                        <div class="bott"></div>
                    </form>
                </div>
                <div class="lbd1">
                    <div class="msv">
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input type="text" placeholder="账号">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem ">
                            <div class="itemMiddle">
                                <input type="password" id="memberSignupPwd" placeholder="密码" maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input type="password" id="memberSignupRepwd" placeholder="确认密码" maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="name" name="姓名" placeholder="姓名" class="userAddItem isCheckUAI" type="text"
                                       maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="email" name="邮箱" placeholder="邮箱" class="userAddItem" type="text"
                                       maxlength="50">
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="phone" name="电话" placeholder="电话" class="userAddItem" type="text"
                                       maxlength="50">
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem_remark">
                            <div class="itemMiddle">
                                <textarea id="memberSignupRemark" placeholder="留言" maxlength="200"></textarea>
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem_captcha">
                            <div class="itemMiddle" style="float:left;width: 150px;">
                                <input id="memberSignupCaptcha" type="text" maxlength="4" placeholder="验证码">
                            </div>
                            <div class="itemRightp">
                                <img alt="" id="memberSignupCaptchaImg" class="memberSignupCaptchaImg"
                                     onclick="Site.changeCaptchaImg(this)" title="看不清，换一张"
                                     src="images/validateCode.jpg">
                            </div>
                        </div>
                    </div>
                    <div class="loginButton loginButton">
                        <div class="middle">注册</div>
                    </div>
                    <div class="bott"></div>
                </div>
            </div>

        </div>
    </div>
</div>
<!--弹框结束-->
</body>
<script src="js/orange.js"></script>
<script>
    $("#login").click(function () {
        document.getElementById("login1").submit();
    });
    $(function () {

    });
</script>
</html>