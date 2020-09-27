<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
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
        <div class="layui-input-inline">
            <select name="roleId" id="roleId" style="width: 200px;" lay-verify="required">
                <option value="0">请选择身份查找</option>
                <c:forEach items="${roleList}" var="role">
                    <option value="${role.roleId}">${role.roleName}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
    </div>
    <table class="layui-hide" id="pwdList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">重置</a>
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
                var roleId = $('#roleId').val();
                //执行重载
                table.reload('pwdList', {
                    url:'getPwdList'
                    ,where: {
                        name: name,
                        roleId: roleId
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
        };
        table.render({
            elem: '#pwdList'//对应table的id属性
            ,url:'getPwdList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'numbers',title: '序号'}
                ,{field:'userId',title:'用户编号',sort:true}
                ,{field:'userName',title: '用户名'}
                ,{field:'pwd',title: '密码'}
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
            ,id: 'pwdList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event == 'udp'){
                layer.open({
                    type:2,
                    content:"updpwd?userId=" + data.userId,
                    title:"重置密码",
                    area:['400px','200px'],//设置弹框的宽高
                }),
                table.reload("pwdList",  {
                    url:"getPwdList"
                })
            }
        });
    });
</script>
</body>
</html>
