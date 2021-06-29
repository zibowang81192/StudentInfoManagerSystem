<%--
  Created by IntelliJ IDEA.
  User: hhh
  Date: 2020-05-16
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="image/update.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="title">
    <p>菜鸟驿站学生管理系统</p>
</div>

<div class="mt-tabpage">
    <div class="mt-tabpage-count">
        <div class="mt-tabpage-cont__wrap">
            <div class="mt-tabpage-item">
                <div class="student-status-item">
                    <div class="title-item">
                        <p class="form-title form-title1">
                            学籍信息
                        </p>
                        <button class="unit" type="button" onclick="window.location.href='info?id=${student.id}'"><i class="fa fa-reply"></i></button>
                    </div>
                    <div class="line"></div>
                    <form action="update" method="post">
                    <table class="student-status-form">
                        <tr>
                            <td class="fieldname">姓名：</td>
                            <td class="content">
                                <input type="text" name="name" value="${student.name}"/>
                            </td>
                            <td class="fieldname">性别：</td>
                            <td class="content">
                                <input type="text" name="sex" value="${student.sex}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldname">民族：</td>
                            <td class="content">
                                <input type="text" name="people" value="${student.people}"/>
                            </td>
                            <td class="fieldname">政治面貌：</td>
                            <td class="content">
                                <input type="text" name="political" value="${student.political}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldname">学号：</td>
                            <td class="content">
                                <input type="text" name="id" value="${student.id}" readonly/>
                            </td>
                            <td class="fieldname">身份证号：</td>
                            <td class="content">
                                <input type="text" name="verify" value="${student.verify}" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldname">籍贯：</td>
                            <td class="content">
                                <input type="text" name="home" value="${student.home}"/>
                            </td>
                            <td class="fieldname">出生日期：</td>
                            <td class="content">
                                <input type="text" name="birthday" value="${student.birthday}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldname">系所：</td>
                            <td class="content">
                                <input type="text" name="school" value="${student.school}"/>
                            </td>
                            <td class="fieldname">专业：</td>
                            <td class="content">
                                <input type="text" name="speciality" value="${student.speciality}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldname">年级：</td>
                            <td class="content">
                                <input type="text" name="grade" value="${student.grade}"/>
                            </td>
                            <td class="fieldname">班级：</td>
                            <td class="content">
                                <input type="text" name="class_name" value="${student.class_name}"/>
                            </td>
                        </tr>
                    </table>
                    <div class="line"></div>
                    <div class="update-item">
                        <button class="update-button">提交</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
