<%--
  Created by IntelliJ IDEA.
  User: Pluto
  Date: 2020/5/10
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link type="text/css" rel="stylesheet" href="image/upcode.css"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
    <form action="update_code" method="post">
        <div class="main">
            <!--修改密码-->
            <div class="Frame">
                <!--标题-->
                <p class="Title">修改密码</p>
                <button class="unit" type="button" onclick="window.location.href='find_student'"><i class="fa fa-reply"></i></button>
                <!--密码-->
                <div class="new_password">
                        <p>新密码</p>
                        <input type="text"  name="new_password">
                </div>
                <!--重复密码-->
                <div class="rep_password">
                        <p>确认密码</p>
                        <input type="text" name="repeat_password">
                </div>
                <!--登录按钮-->
                <div>
                    <button value="提交" type="submit" class="submit">提交</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
