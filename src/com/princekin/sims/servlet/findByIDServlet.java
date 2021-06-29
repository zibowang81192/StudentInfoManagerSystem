package com.princekin.sims.servlet;

import com.princekin.sims.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/find_id")
public class findByIDServlet extends HttpServlet {
    StudentRepository studentRepository=new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        req.setAttribute("student",studentRepository.findByID(id));
        req.getRequestDispatcher("update.jsp").forward(req,resp);
        resp.sendRedirect("student");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
