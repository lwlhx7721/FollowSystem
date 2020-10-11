<%@ page import="com.jxd.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jxd.model.Score" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩添加</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <script src="../../../static/layui/layui.js"></script>
    <script src="../../../static/js/jquery-3.3.1.js"></script>
</head>
<body>
<form class="layui-form" id="addScoreForm">
    <div class="layui-form-item">
        <label class="layui-form-label">学生姓名</label>
        <div class="layui-input-inline">
            <input type="text" value="${student.stuName}" readonly>
        </div>
    </div>
    <input type="hidden" name="stu" value="${student.stuId}">
    <c:forEach items="${courseList}" var="course">
        <div class="layui-form-item">
            <label class="layui-form-label">${course.courseName}</label>
            <div class="layui-input-inline">
                <input type="text"  name="score" placeholder="待录入或不修改请输入-1">
            </div>
        </div>
    </c:forEach>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <a class="layui-btn" id="ok">确定</a>
            <a class="layui-btn layui-btn-primary" id="close">取消</a>
        </div>
    </div>
</form>
<script>
    //Demo
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,$ = layui.jquery;
        $("#close").click(function () {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        })
        $("#ok").click(function () {
            $.ajax({
                type: "get",
                url:"addScore",
                data: $("#addScoreForm").serialize(),
                dataType: "text",
                success: function (data) {
                    if("true" == data) {
                        layer.msg("修改成功");
                        setTimeout('closeLayer();',1000);
                    } else {
                        layer.msg("修改失败");
                        setTimeout('closeLayer();',1000);
                    }
                },
                error:function () {
                    layer.msg("执行失败");
                    //setTimeout('closeLayer();',1000);
                }
            })
        })
    });
    var closeLayer = function () {
        parent.location.reload();
    }
</script>
</body>
</html>

