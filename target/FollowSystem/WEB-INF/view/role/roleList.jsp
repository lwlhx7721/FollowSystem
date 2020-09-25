<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户权限管理</title>
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
            <input class="layui-input" style="width: 200px;" name="name" id="name" placeholder="请输入名字查找" autocomplete="off">
        </div>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
    </div>
    <table class="layui-hide" id="roleList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="add">授予权限</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">收回权限</a>
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
                table.reload('roleList', {
                    url:'getRoleList'
                    ,where: {
                        name: name
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
        };

        table.render({
            elem: '#roleList'//对应table的id属性
            ,url:'getRoleList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'checkbox',width:'10%'}
                ,{type:'numbers',title: '序号'}
                ,{field:'userId',title:'用户号',sort:true}
                ,{field:'userName',title: '用户名'}
                ,{field:'roleName',title: '已有权限'}
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
            ,id: 'roleList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'add'){
                layer.open({
                    type:2,
                    content:"addrole?userId=" + data.userId,
                    title:"授予用户权限",
                    area:['800px','500px'],//设置弹框的宽高
                }),
                    table.reload("roleList",  {
                        url:"getRoleList"
                    })
            } else if(obj.event == 'del'){
                //删除消息
                layer.confirm('确定收回权限吗', '确定指令', function(){
                    $.ajax({
                        url: "delRole",
                        type: "post",
                        data: {
                            userId: data.userId
                        },
                        dataType: "text",
                        success: function(data) {
                            if(data) {
                                layer.msg("权限已收回");
                            } else {
                                layer.msg("用户未拥有该权限");
                            }
                            table.reload("roleList",  {
                                url: "getRoleList"
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
