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
@WebServlet("/update_code")
public class UpdateCodeServlet extends HttpServlet {
    StudentRepository studentRepository=new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username="";
        String new_password=req.getParameter("new_password");
        String repeat_password=req.getParameter("repeat_password");
        Cookie[] cookies=req.getCookies();
        for(Cookie c: cookies)
        {
            if("username".equals(c.getName()))
            {
                username=c.getValue();
            }
        }
        int id=Integer.parseInt(username);
        if(new_password.equals(repeat_password)){
            studentRepository.update_code(id,new_password);
            resp.sendRedirect("find_student");
        }
        else{
            resp.sendRedirect("update_code.jsp");
        }

    }
}
