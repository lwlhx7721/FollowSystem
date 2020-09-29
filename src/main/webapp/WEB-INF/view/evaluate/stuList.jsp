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
<div align="center" class="layui-form" style="display: flex;justify-content: center;font-size: 12px">
    <table class="layui-table" id="evaList"
           lay-data="{
                width: 1366,
                height: 515,
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
        <tr style="height: 10px">
            <th lay-data="{type:'numbers',width:'3%'}" rowspan="2">序号</th>
            <th lay-data="{field:'stuid',width:'7%'}" rowspan="2">学号</th>
            <th lay-data="{field:'stuname',width:'6%',templet:function (d) {
                        return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>' + d.stuname + '</a>'
                }}" rowspan="2">姓名</th>
            <th lay-data="{field:'sex',width:'4%',templet:function (d) {
                        if(d.sex == 1) {
                            return '女';
                        } else {
                            return '男';
                        }
                }}" rowspan="2">性别</th>
            <th lay-data="{field:'university',width:'7%'}" rowspan="2">学校</th>
            <th lay-data="{field:'birthPlace',width:'7%'}" rowspan="2">籍贯</th>
            <%--<th lay-data="{field:'className',width:'9%'}" rowspan="2">班级</th>--%>
            <th lay-data="{align:'center',width:'33%'}" colspan="${courseList.size()}">培训成绩</th>
            <th lay-data="{align:'center',width:'33%'}" colspan="5">评价</th>
        </tr>
        <tr>
            <c:forEach items="${courseList}" var="course">
                <th lay-data="{field:'${course.courseName}',templet:function (d) {
                        if(d.${course.courseName} == null) {
                            return '待录入';
                        } else {
                            return d.${course.courseName};
                        }
                }}">${course.courseName}</th>
            </c:forEach>
            <th lay-data="{field:'学校评价',templet:function (d) {
                        if(d.学校评价 == null) {
                            return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>待评价</a>';
                        } else {
                            return d.学校评价;
                        }
                }}">学校评价</th>
            <th lay-data="{field:'转正评价',templet:function (d) {
                        if(d.转正评价 == null) {
                            return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>待评价</a>';
                        } else {
                            return d.转正评价;
                        }
                }}">转正</th>
            <th lay-data="{field:'工作一年评价',templet:function (d) {
                        if(d.工作一年评价 == null) {
                            return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>待评价</a>';
                        } else {
                            return d.工作一年评价;
                        }
                }}">工作一年</th>
            <th lay-data="{field:'工作两年评价',templet:function (d) {
                        if(d.工作两年评价 == null) {
                            return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>待评价</a>';
                        } else {
                            return d.工作两年评价;
                        }
                }}">工作两年</th>
            <th lay-data="{field:'工作三年评价',templet:function (d) {
                        if(d.工作三年评价 == null) {
                            return '<a href=\'evaluate?stuId=' + d.stuid + '\' target=\'main\' style=\'color: blue;\'>待评价</a>';
                        } else {
                            return d.工作三年评价;
                        }
                }}">工作三年</th>
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

