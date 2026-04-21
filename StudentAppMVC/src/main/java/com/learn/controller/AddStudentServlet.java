package com.learn.controller;

import com.learn.model.Student;
import com.learn.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/addStudent.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name   = req.getParameter("name");
        String email  = req.getParameter("email");
        String course = req.getParameter("course");
        double marks  = Double.parseDouble(req.getParameter("marks"));

        // Create Student object and pass to service
        Student student = new Student(0, name, email, course, marks);
        String error = service.addStudent(student);

        if (error != null) {
            req.setAttribute("error", error);
            req.getRequestDispatcher("/addStudent.jsp").forward(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/listStudents");
        }
    }
}