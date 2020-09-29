<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css ">
    <link rel="stylesheet" href="../../../static/css/list.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
<div align="center" class="layui-form">
    <table class="layui-table" id="evaList"
           lay-data="{
                width:1350,
                height: 520,
                url:'evaList',
                page: true,
                limit: 10,
                limits:[10,20,40,50],
                parseData: function(res){
                    return {
                        'code': 0,
                        'msg': '',
                        'count': res.count,
                        'data': res.list};
                    }
                }
                ">
        <thead>
        <tr>
            <th lay-data="{type:'numbers'}" rowspan="2">序号</th>
            <th lay-data="{field:'stuid'}" rowspan="2">学号</th>
            <th lay-data="{field:'stuname'}" rowspan="2">姓名</th>
            <th lay-data="{align:'center'}" colspan="3">培训成绩</th>
        </tr>
        <tr>
            <th lay-data="{field:'HTML基础'}">HTML基础</th>
            <th lay-data="{field:'java基础'}">java基础</th>
            <th lay-data="{field:'java高级'}">java高级</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    layui.use(['table','layer','form'], function(){
        var table = layui.table
            ,$ = layui.jquery
            ,form = form
            ,layer = layui.layer;
        /*table.render({
            elem: '#evaList'//对应table的id属性
            ,url:'evaList'
            ,width: '98%'
            ,height: 400
            ,page: true
            ,limit:10
            ,limits:[10,20,40,50]
            ,parseData: function(res){return {"code": 0, "msg": '', "count": res.count,"data": res.list};}
            ,id: 'evaList'
        });*/
    });
</script>
</body>
</html>

