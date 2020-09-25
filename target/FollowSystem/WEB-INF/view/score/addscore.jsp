<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩添加</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <script src="../../../static/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">学生id</label>
        <div class="layui-input-inline">
            <select name="stuId" id="stuId" lay-verify="required">
                <c:forEach items="${stuList}" var="student">
                    <option value="${student.stuId}">${student.stuName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程id</label>
        <div class="layui-input-inline">
            <select name="courseId" id="courseId" lay-verify="required">
                <c:forEach items="${courseList}" var="course">
                    <option value="${course.courseId}">${course.courseName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">成绩</label>
        <div class="layui-input-inline">
            <input type="text" id="score" name="score" required  lay-verify="required" placeholder="请输入成绩" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" id="ok">确定</button>
            <a class="layui-btn layui-btn-primary" id="close">取消</a>
        </div>
    </div>
</div>
<script>
    //Demo
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form
            ,laydate = layui.laydate
            ,layer = layui.layer
            ,$ = layui.jquery;
        $("#close").click(function () {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        })
        $("#ok").click(function () {
            $.ajax({
                type: "post",
                url:"addScore",
                data: {
                    stuId: $("#stuId").val(),
                    courseId: $("#courseId").val(),
                    score: $("#score").val(),
                },
                dataType: "text",
                success: function (data) {
                    if("true" == data) {
                        layer.msg("新增成功");
                        setTimeout('closeLayer();',1000);
                    } else {
                        layer.msg("新增失败");
                    }
                },
                error:function () {
                    layer.msg("执行失败");
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

