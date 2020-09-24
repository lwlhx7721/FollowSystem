<%--
  Created by IntelliJ IDEA.
  User: 张新云
  Date: 2020/9/23
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门信息页面</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <style>
        body {
            background-color: #393D49;
        }

        table tr:nth-child(odd) {
            background: #00FFFF;
        }

        table tr:nth-child(even) {
            background: #FFB800;
        }

        table th {
            background: #01AAED;
        }
    </style>
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center">
    <div class="demoTable" style="margin-top: 5px;">
        <div class="layui-inline">
            <input class="layui-input" style="width: 200px;" name="deptName" id="deptName" placeholder="请输入部门名称进行查询"
                   autocomplete="off">
        </div>
        <div class="layui-input-inline">
            <select name="deptId" id="deptId" style="width: 200px;" lay-verify="required">
                <option value="0">请选择部门查找</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}">${dept.deptName}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" style="width: 150px;background-color: pink;margin-left: 30px;" data-type="reload">查询
        </button>
        <button class="layui-btn" style="width: 150px;background-color: skyblue;margin-left: 30px;" data-type="add">添加
        </button>
        <button class="layui-btn" style="width: 200px;background-color: red;margin-left: 30px;" data-type="delAll">
            一键删除
        </button>
    </div>
    <table class="layui-hide" id="deptList" lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" style="background-color: #01AAED;" lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color: #FF0000;" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table', 'layer', '$'], function () {
        var table = layui.table
            , $ = layui.jquery
            , layer = layui.layer;
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        var active = {
            reload: function () {
                //获取查询框的值
                var deptName = $('#deptName').val();
                var deptId = $('#deptId').val();
                //执行重载
                table.reload('deptList', {
                    url: 'getDeptList'
                    , where: {
                        deptName: deptName,
                        deptId: deptId
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }, 'data');
            },
            add: function () {
                layer.open({
                    type: 2,
                    title: "新增部门",
                    content: "toAddDept",
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            },
            del: function () {
                var checkStatus = table.checkStatus("deptList").data;
                if (checkStatus.length == 0) {
                    layer.msg('请选择一条数据');
                    return;
                }
                layer.confirm("确定删除吗", "删除", function () {
                    var deptIds = "";
                    for (var i = 0; i < checkStatus.length; i++) {
                        deptIds += checkStatus[i].deptId + ",";
                    }
                    deptIds = deptIds.substring(0, deptIds.length - 1);
                    $.ajax({
                        type: "post",
                        url: "delDepts",
                        data: {
                            deptIds: deptIds
                        },
                        dataType: "text",
                        success: function (data) {
                            if ("true" == data) {
                                layer.msg("删除成功");
                            } else {
                                layer.msg("删除失败");
                            }
                            table.reload("deptList", {
                                url: "getDeptList"
                            })
                        },
                        error: function () {
                            alert("执行失败")
                        }
                    })
                })
            }
        };

        table.render({
            elem: '#deptList'//对应table的id属性
            , url: 'getDeptList'
            , width: 1150
            , height: 480
            , cols: [[
                {type: 'checkbox', width: '10%'}
                , {type: 'numbers', title: '序号'}
                , {field: 'deptId', title: '部门编号', sort: true}
                , {field: 'deptName', title: '部门名称'}
                , {field: 'deptAddress', title: '部门地址'}
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
            , limit: 10
            , limits: [10, 20, 40, 50]
            , id: 'deptList'
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            //查看消息
            if (obj.event == 'udp') {
                layer.open({
                    type: 2,
                    content: "getDeptByDeptId?deptId=" + data.deptId,
                    title: "编辑学生信息",
                    area: ['800px', '500px'],//设置弹框的宽高
                }),
                    table.reload("deptList", {
                        url: "getDeptList"
                    })
            } else if (obj.event == 'del') {
                //删除消息
                layer.confirm('确定删除吗', '删除指令', function () {
                    $.ajax({
                        type: "post",
                        url: "delDeptByDeptId",
                        data: {
                            deptId: data.deptId
                        },
                        dataType: "text",
                        success: function (data) {
                            if ("true" == data) {
                                layer.msg("删除成功");
                            } else {
                                layer.msg("删除失败");
                            }
                            table.reload("deptList", {
                                url: "getDeptList"
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
