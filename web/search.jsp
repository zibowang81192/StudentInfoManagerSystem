<%--
  Created by IntelliJ IDEA.
  User: Pluto
  Date: 2020/5/6
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
</head>
<body>
    <form action="search" method="get">
        <select name="choice">
            <option value="byID">按学号查询</option >
            <option value="byClass">按专业班级查询</option >
        </select>
        <input type="text" name="text">
        <input type="submit" value="提交">
    </form>
</body>
</html>
