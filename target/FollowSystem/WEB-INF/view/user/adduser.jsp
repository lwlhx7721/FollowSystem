<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <script src="../../../static/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" id="name" name="name" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <div id="nameTest"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
            <input type="text" id="phone" name="phone" required  lay-verify="required|phone" placeholder="1XX XXXX XXXX" autocomplete="off" class="layui-input">
            <div id="phoneTest"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" id="email" name="email" required  lay-verify="required|email" autocomplete="off" class="layui-input">
            <div id="emailTest"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline">
            <select name="deptId" id="deptId" lay-verify="required">
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}">${dept.deptName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="desc" id="note" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="button" class="layui-btn" id="ok" value="确定">
            <a class="layui-btn layui-btn-primary" id="close">取消</a>
        </div>
    </div>
</form>
<script>
    //Demo
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form
            ,laydate = layui.laydate
            ,layer = layui.layer
            ,$ = layui.jquery;
        $("#name").blur(function () {
            var name= $("#name").val();
            var nameReg =/^[\u4e00-\u9fa5]{2,4}$/;
            if (name.length==0){
                $("#nameTest").text("请输入姓名")
                return false;
            }else if (!nameReg.test(name)){
                $("#nameTest").text("请输入正确的姓名")
                return false;
            }else {
                $("#nameTest").text("")
                return true;
            }
        });
        $("#phone").blur(function () {
            var phone= $("#phone").val();
            var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(18[0-9]{1})|(19[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
            if (phone.length == 0){
                $("#phoneTest").text("请输入手机号码")
                return false;
            }else if (phone.length != 11){
                $("#phoneTest").text("请确认手机号码长度无误")
                return false;
            }else if (!myreg.test(phone)){
                $("#phoneTest").text("请输入有效手机号码")
                return false;
            }else {
                $("#phoneTest").text("")
                return true;
            }
        });
        $("#email").blur(function () {
            var email= $("#email").val();
            var reg = RegExp("([\\w-.])+@([\\w-])+((\.[\\w-]{2,3}){1,2})", "g");
            if (email.length == 0){
                $("#emailTest").text("请输入邮箱")
                return false;
            }else if (!reg.test(email)){
                $("#emailTest").text("请输入正确的邮箱")
                return false;
            }else {
                $("#emailTest").text("");
                return true;
            }
        });

        $("#close").click(function () {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });
        $("#ok").click(function () {
            $.ajax({
                type: "post",
                url:"addUser",
                async: false,
                data: {
                    userName: $("#name").val(),
                    phone: $("#phone").val(),
                    email: $("#email").val(),
                    deptId: $("#deptId").val(),
                    note: $("#note").val(),
                    pwd: "123"
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
        });
    });
    var closeLayer = function () {
        parent.location.reload();
    }
</script>
</body>
</html>

