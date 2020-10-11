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
        <label class="layui-form-label">班级</label>
        <div class="layui-input-inline">
            <select name="classId" id="classId" lay-filter="classId">
                <option value="">--请选择班级--</option>
                <c:forEach items="${classList}" var="class1">
                    <option value="${class1.classId}">${class1.className}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学生姓名</label>
        <div class="layui-input-inline">
            <select name="stu" id="stu" lay-filter="stu">
                    <option value="">--请选择学生--</option>
            </select>
        </div>
    </div>
    <c:forEach items="${courseList}" var="course">
        <div class="layui-form-item">
            <label class="layui-form-label">${course.courseName}</label>
            <div class="layui-input-inline">
                <input type="text"  name="score" placeholder="待录入请输入-1">
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

        form.render('select');
        //一级下拉框
        form.on('select(classId)', function(data) {
            var classId = data.value;
            $.ajax({
                type : "post",
                url : "getStu",
                data : {classId:classId},
                dataType : "json",
                success : function(d) {
                    var tmp = '<option value="">--请选择学生--</option>';
                    //改变时第三级下拉框回复原样
                    $("#stu").html(tmp);
                    for (var i in d) {
                        tmp += '<option value="' + d[i].stuid +  '">' + d[i].stuname + '</option>';
                    }
                    $("#stu").html(tmp);
                    form.render();
                },
                error:function(){
                    layer.alert('请求失败，稍后再试', {icon: 5});
                }
            });
        });
        $("#ok").click(function () {
            $.ajax({
                type: "get",
                url:"addScore",
                data: $("#addScoreForm").serialize(),
                dataType: "text",
                success: function (d) {
                    if("true" == d) {
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
        window.parent.location.reload();
    }
</script>
</body>
</html>

