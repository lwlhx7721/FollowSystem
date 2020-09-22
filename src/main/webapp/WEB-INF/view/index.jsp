<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>金桥学员成长跟踪系统</title>
    <link rel="stylesheet" href="../../static/css/index.css">
    <link rel="stylesheet" href="../../static/layui/css/layui.css"  media="all">
    <script src="../../static/layui/layui.js" charset="utf-8"></script>
    <script src="../../static/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            if (${menus.size() != 0}) {
                $("#d1").css({'background-color': '#393D49','height':'600px','width':'200px'})
            } else {
                $("#d1").css('display','none')
            }

            $("#btn1").click(function () {
                $("#d1").animate({width:'toggle'},200);
            })
        })
    </script>
</head>
<body>
<div>
    <ul class="layui-nav layui-bg-cyan">
        <li class="layui-nav-item"><a href="#"><img src="../../static/images/logo.png" alt="" style="width: 60px"></a></li>
        <li class="layui-nav-item"><a href="#"><span style="font-size: 25px;margin-left: 65px">金桥学员成长追踪系统系统</span></a></li>
        <li class="layui-nav-item" style="float: right"><a href="logout"><span style="font-size: 16px">退出</span></a></li>
        <li class="layui-nav-item" style="float: right;margin-right: 50px"><a href=""><span style="font-size: 16px">欢迎你 ${sessionScope.user.userName}</span></a></li>
    </ul>
</div>
<input type="button" value="《" id="btn1" style="margin-left: 200px">
<div id="d1" style="float: left">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
        <c:forEach var="menu" items="${menus}" >
            <li class="layui-nav-item"><a href="${menu.address}">${menu.menuName}</a></li>
        </c:forEach>
    </ul>
</div>
<div style="float: left;background-color: red;width: 1100px;height: 700px">
    我是工具栏
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
