package com.learn.service;

import com.learn.dao.StudentDAO;
import com.learn.model.Student;
import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public String addStudent(Student student) {
        try {
            int rows = studentDAO.addStudent(student);
            if (rows == 0) return "Failed to add student.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
        return null; // null = success
    }

    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
}