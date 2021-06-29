package com.princekin.sims.servlet;



import com.princekin.sims.repository.NoticeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
@WebServlet("/addNotice")
public class AddNoticeServlet extends HttpServlet {
    private NoticeRepository noticeRepository=new NoticeRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String topic=req.getParameter("topic");
        String text=req.getParameter("text");
        java.util.Date  date1=new java.util.Date();
        java.sql.Date  date=new java.sql.Date(date1.getTime());
        noticeRepository.add(topic,text,date);
        resp.sendRedirect("welcome_admin.jsp");
    }
}
