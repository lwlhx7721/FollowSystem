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
            $("#btn1").click(function () {
                $("#left").animate({width:'toggle'},200);
            })
        })
    </script>
</head>
<body>
    <div id="container">
        <div id="header">
            <a href="#"><img src="../../static/images/header.png" alt=""></a>
            <ul class="layui-nav layui-bg-cyan" style="height: 60px;float: right">
                <li class="layui-nav-item">
                    <a href="javascript:">${sessionScope.loginUser.userName}</a>
                    <dl class="layui-nav-child" style="background-color: #009688">
                        <dd><a id="resetpwd">修改密码</a></dd>
                        <dd><a href="logout">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">&nbsp;&nbsp;</li>
            </ul>
        </div>
        <c:if test="${menus.size() != 0}">
            <div id="left">
                <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin: 5px;">
                    <c:forEach var="menu" items="${menus}" >
                        <li class="layui-nav-item"><a href="${menu.address}" target="main">${menu.menuName}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <div id="right">
            <div id="body">
                <%--<div style="background-color: red">
                    <c:if test="${menus.size() != 0}">
                        <input type="button" value="《" id="btn1">
                    </c:if>
                    我是工具栏
                </div>--%>
                <iframe src="deptList" frameborder="0"  name="main" scrolling="no"></iframe>
            </div>
            <div id="footer">@2020&nbsp;&nbsp;金桥&nbsp;&nbsp;&nbsp;&nbsp;学员成长跟踪系统</div>
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

            });
            $("#resetpwd").click(function () {

            })
        });
    </script>
</body>
</html>
