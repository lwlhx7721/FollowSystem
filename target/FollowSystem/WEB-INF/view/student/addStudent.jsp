<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: swz
  Date: 2020/9/23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学员信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <script src="../../../static/layui/layui.js" charset="utf-8"></script>
    <script src="../../../static/js/jquery-3.3.1.js"></script>
</head>
<body>
<form class="layui-form" id="addForm">
    <div class="layui-form-item">
        <div class="layui-upload">
            <div class="layui-upload-list">
                <img class="layui-upload-img" id="demo1" style="width: 90px;margin-left: 650px;position: absolute">
                <p id="demoText"></p>
            </div>
            <a id="test1" style="margin-left: 670px;margin-top:130px;position: absolute">上传照片</a>
        </div>
    </div>
    <div style="float: left">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="stuName" name="stuName" required  lay-verify="required" placeholder="请输入姓名"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="0" title="男" checked>
                <input type="radio" name="sex" value="1" title="女">
            </div>
        </div>
    </div>
    <div style="float: left">
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">民族</label>
                <div class="layui-input-inline">
                    <input type="text" id="nation" name="nation" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">婚否</label>
            <div class="layui-input-block">
                <input type="radio" name="marry" value="0" title="未婚" checked>
                <input type="radio" name="marry" value="1" title="已婚">
            </div>
        </div>
    </div>

    <div style="float: left">
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="telephone" name="telephone" required  lay-verify="required" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input type="text" id="idCard" name="idCard" required  lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </div>
    <div style="float: left">
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">毕业院校</label>
                <div class="layui-input-inline">
                    <input type="text" id="university" name="university" required  lay-verify="required" placeholder="请输入毕业院校" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">专业</label>
                <div class="layui-input-inline">
                    <input type="text" id="major" name="major" required  lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </div>
    <div style="float: left">
        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" id="birthday" required lay-verify="date" placeholder="yyyy-MM-dd" class="layui-input" name="birthday">
            </div>
        </div>
    </div>
    <div style="float: left">
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-inline">
                <select name="classId" id="classId" required>
                    <option value="">请选择班级</option>
                    <c:forEach items="${classList}" var="class1">
                        <option value="${class1.classId}">${class1.className}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出生地</label>
        <div class="layui-input-inline">
            <select name="province" id="province" lay-filter="province" required>
                <option value="">请选择省</option>
                <c:forEach items="${cityList}" var="city">
                    <option value="${city.id}">${city.cityName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="city" id="city" lay-filter="city">
                <option value="">--请选择市--</option>

            </select>
        </div>
        <div class="layui-input-inline">
            <select name="area" id="area" lay-filter="area">
                <option value="">--请选择县--</option>
            </select>
        </div>
    </div>


    <input type="hidden" name="photo" class="image">

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入备注" class="layui-textarea" required id="note" name="note" style="width: 592px"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-left:300px">
            <a class="layui-btn" id="ok">确定</a>
            <a class="layui-btn layui-btn-primary" id="close">取消</a>
        </div>
    </div>
</form>
<script>
    //Demo
    layui.use(['form','laydate','layer','upload'], function(){
        var form = layui.form
            ,laydate = layui.laydate
            ,layer = layui.layer
            ,$ = layui.jquery
            ,upload = layui.upload;
        //执行一个laydate实例
        laydate.render({
            elem: '#birthday',//指定元素
            trigger: 'click'
        });
        $("#close").click(function () {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        })

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '/upload/'
            ,accept:'images'
            ,size:50000
            ,before: function(obj) {
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result);
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                $("#test1").css('display','none')
                var fileupload = $(".image");
                fileupload.attr("value",res.data.src);
                console.log(fileupload.attr("value"));
            }
            ,error: function() {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        form.render('select');
        //一级下拉框
        form.on('select(province)', function(data) {
            var parentId = data.value;
            $.ajax({
                type : "post",
                url : "getCity",
                data : {parentId:parentId},
                dataType : "json",
                success : function(d) {
                    var tmp = '<option value="">--请选择市--</option>';
                    //改变时第三级下拉框回复原样
                    $("#city").html(tmp);
                    for ( var i in d) {
                        tmp += '<option value="' + d[i].id +  '">' + d[i].cityName + '</option>';
                    }
                    $("#city").html(tmp);
                    form.render();
                },
                error:function(){
                    layer.alert('请求失败，稍后再试', {icon: 5});
                }

            });
        });

        //二级联框
        form.on('select(city)',function(data){
            var parentId = data.value;
            $.ajax({
                type : "post",
                url : "getCity",
                data : {parentId:parentId},
                dataType : "json",
                success : function(d) {
                    var tmp = '<option value="">--请选择县--</option>';
                    for ( var i in d) {
                        tmp += '<option value="' + d[i].id +  '">' + d[i].cityName + '</option>';
                    }
                    $("#area").html(tmp);
                    form.render();
                },
                error:function(){
                    layer.alert('请求失败，稍后再试', {icon: 5});
                }
            });
        });

        var nameCheck = function() {
            var name= $("#stuName").val();
            var nameReg =/^[\u4e00-\u9fa5]{2,4}$/;
            if (name.length==0){
                layer.msg("请输入姓名")
                return false;
            }else if (!nameReg.test(name)){
                layer.msg("请输入正确的姓名")
                return false;
            }else {
                return true;
            }
        }
        $("#name").blur(function () {
            nameCheck()
        });
        var phoneCheck = function() {
            var phone= $("#telephone").val();
            var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(18[0-9]{1})|(19[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
            if (phone.length == 0){
                layer.msg("请输入手机号码")
                return false;
            }else if (phone.length != 11){
                layer.msg("请确认手机号码长度无误")
                return false;
            }else if (!myreg.test(phone)){
                layer.msg("请输入有效手机号码")
                return false;
            }else {
                return true;
            }
        }
        $("#phone").blur(function () {
            phoneCheck();
        });
        var idCardCheck = function() {
            var name= $("#idCard").val();
            var nameReg =/(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/;
            if (name.length==0){
                layer.msg("请输入身份证号码")
                return false;
            }else if (!nameReg.test(name)){
                layer.msg("确认输入的身份证是否正确")
                return false;
            }else {
                return true;
            }
        }
        $("#IdCard").blur(function () {
                idCardCheck()
             });
        $("#ok").click(function () {
            if (!nameCheck() || !phoneCheck() || idCardCheck()) {
                return;
            }
            $.ajax({
                type: "post",
                url:"addStudentsForm",
                data:$("#addForm").serialize(),
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
