package com.learn.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    private static final String[] PUBLIC_URLS = { "/login", "/login.jsp" };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest  req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        // Allow static resources
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png")) {
            chain.doFilter(request, response);
            return;
        }

        // Allow public URLs
        for (String pub : PUBLIC_URLS) {
            if (uri.endsWith(pub)) {
                chain.doFilter(request, response);
                return;
            }
        }

        // Check session
        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("username") != null);

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}