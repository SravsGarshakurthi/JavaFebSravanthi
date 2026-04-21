package com.learn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60);
            res.sendRedirect(req.getContextPath() + "/listStudents");
        } else {
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }
}