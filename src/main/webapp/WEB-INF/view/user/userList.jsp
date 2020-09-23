<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <style>
        body {
            background-color: #393D49;
        }
        table tr:nth-child(odd)
        {
            background: #00FFFF;
        }
        table tr:nth-child(even)
        {
            background: #FFB800;
        }
        table th
        {
            background: #01AAED;
        }
    </style>
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center">
    <div class="demoTable" style="margin-top: 5px;">
        <div class="layui-inline">
            <input class="layui-input" style="width: 500px;" name="name" id="name" placeholder="请输入名字查找" autocomplete="off">

        </div>
        <button class="layui-btn" style="width: 200px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 200px;background-color: skyblue;margin-left: 200px;" data-type="add">增加</button>
    </div>
    <table class="layui-hide" id="studentList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color: #FF0000;" lay-event="del">删除</a>
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
                //执行重载
                table.reload('studentList', {
                    url:'getAllStudentList'
                    ,where: {
                        name:name
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
            add:function() {
                layer.open({
                    type: 2,
                    title: "新增学生",
                    content: "addStudent",
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            }
        };

        table.render({
            elem: '#studentList'//对应table的id属性
            ,url:'getAllStudentList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'numbers',title: '序号'}
                ,{field:'id',title:'学号',sort:true}
                ,{field:'name',title: '姓名'}
                ,{field:'sex',title:'性别',templet:function (d) {
                        if(d.sex == 0) {
                            return "女";
                        } else {
                            return "男";
                        }
                    }}
                ,{field:'birthday',title:'出生年月',sort:true}
                ,{field:'grade',title:'入学时间',sort:true}
                ,{field:'collegename',title:'学院',sort:true}
                ,{fixed:'right',title: '操作', align:'center', toolbar: '#barDemo'}
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
            ,id: 'studentList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'udp'){
                layer.open({
                    type:2,
                    content:"updStudent?id=" + data.id,
                    title:"编辑学生信息",
                    area:['800px','500px'],//设置弹框的宽高
                }),
                    table.reload("studentList",  {
                        url:"getAllStudentList"
                    })
            } else if(obj.event == 'del'){
                //删除消息
                layer.confirm('确定删除吗', '删除指令', function(){
                    $.ajax({
                        type: "post",
                        url: "delStudentById",
                        data: {
                            id: data.id
                        },
                        dataType: "text",
                        success: function(data) {
                            if(data) {
                                layer.msg("删除成功");
                            } else {
                                layer.msg("删除失败");
                            }
                            table.reload("studentList",  {
                                url: "getAllStudentList"
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
