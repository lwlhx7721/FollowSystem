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

</form>
<script>
    //Demo
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form
            ,laydate = layui.laydate
            ,layer = layui.layer
            ,$ = layui.jquery;
        //姓名验证：只能输入2-10位汉字（少数名族名字可能比较复杂）
        // $("#name").blur(function () {
        //     var name= $("#name").val();
        //     var nameReg =/^[\u4e00-\u9fa5]{2,10}$/;
        //     if (name.length==0){
        //         $("#nameTest").text("请输入姓名")
        //         return false;
        //     }else if (!nameReg.test(name)){
        //         $("#nameTest").text("请输入正确的姓名")
        //         return false;
        //     }else {
        //         $("#nameTest").text("")
        //         return true;
        //     }
        // });
        //课程验证：只能输入中英文及数字
        // $("#name").blur(function () {
        //     var name= $("#name").val();
        //     var nameReg =/^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
        //     if (name.length==0){
        //         $("#nameTest").text("请输入课程名")
        //         return false;
        //     }else if (!nameReg.test(name)){
        //         $("#nameTest").text("课程名中只能带有数字、英文、中文")
        //         return false;
        //     }else {
        //         $("#nameTest").text("")
        //         return true;
        //     }
        // });
        //身份证验证：只能输入15或18位身份证
        // $("#name").blur(function () {
        //     var name= $("#name").val();
        //     var nameReg =/(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/;
        //     if (name.length==0){
        //         $("#nameTest").text("请输入身份证号码")
        //         return false;
        //     }else if (!nameReg.test(name)){
        //         $("#nameTest").text("确认输入的身份证是否正确")
        //         return false;
        //     }else {
        //         $("#nameTest").text("")
        //         return true;
        //     }
        // });
        //成绩验证
        $("#name").blur(function () {
            var score= $("#name").val();
            var reg = new RegExp("^(\\d|[1-9]\\d|100)$");
            if (score.length==0){
                $("#nameTest").text("请输入成绩")
                return false;
            }else if (!reg.test(score)){
                $("#nameTest").text("确认输入的成绩是否正确")
                return false;
            }else {
                $("#nameTest").text("")
                return true;
            }
        });
        //手机验证：只能输入11位手机号
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
        //邮箱验证
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
</script>
</body>
</html>

