<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩管理</title>
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
            <input class="layui-input" style="width: 200px;" name="name" id="name" placeholder="请输入学生姓名查找" autocomplete="off">
        </div>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 30px;" data-type="add">添加</button>
        <button class="layui-btn" style="width: 200px;background-color: red;margin-left: 30px;" data-type="delAll">一键删除</button>
    </div>
    <table class="layui-hide" id="scoreList"  lay-filter="demo" lay-skin="nob"></table>
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
                table.reload('scoreList', {
                    url:'getScoreList'
                    ,where: {
                        name: name,
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
                {type:'checkbox',width:'10%'}
                ,{type:'numbers',title: '序号'}
                ,{field:'stuid',title:'学号',sort:true}
                ,{field:'stuname',title: '姓名'}
                ,{field:'coursename',title: '课程名'}
                ,{field:'score',title: '成绩'}
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
            ,id: 'scoreList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'udp'){
                var checkStatus = table.checkStatus("scoreList").data;
                if (checkStatus.length != 1) {
                    layer.msg("请选择一条要修改的数据");
                    return;
                }else {
                    layer.open({
                        type: 2,
                        content: "updscore?stuId=" + data.stuId,
                        title: "编辑学生成绩",
                        area: ['800px', '500px'],//设置弹框的宽高
                    }), table.reload("scoreList", {
                        url: "getScoreList"
                    })
                }
            } else if(obj.event == 'del'){
                //删除消息
                var checkStatus = table.checkStatus("scoreList").data;
                if (checkStatus.length == 0) {
                    layer.msg("请选择要删除的数据");
                    return;
                }else{
                    layer.confirm('确定删除吗', '删除指令', function(){
                        $.ajax({
                            type: "post",
                            url: "delScore",
                            data: {
                                stuId:data.stuId,
                                courseId:data.courseId
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
            }
        });
    });
</script>
</body>
</html>