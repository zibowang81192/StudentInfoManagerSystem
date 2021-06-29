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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find_student")
public class findStudentServlet extends HttpServlet {
    StudentRepository studentRepository=new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username="";
        Cookie[] cookies=req.getCookies();
        for(Cookie c: cookies)
        {
            if("username".equals(c.getName()))
            {
               username=c.getValue();
            }
        }

        List<Student> list=new ArrayList<Student>();
        list.add(studentRepository.findByID(username));
        req.setAttribute("list",list);

        req.getRequestDispatcher("welcome_student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
