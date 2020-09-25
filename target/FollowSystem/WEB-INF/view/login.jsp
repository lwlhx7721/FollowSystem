<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        html,body {
            width: 100%;
            height: 100%;
            margin: 0;
            background-color: #E7E3E7;
        }
        img {
            width: 100%;
            height: 100%;
        }
        #container {
            background-image: url("../../static/images/bg5.jpg");
            width: 100%;
            height: 100%;
            text-align: center;
            position: absolute;
            margin: 0 auto;
        }
        #login {
            width: 400px;
            height: 300px;
            text-align: center;
            position: absolute;
            top: 200px;
            right: 150px;
            padding: 50px 50px 20px 5px;
            background-color: white;
            border-radius: 5%;
        }
        #title {
            width: 800px;
            height: 200px;
            text-align: center;
            position: absolute;
            top: 40px;
            left: 40px;
            background-image: url("../../static/images/title.png");
        }
        .a{
            background-repeat: no-repeat;
            background-size: 100%;
        }
    </style>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="../../static/js/jquery-3.3.1.js"></script>
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-carousel" id="container">
    <div carousel-item>
        <div class="a" style="background-image: url('../../static/images/bg2.jpg')"></div>
        <div class="a" style="background-image: url('../../static/images/bg3.jpg')"></div>
        <div class="a" style="background-image: url('../../static/images/bg4.jpg')"></div>
        <div class="a" style="background-image: url('../../static/images/bg5.jpg')"></div>
    </div>
    <div id="title"></div>
    <div id="login">
        <h1 style="color:#009688;margin: 30px;margin-top: 0px;font-family: 华文隶书">登&nbsp;&nbsp;&nbsp;&nbsp;录</h1>
        <div style="display: flex;justify-content: center">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="text" id="userId" style="width: 250px; margin-left: 50px" name="userId" required  lay-verify="required" placeholder="请输入用户名" value="${cookie.userId.value}" autocomplete="off" class="layui-input t">
                    </div>
                </div>
                <br><br>
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="password" style="width: 250px; margin-left: 50px" required lay-verify="required" placeholder="请输入密码" value="${cookie.pwd.value}" class="layui-input" id="pwd" name="pwd">
                    </div>
                </div>
                <input type="checkbox" name="rememberPwd" value="1" checked>记住密码
                <br>
                <br>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" style="width: 250px; margin-left: -60px" lay-submit lay-filter="formDemo" id="ok">登录</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#container'
            ,width: '100%' //设置容器宽度
            ,height: '100%'
            ,arrow: 'none' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>
<script>
    //Demo
    layui.use(['form','layer'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,$ = layui.jquery;
        $("#ok").click(function () {
            var rememberPwd = $("input[name=rememberPwd]:checked").val() == null ? 0 : 1
            $.ajax({
                type: "post",
                url:"login",
                data: {
                    userId: $("#userId").val(),
                    pwd: $("#pwd").val(),
                    rememberPwd: rememberPwd
                },
                dataType: "text",
                success: function (data) {
                    if("index" == data) {
                        window.location = "index";
                    } else if("userIsNotFound" == data) {
                        layer.msg("用户名不存在");
                    } else if("pwdError" == data){
                        layer.msg("密码错误");
                    } else if("noRole" == data) {
                        layer.msg("您没有权限登录系统，请等待系统管理员赋权");
                    } else if("roleChoose" == data) {
                        layer.open({
                           title:'权限选择'
                            ,type: 2
                            ,area:'300px'
                            ,content: "rolesChoose"
                        })
                    }
                },
                error:function () {
                    layer.msg("执行失败");
                }
            })
        })
    });
</script>
</body>
</html>

