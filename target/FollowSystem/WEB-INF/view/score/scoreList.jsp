<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <link rel="stylesheet" href="../../../static/css/list.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center" class="layui-form">
    <div class="demoTable" style="margin-top: 5px;">
        <div class="layui-inline">
            <input class="layui-input" style="width: 200px;" name="name" id="name" placeholder="请输入学生姓名查找" autocomplete="off">
        </div>
        <div class="layui-input-inline">
            <select name="classId" id="classId" lay-verify="required">
                <option value="0">请选择班级查找</option>
                <c:forEach items="${classList}" var="class1">
                    <option value="${class1.classId}">${class1.className}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 30px;" data-type="add">添加</button>
    </div>
    <table class="layui-hide" id="scoreList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color: #FF0000;" lay-event="del">清空</a>
</script>
<script>
    layui.use(['table','layer'], function(){
        var table = layui.table
            ,$ = layui.jquery
            ,layer = layui.layer;
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        var active = {
            reload: function(){
                //获取查询框的值
                var name = $('#name').val();
                var classId = $("#classId").val();
                //执行重载
                table.reload('scoreList', {
                    url:'getScoreList'
                    ,where: {
                        name: name,
                        classId:classId,
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
            add:function() {
                layer.open({
                    type: 2,
                    title: "新增成绩",
                    content:'addscore',
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            }
        };

        table.render({
            elem: '#scoreList'//对应table的id属性
            ,url:'getScoreList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'numbers',title: '序号'}
                ,{field:'stuId',title:'学号',sort:true,width:'7%'}
                ,{field:'stuName',title: '姓名',width:'8%'}
                ,{field:'className',title: '班级名',width:'13%'}
                <c:forEach items="${courseList}" var="course">
                    ,{field:'${course.courseName}',title: '${course.courseName}'}
                </c:forEach>
                ,{fixed:'right',title: '操作', align:'center', toolbar: '#barDemo',width:'10%'}
            ]]
            ,page: true
            ,limit:10
            ,limits:[10,20,40,50]
            ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": 0, //解析接口状态
                    "msg": '', //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.list //解析数据列表
                };
            }
            ,id: 'scoreList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'udp') {
                layer.open({
                    type: 2,
                    content: "updscore?stuId=" + data.stuId,
                    title: "编辑学生成绩",
                    area: ['800px', '500px'],//设置弹框的宽高
                }), table.reload("scoreList", {
                    url: "getScoreList"
                })
            } else if(obj.event == 'del'){
                //删除消息
                layer.confirm('确定清空该学生的成绩吗', '删除指令', function(){
                    $.ajax({
                        type: "post",
                        url: "delScore",
                        data: {
                            stuId:data.stuId,
                        },
                        dataType: "text",
                        success: function(data) {
                            layer.msg(data);
                            table.reload("scoreList",  {
                                url: "getScoreList"
                            })
                        },
                        error: function (data) {
                            layer.msg("执行失败");
                        }
                    })
                })

            }
        });
    });
</script>
</body>
</html>
