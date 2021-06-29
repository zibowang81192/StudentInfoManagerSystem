package com.princekin.sims.servlet;

import com.princekin.sims.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private StudentRepository studentRepository=new StudentRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String people=req.getParameter("people");
        String political=req.getParameter("political");
        int id=Integer.parseInt(req.getParameter("id"));
        String verify=req.getParameter("verify");
        String home=req.getParameter("home");
        String s=req.getParameter("birthday");
        Date birthday=Date.valueOf(s);
        String school=req.getParameter("school");
        String speciality=req.getParameter("speciality");
        String grade=req.getParameter("grade");
        String class_name=req.getParameter("class_name");
        studentRepository.update(name,sex,people,political,id,verify,home,birthday,school,speciality,grade,class_name);
        resp.sendRedirect("info?id="+id);
    }
}
