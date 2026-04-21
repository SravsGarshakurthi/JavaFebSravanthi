<%@ page import="com.learn.model.Student, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Student List</title></head>
<body>
<h2>Student Records</h2>

<% String loggedInUser = (String) session.getAttribute("username"); %>
<p>Welcome, <strong><%= loggedInUser %></strong> |
    <a href="${pageContext.request.contextPath}/logout">Logout</a></p>

<a href="${pageContext.request.contextPath}/addStudent">+ Add Student</a><br><br>

<table border="1" cellpadding="8">
    <thead>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th>
        <th>Course</th><th>Marks</th><th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students == null || students.isEmpty()) {
    %>
    <tr><td colspan="6">No students found.</td></tr>
    <% } else {
        for (Student s : students) { %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
        <td><%= s.getMarks() %></td>
        <td>
            <a href="${pageContext.request.contextPath}/updateStudent?id=<%= s.getId() %>">Edit</a> |
            <a href="${pageContext.request.contextPath}/deleteStudent?id=<%= s.getId() %>"
               onclick="return confirm('Delete this student?')">Delete</a>
        </td>
    </tr>
    <% } } %>
    </tbody>
</table>
</body>
</html>