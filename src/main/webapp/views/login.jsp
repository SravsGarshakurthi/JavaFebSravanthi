<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Flight Booking - Login</title></head>
<body>
<h2>✈️ Flight Booking System</h2>
<h3>Login</h3>
<% if (request.getAttribute("error") != null) { %>
<p style="color:red;">${error}</p>
<% } %>
<form action="${pageContext.request.contextPath}/login" method="POST">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button type="submit">Login</button>
</form>
</body>
</html>