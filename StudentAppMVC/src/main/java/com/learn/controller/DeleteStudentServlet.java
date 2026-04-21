package com.learn.controller;

import com.learn.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteStudent(id);
        res.sendRedirect(req.getContextPath() + "/listStudents");
    }
}