<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: swz
  Date: 2020/9/23
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <script src="../../../static/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
    <style>
        td {
            text-align: center;
        }
        body{
            background: url("../../../static/images/student_bg.png");
            background-repeat: no-repeat;
           background-size: 100% 100%;
        }
    </style>
</head>
<body>
    <div align="center" style="margin-top: 50px">
        <table style="width: 95%;background-color: rgba(255,255,255,0.5);" class="layui-table">
            <tr>
                <td>姓名</td>
                <td>${list.stuName}</td>
                <td>性别</td>
                <c:choose>
                    <c:when test="${list.sex == 0}">
                        <td>男</td>
                    </c:when>
                    <c:otherwise>
                        <td>女</td>
                    </c:otherwise>
                </c:choose>
                <td>民族</td>
                <td>${list.nation}</td>
                <td rowspan="4"> <img src="../${list.photo}" alt="照片"></td>
            </tr>
            <tr>
                <td>出生年月</td>
                <td>${list.birthday}</td>
                <td>籍贯</td>
                <td>${list.birthPlace}</td>
                <td>婚否</td>
                <c:choose>
                    <c:when test="${list.marry == 0}">
                        <td>未婚</td>
                    </c:when>
                    <c:otherwise>
                        <td>已婚</td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <td>联系电话</td>
                <td colspan="2">${list.telephone}</td>
                <td>身份证号码</td>
                <td colspan="2">${list.idCard}</td>
            </tr>
            <tr>
                <td>毕业学校</td>
                <td colspan="2">${list.university}</td>
                <td>专业</td>
                <td colspan="2">${list.major}</td>
            </tr>
            <tr>
                <td>备注</td>
                <td colspan="6">${list.note}</td>
            </tr>
            <tr>
                <td>班级</td>
                <td colspan="6">${list.className}</td>
            </tr>
            <tr>
                <td>部门</td>
                <td colspan="6">${list.deptName}</td>
            </tr>
        </table>
    </div>
</body>
</html>
