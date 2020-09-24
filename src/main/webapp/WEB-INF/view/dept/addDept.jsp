<%--
  Created by IntelliJ IDEA.
  User: 张新云
  Date: 2020/9/23
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加部门页面</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">部门名称</label>
        <div class="layui-input-inline">
            <input type="text" name="deptName" id="deptName" lay-verify="required" placeholder="请输入部门名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">部门地址</label>
            <div class="layui-input-inline">
                <input type="text" name="deptAddress" id="deptAddress" lay-verify="required" autocomplete="off"
                       placeholder="请输入部门地址" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" id="add" class="layui-btn" lay-submit="" lay-filter="demo1">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>
<script>
    layui.use(['layer'], function () {
        var $ = layui.jquery,
            layer = layui.layer;
        $("#add").click(function () {
            $.ajax({
                type: "post",
                url: "toAddDepts",
                data: {
                    deptName: $("#deptName").val(),
                    deptAddress: $("#deptAddress").val()
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
