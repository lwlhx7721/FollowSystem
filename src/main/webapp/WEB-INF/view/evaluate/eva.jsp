<%@ page import="java.util.List" %>
<%@ page import="com.jxd.model.Course" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/27
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价页面</title>
    <script src="../../../static/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
            border: 0;
            text-align: center;
            height: 800px;
        }
        td {
            text-align: center;
        }
        #main {
            text-align: center;
            margin-top: 10px;
            margin-left: 53px;
            border: 1px solid #2F4056;
            background-color: white;
            width: 1260px;
            height: 800px;
        }
    </style>
</head>
<body>
<div id="main">
    <table style="width: 100%;background-color: rgba(255,255,255,0.5);" class="layui-table">
        <caption>
            金桥学员成长跟踪表
        </caption>
        <tr>
            <td>姓名</td>
            <td>${student.stuName}</td>
            <td>性别</td>
            <c:choose>
                <c:when test="${student.sex == 0}">
                    <td>男</td>
                </c:when>
                <c:otherwise>
                    <td>女</td>
                </c:otherwise>
            </c:choose>
            <td>民族</td>
            <td>${student.nation}</td>
            <td rowspan="4"> <img src="${student.photo}" alt="照片"></td>
        </tr>
        <tr>
            <td>出生年月</td>
            <td>${student.birthday}</td>
            <td>籍贯</td>
            <td>${student.birthPlace}</td>
            <td>婚否</td>
            <c:choose>
                <c:when test="${student.marry == 0}">
                    <td>未婚</td>
                </c:when>
                <c:otherwise>
                    <td>已婚</td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>联系电话</td>
            <td colspan="2">${student.telephone}</td>
            <td>身份证号码</td>
            <td colspan="2">${student.idCard}</td>
        </tr>
        <tr>
            <td>毕业学校</td>
            <td colspan="2">${student.university}</td>
            <td>专业</td>
            <td colspan="2">${student.major}</td>
        </tr>
        <tr>
            <td>班级</td>
            <td colspan="3">${student.className}</td>
            <td>部门</td>
            <td colspan="2">${student.deptName}</td>
        </tr>
        <tr>
            <td>备注</td>
            <td colspan="6">${student.note}</td>
        </tr>
    </table>
    <table style="width: 100%;background-color: rgba(255,255,255,0.5);" class="layui-table">
        <caption>
            学校评价
        </caption>
        <tr>
            <td rowspan="2">培训学校</td>
            <td rowspan="2">班期</td>
            <td rowspan="2">评价人</td>
            <td colspan="${courseList.size()}">培训期间测试成绩</td>
            <td rowspan="2">整体评价分数</td>
        </tr>
        <tr>
            <c:forEach items="${courseList}" var="course">
                <td>${course.courseName}</td>
            </c:forEach>
        </tr>
        <tr>
            <td>学习评价</td>
            <td>${requestScope.stuSchoolEva.className}</td>
            <td>${stuSchoolEva.username}</td>
            <%
                List<Course> courseList = (List<Course>)request.getAttribute("courseList");
                Map<String,Object> map = (Map<String,Object>)request.getAttribute("stuSchoolEva");
                for(int i = 0; i < courseList.size(); i++) {
                    String courseName = courseList.get(i).getCourseName();
                    if(map.get(courseName) == null) {
                        out.print("<td>待录入</td>");
                    } else {
                        out.print("<td>" + map.get(courseName) + "</td>");
                    }
                }
            %>
            <td>${stuSchoolEva.evaluatescore}</td>
        </tr>
        <tr>
            <td rowspan="3">整体评价</td>
            <td rowspan="3" colspan="${courseList.size() + 3}">${stuSchoolEva.evaluatecontent}</td>
        </tr>
    </table>
</div>
</body>
</html>
