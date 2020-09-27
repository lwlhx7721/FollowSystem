<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="../../static/js/jquery-3.3.1.js"></script>
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
<div style="text-align: center">
    <div style="margin-top: 20px;margin-bottom: 20px;">
        <select name="roleId" id="roleId" style="width: 200px;height: 30px;border-radius: 5% ;border-color: #01AAED;">
            <option value="0">请选择</option>
            <c:forEach items="${sessionScope.roles}" var="role">
                <option value="${role.roleId}">
                        ${role.roleName}
                </option>
            </c:forEach>
        </select>
    </div>
    <br>
    <button id="btn" class="layui-btn" style="width: 200px;height: 40px;">确定</button>
</div>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: 'roles',
                type: "post",
                data: {
                    roleId: $("#roleId").val()
                },
                success: function (data) {
                    if("index" == data) {
                        parent.location = "index";
                    } else {
                        parent.location = "logout"
                    }
                }
            })
        })
    })
</script>
</body>
</html>
