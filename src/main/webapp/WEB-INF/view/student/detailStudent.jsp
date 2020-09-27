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
</head>
<body>
<c:forEach var="list" items="${list}">
    <%--
    stuName 姓名    ${list.stuName}
    nation 民族
    sex 性别        <c:if test="${list.stuname} == 0" >
                        <c:out value="男" ></c:out>
                    </c:if>

    marry 婚否      <c:if test="${list.marry} == 0" >
                        <c:out value="未婚" ></c:out>
                    </c:if>

    telephone 电话
    idCard 身份证号
    university 毕业院校
    major 专业
    photo 照片       <img src="../../static${list.photo}" alt="照片">
    note  备注
    class 班级
    dept  部门
    --%>
    <div>

            <%--简历--%>

    </div>
</c:forEach>
</body>
</html>
