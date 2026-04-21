<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Add Student</title></head>
<body>
<h2>Add New Student</h2>

<% String error = (String) request.getAttribute("error");
    if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="${pageContext.request.contextPath}/addStudent" method="POST">
    Name:   <input type="text"   name="name"   required><br><br>
    Email:  <input type="email"  name="email"  required><br><br>
    Course: <input type="text"   name="course" required><br><br>
    Marks:  <input type="number" name="marks"  min="0" max="100" step="0.1" required><br><br>
    <button type="submit">Save Student</button>
    <a href="${pageContext.request.contextPath}/listStudents">Cancel</a>
</form>
</body>
</html>