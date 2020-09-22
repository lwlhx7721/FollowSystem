<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>金桥学员成长跟踪系统</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"  media="all">
    <script src="../../static/layui/layui.js" charset="utf-8"></script>
    <style>
        *{
            border-radius: 2px;
        }
        html,body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;
            border: 0px;
            overflow-x: hidden;
            background-color: #E7E3E7;
        }
        #container {
            width: 100%;
            height: 620px;
            background-color: white;
            margin: 0;
            border: 0px;
        }
        #header {
            width: 100%;
            height: 60px;
            background-image: linear-gradient(to right, #6495ED , #009688);
        }
        #body {
            width: 100%;
            height: 530px;
            background-color: #393D49;
        }
        #left {
            width: 15%;
            height: 565px;
            background-image: linear-gradient(to bottom, #6495ED,#6495ED, #f0f0f0);
            float: left;
        }
        #right {
            width: 85%;
            height: 560px;
            background-color: #00FF00;
            float: right;
        }
        #footer {
            width: 100%;
            height: 30px;
            background-color: #F0F0F0;
            text-align: center;
            padding-top: 5px;
        }
        .bluebtn {
            background-color: #6495ED;
        }
        iframe {
            width: 99%;
            height: 99%;
            margin: 1px;
            overflow-y: hidden;
        }
    </style>
</head>
<body>
<div>
    <ul class="layui-nav layui-bg-cyan">
        <li class="layui-nav-item"><a href="#"><img src="../../static/images/logo.png" alt="" style="width: 60px"></a></li>
        <li class="layui-nav-item"><a href="#"><span style="font-size: 25px;margin-left: 65px">金桥学员成长追踪系统系统</span></a></li>
        <li class="layui-nav-item" style="float: right"><a href="loginout"><span style="font-size: 16px">退出</span></a></li>
        <li class="layui-nav-item" style="float: right;margin-right: 50px"><a href=""><span style="font-size: 16px">欢迎你 ${sessionScope.user.userName}</span></a></li>
    </ul>
</div>
<div>
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
        <c:forEach var="menu" items="menu">
            <li class="layui-nav-item"><a href="${menu.address}">${menu.menuName}</a></li>
        </c:forEach>
    </ul>
</div>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use(['element','layer'], function(){
            var element = layui.element,
                layer = layui.layer,
                $ = layui.jquery;
            //监听导航点击
            element.on('nav(demo)', function(elem){
                $(this).removeClass("bluebtn");
                $("#li1,#li2,#li3,#li4").addClass("bluebtn");
            });
            $("#resetpwd").click(function () {
                layer.open({
                    type:2,
                    content:"updUser?userid=1&username=admin",
                    title:"编辑指令",
                    area:['800px','500px'],//设置弹框的宽高
                })
            })
        });
    </script>
</body>
</html>
