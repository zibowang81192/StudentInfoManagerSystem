<%@ page import="com.princekin.sims.repository.NoticeRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.princekin.sims.entity.Notice" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Pluto
  Date: 2020/5/9
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jQuery</title>
    <link type="text/css" rel="stylesheet" href="image/stu_show.css"/>
    <link type="text/css" rel="stylesheet" href="image/main.css"/>
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="js/mt-tabpage.js"></script>
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
<div class="title">
    <p>菜鸟驿站学生管理系统</p>
</div>
<div class="mt-tabpage" js-tab="2">

    <!--导航栏-->
    <div class="mt-tabpage-title">
        <div class="mt-tabpage-item mt-tabpage-item-cur">个人管理</div>
        <div class="mt-tabpage-item">成绩查询</div>
        <div class="mt-tabpage-item">我的消息</div>
    </div>

    <!--内容栏-->
    <div class="mt-tabpage-count">
        <div class="mt-tabpage-cont__wrap">

            <!--个人管理-->
            <c:forEach items="${list}" var="student">
            <div class="mt-tabpage-item">
                <div class="student-status-item">
                    <p class="form-title">
                        学籍信息
                    </p>
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
                </div>
                <div class="account-item">
                    <p class="form-title">
                        账号信息
                    </p>
                    <table class="account-form">
                        <tr>
                            <td class="fieldname">账号：</td>
                            <td class="content">${student.id}</td>
                            <td class="fieldname">密码：</td>
                            <td class="content password">
                                <p>*****</p>
                                <a href="update_code.jsp">修改</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

            <!--成绩查询-->
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
            </c:forEach>
            <!--公告-->

                <div class="mt-tabpage-item">
                    <div class="news-item">
                        <p class="form-title">全部消息</p>
                        <div class="line"></div>

                            <table>
                        <table class="news-form">
                            <div style="height:100%;width:100%;overflow:scroll;background-color:transparent;">

                            <%
                                NoticeRepository noticeRepository =new NoticeRepository();
                                List<Notice> noticeList=new ArrayList<>();
                                noticeList= noticeRepository.findAllNotice();
                                Notice notice=null;

                                for(int i=0;i<noticeList.size();i++){
                                    notice=noticeList.get(i);


                                    if(notice!=null){
                                        out.write("标题："+notice.getTopic()+"<br>");
                                        out.write("内容："+notice.getText()+"<br>");
                                        out.write("日期："+notice.getDate()+"<br>");
                                        out.write("  <div class=\"line\"></div>");
                                    }
                                    else{
                                        out.write("null\n");
                                    }


                                }
                            %>
                            </div>
                        </table>
                            </table>
                    </div>
                </div>

        </div>
    </div>
</div>
</div>
</body>
</html>