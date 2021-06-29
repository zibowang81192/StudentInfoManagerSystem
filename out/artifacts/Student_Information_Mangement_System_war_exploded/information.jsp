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
    <link type="text/css" rel="stylesheet" href="image/info.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="js/mt-tabpage.js"></script>
    <!--导航栏滑动翻页-->
    <script>
        $(function () {
            $('[js-tab=2]').tab({
                curDisplay: 1,
                changeMethod: 'horizontal'
            });

            $('[js-tab=3]').tab({
                curDisplay: 1,
                changeMethod: 'horizontal'
            });
        });
    </script>
</head>
<body>
<c:forEach items="${list}" var="student">
    <div class="title">
        <p>菜鸟驿站学生管理系统</p>
    </div>

    <div class="mt-tabpage" js-tab="2">

        <!--导航栏-->
        <div class="mt-tabpage-title">
            <div class="mt-tabpage-item mt-tabpage-item-cur">学籍信息</div>
            <div class="mt-tabpage-item">学业成绩</div>
        </div>

        <!--内容栏-->
        <div class="mt-tabpage-count">
            <div class="mt-tabpage-cont__wrap">

                <!--学籍信息-->
                <div class="mt-tabpage-item">
                    <div class="student-status-item">
                        <div class="title-item">
                            <p class="form-title form-title1">
                                学籍信息
                            </p>
                            <button class="unit" type="button" onclick="window.location.href='search?bySpecial=${student.speciality}&byClass=${student.class_name}'"><i class="fa fa-reply"></i></button>
                        </div>
                        <div class="line"></div>
                        <table class="student-status-form">

                            <tr>
                                <td class="fieldname">姓名：</td>
                                <td class="content">${student.name}</td>
                                <td class="fieldname">性别：</td>
                                <td class="content">${student.sex}</td>
                            </tr>
                            <tr>
                                <td class="fieldname">民族：</td>
                                <td class="content">${student.people}</td>
                                <td class="fieldname">政治面貌：</td>
                                <td class="content">${student.political}</td>
                            </tr>
                            <tr>
                                <td class="fieldname">学号：</td>
                                <td class="content">${student.id}</td>
                                <td class="fieldname">身份证号：</td>
                                <td class="content">${student.verify}</td>
                            </tr>
                            <tr>
                                <td class="fieldname">籍贯：</td>
                                <td class="content">${student.home}</td>
                                <td class="fieldname">出生日期：</td>
                                <td class="content">${student.birthday}</td>
                            </tr>
                            <tr>
                                <td class="fieldname">系所：</td>
                                <td class="content">${student.school}</td>
                                <td class="fieldname">专业：</td>
                                <td class="content">${student.speciality}</td>
                            </tr>
                            <tr>
                                <td class="fieldname">年级：</td>
                                <td class="content">${student.grade}</td>
                                <td class="fieldname">班级：</td>
                                <td class="content">${student.class_name}</td>
                            </tr>


                        </table>
                        <div class="line"></div>
                        <div class="update-item">
                            <button class="update-button" onclick="window.location.href='find_id?id=${student.id}'">修改信息</button>
                        </div>
                    </div>
                </div>

                <!--学业成绩-->
                <div class="mt-tabpage-item">
                    <div class="line"></div>
                    <div class="grade">
                        <p class="form-title">
                            单科成绩
                        </p>
                        <table class="grade-form">
                            <tr>
                                <th class="fieldname">序号</th>
                                <th class="fieldname">课程名</th>
                                <th class="fieldname">课程属性</th>
                                <th class="fieldname">学分</th>
                                <th class="fieldname">成绩</th>
                            </tr>
                            <tr>
                                <td class="content">1</td>
                                <td class="content">微积分</td>
                                <td class="content">必修</td>
                                <td class="content">4</td>
                                <td class="content">${student.calculus}</td>

                            </tr>
                            <tr>
                                <td class="content">2</td>
                                <td class="content">线性代数</td>
                                <td class="content">必修</td>
                                <td class="content">4</td>
                                <td class="content">${student.linear_algebra}</td>
                            </tr>
                            <tr>
                                <td class="content">3</td>
                                <td class="content">概率论</td>
                                <td class="content">必修</td>
                                <td class="content">4</td>
                                <td class="content">${student.probability_theory}</td>
                            </tr>
                            <tr>
                                <td class="content">4</td>
                                <td class="content">算法</td>
                                <td class="content">必修</td>
                                <td class="content">4</td>
                                <td class="content">${student.algorithm}</td>
                            </tr>
                        </table>
                    </div>
                    <div class="line"></div>

                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
