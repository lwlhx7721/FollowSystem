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
    <div class="demoTable">
        <div class="layui-inline">
            <input class="layui-input" style="width: 200px;" name="name" id="name" placeholder="请输入名字查找" autocomplete="off">
        </div>
        <div class="layui-input-inline">
            <select name="deptId" id="deptId"  lay-verify="required">
                <option value="0">请选择部门查找</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.deptId}">${dept.deptName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="classId" id="classId" lay-verify="required">
                <option value="0">请选择班级查找</option>
                <c:forEach items="${classList}" var="class1">
                    <option value="${class1.classId}">${class1.className}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" style="width: 100px;background-color: skyblue;;margin-left: 10px;" data-type="reload">查询</button>
        <button class="layui-btn" style="width: 100px;background-color: skyblue;margin-left: 60px;" data-type="add">添加</button>
        <button class="layui-btn" style="width: 100px;background-color: skyblue;margin-left: 10px;" data-type="delAll">一键删除</button>
    </div>
    <table class="layui-hide" id="studentList"  lay-filter="demo" lay-skin="nob"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs"  lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs"  lay-event="udp">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="del">删除</a>
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
                var deptId = $('#deptId').val();
                //执行重载
                table.reload('studentList', {
                    url:'getStudentList'
                    ,where: {
                        name: name,
                        classId:classId,
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
                    title: "新增学员",
                    content: "cityList?parentId=1&type=1",
                    area: ['800px', '500px'],//设置弹框的宽高
                    shadeClose: true //点击遮罩是否关闭弹窗
                })
            },
            delAll:function () {
            var checkStatus = table.checkStatus("studentList").data;
            if (checkStatus.length == 0) {
                layer.msg("请选择一条要修改的数据");
                return;
            }else {
                layer.confirm('确定删除吗', '删除指令', function() {
                    var stuIds = "(";
                    for (var i = 0; i < checkStatus.length; i++) {
                        stuIds += checkStatus[i].stuId + ",";
                    }
                    stuIds = stuIds.substr(0, stuIds.length - 1);
                    stuIds += ")";
                    $.ajax({
                        url: "delAllStudentsById"
                        , type: "post"
                        , data: {
                            stuIds: stuIds
                        }, dataType: "text"
                        , success: function (data) {
                            if ("true" == data) {
                                layer.msg("删除成功")
                                table.reload("studentList",{
                                    url:"getStudentList"
                                })
                            } else {
                                layer.msg("删除失败")
                            }

                        }, error: function (data) {
                            layer.msg("执行失败")
                        }
                    })
                })

            }
        }
    };

        table.render({
            elem: '#studentList'//对应table的id属性
            ,url:'getStudentList'
            ,width: 1150
            ,height: 500
            ,cols: [[
                {type:'checkbox'}
                ,{type:'numbers',title: '序号'}
                ,{field:'stuId',title:'学号',sort:true}
                ,{field:'stuName',title: '姓名'}
                ,{field:'sex',title: '性别',width:'7%',templet:function (d) {
                        if(d.sex == 1) {
                            return "女";
                        } else {
                            return "男";
                        }
                    }}
                ,{field:'university',title: '毕业院校'}
                ,{field:'state',title:'目前状态',width:'7%'}
                ,{field:'className',title:'班级'}
                ,{field:'deptName',title:'部门',sort:true}
                ,{fixed:'right',title: '操作', align:'center', toolbar: '#barDemo',width:'16%'}
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
            if(obj.event == 'detail') {
                layer.open({
                    type:2
                    ,area:['800px','500px']
                    ,title:data.stuName + '的个人信息'
                    ,content:'detailStudent?stuId=' + data.stuId
                })
            } else if(obj.event == 'udp'){
                layer.open({
                    type:2,
                    content:"updStudent?parentId=1&stuId=" + data.stuId,
                    title:"修改学生信息",
                    area:['800px','500px'],//设置弹框的宽高
                }),
                    table.reload("studentList",  {
                        url:"getStudentList"
                    })
            } else if(obj.event == 'del'){
                //删除消息
                layer.confirm('确定删除吗', '删除指令', function(){
                    $.ajax({
                        type: "post",
                        url: "delStudentByStuId",
                        data: {
                            stuId:data.stuId
                        },
                        dataType: "text",
                        success: function(data) {
                            layer.msg(data);
                            table.reload("studentList",  {
                                url: "getStudentList"
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
