<%--
  Created by IntelliJ IDEA.
  User: Pluto
  Date: 2020/5/21
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加公告</title>
    <link type="text/css" rel="stylesheet" href="image/addnotice.css"/>
    <link type="text/css" rel="stylesheet" href="image/main.css"/>
</head>
<body>
<div class="title">
    <p>菜鸟驿站学生管理系统</p>
</div>
<div class="mt-tabpage-item">
    <div class="add-item">
        <p class="form-title">发布公告</p>
        <div class="line"></div>
        <form action="addNotice" method="post">
            <table class="add-form">
                <tr>
                    <td class="fieldname">
                        <p>标题：</p>
                    </td>
                    <td class="input">
                        <input type="text" name="topic" required>
                    </td>
                </tr>
                <tr>
                    <td class="fieldname">
                        <p>内容：</p>
                    </td>
                    <td class="input">
                        <textarea type="text" name="text" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="submit submit-line">
                        <div class="line"></div>
                </tr>
                <tr>
                    <td colspan="4" class="submit">
                        <input type="submit" value="提交"/>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
