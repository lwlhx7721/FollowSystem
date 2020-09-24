<%--
  Created by IntelliJ IDEA.
  User: 张新云
  Date: 2020/9/24
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加评价分项页</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">评价分项ID</label>
        <div class="layui-input-inline">
            <input type="text" name="optionId" id="optionId" lay-verify="title" autocomplete="off"
                   placeholder="请输入评价分项ID"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评价分项名称</label>
        <div class="layui-input-inline">
            <input type="text" name="optionName" id="optionName" lay-verify="required" placeholder="请输入评价分项名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">评价分项标志</label>
            <div class="layui-input-inline">
                <input type="text" name="optionState" id="optionState" lay-verify="required" autocomplete="off"
                       placeholder="请输入评价分项标志0或者1" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <button type="submit" id="add" class="layui-btn" lay-submit="" lay-filter="demo1">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>
<script>
    layui.use(['$','layer'], function () {
        var $ = layui.jquery,
            layer = layui.layer;
        $("#add").click(function () {
            $.ajax({
                type: "post",
                url: "toAddJobEvaluateOption",
                data: {
                    optionId: $("#optionId").val(),
                    optionName: $("#optionName").val(),
                    optionState: $("#optionState").val()
                },
                dataType: "text",
                success: function (data) {
                    if ("true" == data) {
                        layer.msg("新增成功");
                    } else {
                        layer.msg("新增失败");
                    }
                },
                error: function () {
                    alert("执行失败")
                }
            })
        })

    });

</script>
</body>
</html>