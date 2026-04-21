package com.learn.controller;

import com.learn.model.Student;
import com.learn.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listStudents")
public class ListStudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Student> students = service.getStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/listStudents.jsp").forward(req, res);
    }
}