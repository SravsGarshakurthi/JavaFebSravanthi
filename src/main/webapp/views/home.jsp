<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Available Flights</title></head>
<body>
<h2>✈️ Available Flights</h2>
<p>Welcome, <strong>${sessionScope.user}</strong> |
    <a href="${pageContext.request.contextPath}/logout">Logout</a></p>

<table border="1" cellpadding="10">
    <thead>
    <tr>
        <th>Flight No.</th>
        <th>From</th>
        <th>To</th>
        <th>Departure</th>
        <th>Available Seats</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="f" items="${flights}">
        <tr>
            <td>${f.flightNumber}</td>
            <td>${f.origin}</td>
            <td>${f.destination}</td>
            <td>${f.departureTime}</td>
            <td>${f.availableSeats} / ${f.totalSeats}</td>
            <td>
                <c:choose>
                    <c:when test="${f.fullyBooked}">
                        <span style="color:red;">Fully Booked</span>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/flights/${f.id}/book">
                            Book Seat
                        </a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>