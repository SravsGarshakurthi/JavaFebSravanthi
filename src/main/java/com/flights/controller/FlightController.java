package com.flights.controller;

import com.flights.model.Booking;
import com.flights.service.FlightBookingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private final FlightBookingService service;

    @Autowired
    public FlightController(FlightBookingService service) {
        this.service = service;
    }

    // Home — show all flights with available seats
    @GetMapping
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("user") == null)
            return "redirect:/login";
        model.addAttribute("flights", service.getAllFlights());
        return "home";
    }

    // Book form — show booking form for a flight
    @GetMapping("/{id}/book")
    public String showBookForm(@PathVariable Long id,
                               HttpSession session, Model model) {
        if (session.getAttribute("user") == null)
            return "redirect:/login";
        model.addAttribute("flight", service.getFlightById(id));
        return "book";
    }

    // Book submit — process the booking
    @PostMapping("/{id}/book")
    public String doBook(@PathVariable Long id,
                         @RequestParam String passengerName,
                         @RequestParam String passengerEmail,
                         HttpSession session, Model model) {
        if (session.getAttribute("user") == null)
            return "redirect:/login";
        try {
            Booking booking = service.bookSeat(id, passengerName, passengerEmail);
            model.addAttribute("booking", booking);
            return "confirmation";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("flight", service.getFlightById(id));
            return "book";
        }
    }
}