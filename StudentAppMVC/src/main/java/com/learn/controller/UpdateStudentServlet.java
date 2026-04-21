package com.learn.controller;

import com.learn.model.Student;
import com.learn.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    // GET → load student data into edit form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = service.getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/editStudent.jsp").forward(req, res);
    }

    // POST → save updated data
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id       = Integer.parseInt(req.getParameter("id"));
        String name  = req.getParameter("name");
        String email = req.getParameter("email");
        String course= req.getParameter("course");
        double marks = Double.parseDouble(req.getParameter("marks"));

        Student student = new Student(id, name, email, course, marks);
        service.updateStudent(student);
        res.sendRedirect(req.getContextPath() + "/listStudents");
    }
}