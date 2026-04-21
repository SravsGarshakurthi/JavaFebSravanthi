<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Booking Confirmed</title></head>
<body>
<h2>✅ Booking Confirmed!</h2>

<p><strong>Booking ID:</strong> ${booking.id}</p>
<p><strong>Passenger:</strong> ${booking.passengerName}</p>
<p><strong>Email:</strong> ${booking.passengerEmail}</p>
<p><strong>Flight:</strong> ${booking.flight.flightNumber}</p>
<p><strong>Route:</strong> ${booking.flight.origin} → ${booking.flight.destination}</p>
<p><strong>Departure:</strong> ${booking.flight.departureTime}</p>

<br>
<a href="${pageContext.request.contextPath}/flights">
    <button>Book Another Flight</button>
</a>
<a href="${pageContext.request.contextPath}/logout">
    <button>Logout</button>
</a>
</body>
</html>