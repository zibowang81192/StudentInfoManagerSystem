package com.princekin.sims.servlet;

import com.princekin.sims.entity.Notice;
import com.princekin.sims.entity.Student;
import com.princekin.sims.repository.NoticeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notice_list")
public class NoticeListServlet extends HttpServlet {
    NoticeRepository noticeRepository =new NoticeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> list_notice= noticeRepository.findAllNotice();
        req.setAttribute("list_notice",list_notice);
        req.getRequestDispatcher("welcome_student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
