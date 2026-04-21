package com.flights.service;

import com.flights.dao.*;
import com.flights.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class FlightBookingService {

    private final FlightRepository flightRepo;
    private final BookingRepository bookingRepo;

    @Autowired
    public FlightBookingService(FlightRepository flightRepo,
                                BookingRepository bookingRepo) {
        this.flightRepo  = flightRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found: " + id));
    }

    // Core booking logic — decreases available seats
    @Transactional
    public Booking bookSeat(Long flightId, String name, String email) {
        Flight flight = getFlightById(flightId);

        if (flight.isFullyBooked()) {
            throw new RuntimeException("Flight is fully booked!");
        }

        // Decrease available seats by 1
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepo.save(flight);

        // Create booking record
        Booking booking = new Booking();
        booking.setPassengerName(name);
        booking.setPassengerEmail(email);
        booking.setFlight(flight);
        return bookingRepo.save(booking);
    }
}