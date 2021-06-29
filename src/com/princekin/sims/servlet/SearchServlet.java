package com.princekin.sims.servlet;

import com.princekin.sims.entity.Student;
import com.princekin.sims.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    StudentRepository studentRepository=new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String bySpecial=req.getParameter("bySpecial");
        String byClass=req.getParameter("byClass");
        List<Student> list=new ArrayList<Student>();
        list=studentRepository.searchByInfo(bySpecial,byClass);

        req.setAttribute("list",list);
        req.getRequestDispatcher("welcome_admin.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
