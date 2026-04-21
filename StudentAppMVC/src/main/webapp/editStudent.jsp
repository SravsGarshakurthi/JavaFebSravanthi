<%@ page import="com.learn.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>

<% Student s = (Student) request.getAttribute("student"); %>

<form action="${pageContext.request.contextPath}/updateStudent" method="POST">
    <input type="hidden" name="id" value="<%= s.getId() %>">

    Name:   <input type="text"   name="name"   value="<%= s.getName() %>"   required><br><br>
    Email:  <input type="email"  name="email"  value="<%= s.getEmail() %>"  required><br><br>
    Course: <input type="text"   name="course" value="<%= s.getCourse() %>" required><br><br>
    Marks:  <input type="number" name="marks"  value="<%= s.getMarks() %>"
                   min="0" max="100" step="0.1" required><br><br>

    <button type="submit">Update Student</button>
    <a href="${pageContext.request.contextPath}/listStudents">Cancel</a>
</form>
</body>
</html>