<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <link rel="stylesheet" href="../../../static/css/list.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center" class="layui-form">
    <div class="demoTable" style="margin-top: 5px;">
        <div class="layui-inline">
            <input class="layui-input" style="width: 200px;" name="name" id="name" placeholder="请输入名字查找" autocomplete="off">
        </div>
        <div class="layui-input-inline" style="color: #757575">
            <select name="deptId" id="deptId" style="width: 200px;margin-left: 5px;color: #757575">
                <option value="0">请选择部门查找</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}">${dept.deptName}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 5px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 30px;" data-type="add">添加</button>
        <button class="layui-btn" style="width: 150px;background-color: red;margin-left: 5px;" data-type="delAll">一键删除</button>
    </div>
    <table class="layui-hide" id="userList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color: #FF0000;" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','layer','form'], function(){
        var table = layui.table
            ,$ = layui.jquery
            ,form = form
            ,layer = layui.layer;
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        var active = {
            reload: function(){
                //获取查询框的值
                var name = $('#name').val();
                var deptId = $('#deptId').val();
                //执行重载
                table.reload('userList', {
                    url:'getUserList'
                    ,where: {
                        name: name,
                        deptId: deptId
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
            add:function() {
                layer.open({
                    type: 2,
                    title: "新增用户",
                    content: "adduser",
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            },
            delAll:function () {
                var checkStatus = table.checkStatus("userList").data;
                if(checkStatus.length == 0) {
                    layer.msg("请选择要删除的数据");
                } else {
                    layer.confirm("确定删除吗？","删除",function () {
                        var userIds = "(";
                        for(var i = 0; i < checkStatus.length; i++) {
                            userIds += checkStatus[i].userId + ",";
                        }
                        userIds = userIds.substr(0,userIds.length - 1);
                        userIds += ")";

                        $.ajax({
                            type:"post",
                            url:"delUsers",
                            data: {
                                userIds:userIds
                            },
                            dataType:"text",
                            success: function (data) {
                                if("true" == data) {
                                    layer.msg("删除成功");
                                } else {
                                    layer.msg("删除失败")
                                }
                                table.reload("userList",function () {
                                    url: 'getUserList'
                                })
                            }
                        })
                    })
                }
            }
        };

        table.render({
            elem: '#userList'//对应table的id属性
            ,url:'getUserList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'checkbox',width:'5%'}
                ,{type:'numbers',title: '序号'}
                ,{field:'userId',title:'ID',sort:true}
                ,{field:'userName',title: '用户名'}
                ,{field:'phone',title: '手机号'}
                ,{field:'email',title: '邮箱'}
                ,{field:'loginTime',title:'上次登录时间'}
                ,{field:'deptName',title:'部门',sort:true}
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
            ,id: 'userList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'udp'){
                layer.open({
                    type:2,
                    content:"upduser?userId=" + data.userId,
                    title:"编辑学生信息",
                    area:['800px','500px'],//设置弹框的宽高
                }),
                table.reload("userList",  {
                    url:"getUserList"
                })
            } else if(obj.event == 'del'){
                //删除消息
                layer.confirm('确定删除吗', '删除指令', function(){
                    $.ajax({
                        url: "delUser",
                        type: "post",
                        data: {
                            userId: data.userId
                        },
                        dataType: "text",
                        success: function(data) {
                            if(data) {
                                layer.msg("删除成功");
                            } else {
                                layer.msg("删除失败");
                            }
                            table.reload("userList",  {
                                url: "getUserList"
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
