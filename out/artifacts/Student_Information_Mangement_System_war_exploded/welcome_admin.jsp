<%@ page import="com.princekin.sims.repository.NoticeRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.princekin.sims.entity.Notice" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>jQuery</title>
    <link type="text/css" rel="stylesheet" href="image/welcome_admin.css"/>
    <link type="text/css" rel="stylesheet" href="image/main.css"/>
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
    <!--删除确认-->
    <script>
        function confirmDel() {
            if(!confirm("确认要删除吗？")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>
    <div class="title">
        <p>菜鸟驿站学生管理系统</p>
    </div>

    <div class="mt-tabpage" js-tab="2">

        <!--导航栏-->
        <div class="mt-tabpage-title">
            <div class="mt-tabpage-item  mt-tabpage-item-cur">我的消息</div>
            <div class="mt-tabpage-item">学生管理</div>
            <div class="mt-tabpage-item">学生添加</div>
        </div>

        <!--内容栏-->
        <div class="mt-tabpage-count">
            <div class="mt-tabpage-cont__wrap">

                <!--我的消息-->
                <div class="mt-tabpage-item">
                    <div class="news-item">
                        <div class="update-item">
                            <button class="update-button" onclick="window.location.href='addNotice.jsp'">添加公告</button>
                        </div>
                        <div class="line"></div>
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
                    </div>
                </div>

                <!--学生管理-->
                <form action="search" method="get">
                <div class="mt-tabpage-item">
                    <div class="select-item">

                        <p>专业：</p>
                        <select class="select" name="bySpecial">
                            <option>计算机科学与技术</option>
                            <option>通信工程</option>
                            <option>电子信息工程</option>
                        </select>
                        <p>班级：</p>
                        <select class="select" name="byClass">
                            <option>计算机一班</option>
                            <option>计算机二班</option>
                            <option>计算机三班</option>
                            <option>通信一班</option>
                            <option>通信二班</option>
                            <option>电信一班</option>
                            <option>电信二班</option>

                        </select>
                        <button class="search">检索</button>
                    </div>

                    <div class="line"></div>
                    <div class="student-information">

                        <p class="form-title">学生信息</p>
                        <div style="height:100%;width:100%;overflow:scroll;background-color:transparent;">
                        <table class="student-information-form">
                            <tr>
                                <th class="fieldname">姓名</th>
                                <th class="fieldname">性别</th>
                                <th class="fieldname">学号</th>
                                <th class="fieldname">年级</th>
                                <th class="fieldname">专业</th>
                                <th class="fieldname">班级</th>
                                <th class="fieldname">操作</th>
                            </tr>
                        <c:forEach items="${list}" var="student">
                            <tr>
                                <td class="content">${student.name}</td>
                                <td class="content">${student.sex}</td>
                                <td class="content">${student.id}</td>
                                <td class="content">${student.grade}</td>
                                <td class="content">${student.speciality}</td>
                                <td class="content">${student.class_name}</td>
                                <td class="content link">
                                    <a href="info?id=${student.id}">详情</a>
                                    <a href="delete?id=${student.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </table>
                        </div>
                    </div>
                </div>
                </form>

                <!--学生添加-->
                <div class="mt-tabpage-item">
                    <div class="add-item">
                        <p class="form-title">新成员信息</p>
                        <div class="line"></div>
                        <div class="content">
                        <form action="add" method="post">
                            <table class="add-form">
                                <tr>
                                    <td class="fieldname">
                                        <p>姓名：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="name" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>性别：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="sex" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="fieldname">
                                        <p>民族：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="people" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>政治面貌：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="political" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="fieldname">
                                        <p>学号：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="id" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>身份证号：</p>
                                    <td class="input">
                                        <input type="text" name="verify" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="fieldname">
                                        <p>籍贯：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="home" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>出生日期：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="birthday" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="fieldname">
                                        <p>系所：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="school" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>专业：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="speciality" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="fieldname">
                                        <p>年级：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="grade" required>
                                    </td>
                                    <td class="fieldname">
                                        <p>班级：</p>
                                    </td>
                                    <td class="input">
                                        <input type="text" name="class_name" required>
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
                </div>
            </div>
        </div>
    </div>



</body>
</html>
