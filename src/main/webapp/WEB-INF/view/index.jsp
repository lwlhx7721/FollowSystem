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
    <div id="container">
        <div id="header">
            <img src="../../static/images/header.png" alt="" style="float: left;margin-left: 20px">
            <ul class="layui-nav layui-bg-green" style="height: 60px;float: right">
                <li class="layui-nav-item">
                    ${sessionScope.user.userName}
                </li>
                <li class="layui-nav-item">
                    <a href="logout">退出</a>
                </li>
            </ul>
        </div>
        <div id="left">
            <ul class="layui-nav layui-nav-tree layui-bg-green" lay-filter="demo" style="margin: 1px;margin-top: 20px" id="leftDemo">
                <li class="layui-nav-item bluebtn" id="li1">
                    <a href="courseList" target="main">课程管理</a>
                </li>
                <li class="layui-nav-item" id="li2">
                    <a href="studentList" target="main">学生管理</a>
                </li>
                <li class="layui-nav-item bluebtn" id="li3">
                    <a href="teacherList" target="main">教师管理</a>
                </li>
                <li class="layui-nav-item bluebtn" id="li4">
                    <a href="userReset" target="main">账号密码重置</a>
                </li>
            </ul>
        </div>
        <div id="right">
            <div id="body">
                <iframe src="studentList" name="main" scrolling="no"></iframe>
            </div>
            <div id="footer">
                @2020&nbsp;&nbsp;金桥教务查询系统&nbsp;&nbsp;
            </div>
        </div>
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
