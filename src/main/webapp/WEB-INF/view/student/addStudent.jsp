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
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" id="stuName" name="stuName" required  lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="0" title="男" checked>
            <input type="radio" name="sex" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生日</label>
        <div class="layui-input-inline">
            <input type="text" id="birthday" required lay-verify="date" placeholder="yyyy-MM-dd" class="layui-input" name="birthday">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出生地</label>
        <div class="layui-input-inline">
            <select name="province" id="province" lay-filter="province">
                <option value="">请选择省</option>
                <c:forEach items="${city1List}" var="city">
                    <option value="${city.id}">${city.cityName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="city" id="city" lay-filter="city">
                <option value="">请选择市</option>
                <c:forEach items="${city2List}" var="city">
                    <option value="${city.id}">${city.cityName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="area" id="area" lay-filter="area">
                <c:forEach items="${city3List}" var="city">
                    <option value="${city.id}">${city.cityName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">婚否</label>
            <div class="layui-input-block">
                <input type="radio" name="marry" value="0" title="未婚" checked>
                <input type="radio" name="marry" value="1" title="已婚">
            </div>
        </div>
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">民族</label>
                <div class="layui-input-inline">
                    <input type="text" id="nation" name="nation" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
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
    <div class="layui-form-item">
        <label class="layui-form-label">班级</label>
        <div class="layui-input-inline">
            <select name="class" id="class">
                <option value="">请选择班级</option>
                <c:forEach items="${classList}" var="class1">
                    <option value="${class1.classId}">${class1.className}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-upload" style="margin-left: 112px">
        <button type="button" class="layui-btn" id="test1">上传照片</button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="demo1">
            <p id="demoText"></p>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入备注" class="layui-textarea"></textarea>
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
            , url: 'https://httpbin.org/post' //改成您自己的上传接口
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        })
        layui.form.on('select(province)', function (data) {
            $.ajax({
                url:"cityList",
                type:"post"
                ,data:{
                    parentId:$("#province").val(),
                    type:2
                },success:function (data) {
                    form.render('select');
                    <%--$('#city').html('<option value="0">请选择市</option>')--%>
                    <%--<c:forEach items="${city2List}" var="city">--%>
                    <%--    $('#city').append(new Option(${city.cityName}, ${city.id}));--%>
                    <%--</c:forEach>--%>
                    <%--form.render('select');--%>
                }
            })
        })
        $("#ok").click(function () {
            $.ajax({
                type: "post",
                url:"addStudents",
                data: {
                    name:$("#name").val(),
                    sex:$("input[name=sex]:checked").val(),
                    birthday:$("#birthday").val(),
                    grade: $("#grade").val(),
                    collegeid: $("#collegeid").val(),
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
