<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <script src="../../../static/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item" style="display: none">
        <label class="layui-form-label" ></label>
        <div class="layui-input-inline">
            <input type="text" id="userName" name="userName" required value="${user.userId}" lay-verify="required|pwd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="display: none">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" id="pwd" name="pwd" required value="${user.pwd}" lay-verify="required|pwd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">旧密码</label>
        <div class="layui-input-inline">
            <input type="password" id="oldPwd" name="oldPwd" required value="" lay-verify="required|pwd" autocomplete="off" class="layui-input">
            <div id="oldPwdTest"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" id="newPwd" name="newPwd" required value="" lay-verify="required|pwd" autocomplete="off" class="layui-input">
            <div id="newPwdTest"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">重新输入新密码</label>
        <div class="layui-input-inline">
            <input type="password" id="rePwd" name="rePwd" required value="" lay-verify="required|pwd" autocomplete="off" class="layui-input">
            <div id="rePwdTest"></div>
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
        $("#oldPwd").blur(function () {
            var pwd = $("#pwd").val(),
                olePwd = $("#oldPwd").val();
            if(pwd=="") {
                $("#oldPwdTest").text("请输入旧密码");
                return false;
            }else if (!(pwd == olePwd)){
                $("#oldPwdTest").text("旧密码输入错误");
                return false;
            } else {
                $("#oldPwdTest").text("");
            }
        });
        $("#newPwd").blur(function () {
            if($("#newPwd").val()==""){
                $("#newPwdTest").text("密码不能为空");
                return false;
            }else {
                $("#newPwdTest").text("");
            }
        });
        $("#rePwd").blur(function () {
            var newPwd = $("#newPwd").val(),
                rePwd = $("#rePwd").val();
            if (newPwd!=rePwd){
                $("#rePwdTest").text("两次输入密码不一致");
                return false;
            }else {
                $("#rePwdTest").text("");
                return true;
            }
        });
        $("#ok").click(function () {
            $.ajax({
                type: "post",
                url:"editPwd",
                data: {
                    userId: ${user.userId},
                    pwd: $("#newPwd").val(),
                },
                dataType: "text",
                success: function (data) {
                    if("true" == data) {
                        layer.msg("修改成功");
                        setTimeout('closeLayer();',1000);
                    } else {
                        layer.msg("修改失败");
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


