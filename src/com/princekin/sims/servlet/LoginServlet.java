package com.princekin.sims.servlet;

import com.princekin.sims.entity.Student;
import com.princekin.sims.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String user=req.getParameter("user");
        if(user.equals("admin")){
            if(username.equals("admin")&&password.equals("admin")){
                req.getSession().setAttribute("username", username);
                Cookie cookie=new Cookie("username",username);
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);

                resp.sendRedirect("search");
            }
            else{
                resp.sendRedirect("false_login.jsp");
            }
        }
        else{
            StudentRepository studentRepository=new StudentRepository();
            Student student=studentRepository.findByID(username);
            if(student!=null&&password.equals(student.getPassword())){
                req.getSession().setAttribute("username", username);
                Cookie cookie=new Cookie("username",username);
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);

                resp.sendRedirect("find_student");
            }
            else{
                resp.sendRedirect("false_login.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
