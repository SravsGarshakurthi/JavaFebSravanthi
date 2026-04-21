<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Student Portal Login</title></head>
<body>
<h2>Student Portal Login</h2>

<% String error = (String) request.getAttribute("error");
    if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="${pageContext.request.contextPath}/login" method="POST">
    <label>Username</label><br>
    <input type="text" name="username" required autofocus><br><br>
    <label>Password</label><br>
    <input type="password" name="password" required><br><br>
    <button type="submit">Login</button>
</form>
</body>
</html>