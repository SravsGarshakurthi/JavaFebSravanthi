<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Book a Seat</title></head>
<body>
<h2>✈️ Book a Seat</h2>

<p><strong>Flight:</strong> ${flight.flightNumber} |
    ${flight.origin} → ${flight.destination} |
    ${flight.departureTime} |
    Seats left: ${flight.availableSeats}</p>

<% if (request.getAttribute("error") != null) { %>
<p style="color:red;">${error}</p>
<% } %>

<form action="${pageContext.request.contextPath}/flights/${flight.id}/book"
      method="POST">
    Passenger Name:  <input type="text"  name="passengerName"  required><br><br>
    Passenger Email: <input type="email" name="passengerEmail" required><br><br>
    <button type="submit">Confirm Booking</button>
    <a href="${pageContext.request.contextPath}/flights">Back to Flights</a>
</form>
</body>
</html>