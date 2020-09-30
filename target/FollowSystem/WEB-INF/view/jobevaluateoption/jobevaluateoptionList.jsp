<%--
  Created by IntelliJ IDEA.
  User: 张新云
  Date: 2020/9/24
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价分项页面</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <link rel="stylesheet" href="../../../static/css/list.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center" class="layui-form">
    <div class="demoTable" style="margin-top: 5px;">
        <div class="layui-inline">
            <input class="layui-input" style="width: 200px;" name="optionName" id="optionName" placeholder="请输入评价分项名称" autocomplete="off">
        </div>
       <%-- <div class="layui-input-inline">
            <select name="deptId" id="deptId" style="width: 200px;" lay-verify="required">
                <option value="0">请选择部门查找</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}">${dept.deptName}</option>
                </c:forEach>
            </select>
        </div>--%>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 30px;" data-type="add">添加</button>
    </div>
    <table class="layui-hide" id="jobevaluateoptionList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color: green;" lay-event="update">启用/停用</a>
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
                var optionName = $('#optionName').val();
                //var deptId = $('#deptId').val();
                //执行重载
                table.reload('jobevaluateoptionList', {
                    url:'getJobEvaluateOptionList'
                    ,where: {
                        optionName: optionName
                        //deptId: deptId
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
            add:function() {
                layer.open({
                    type: 2,
                    title: "新增评价分项",
                    content: "addJobEvaluateOptions",
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            }
        };

        table.render({
            elem: '#jobevaluateoptionList'//对应table的id属性
            ,url:'getJobEvaluateOptionList'
            ,width: 1150
            ,height: 480
            ,cols: [[
                {type:'numbers',title: '序号'}
                ,{field:'optionId',title:'评分项ID',sort:true}
                ,{field:'optionName',title: '评分项名'}
                ,{field:'optionState',title: '评分项状态',templet:function (d){
                        if(d.optionState == 1) {
                            return "在用";
                        } else {
                            return "未用";
                        }
                    }
                }
                ,{fixed:'right',title: '操作', align:'center', toolbar: '#barDemo'}
            ]]
            ,page: true
            ,limit:10
            ,limits:[10,20,40,50]
            ,id: 'jobevaluateoptionList'
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            //查看消息
            if(obj.event == 'udp'){
                layer.open({
                    type:2,
                    content:"toUpdJobEvaluateOption?optionId=" + data.optionId,
                    title:"编辑评分项信息",
                    area:['800px','500px'],//设置弹框的宽高
                }),
                    table.reload("jobevaluateoptionList",  {
                        url:"getJobEvaluateOptionList"
                    })
            } else if(obj.event == 'update'){
                $.ajax({
                    type: "post",
                    url: "updJobEvaluateOptionByOptionId",
                    data: {
                        optionId: data.optionId
                    },
                    dataType: "text",
                    success: function(data) {
                        if("true" == data) {
                            layer.msg("启用/停用成功");
                        }else {
                            layer.msg("启用/停用失败");
                        }
                        table.reload("jobevaluateoptionList",  {
                            url:"getJobEvaluateOptionList"
                        })
                    },
                    error: function (data) {
                        layer.msg("执行失败");
                    }
                })
            }
        });
    });
</script>
</body>
</html>
