package com.flights.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String passengerEmail;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    public Booking() {}

    public Long getId()                     { return id; }
    public String getPassengerName()        { return passengerName; }
    public String getPassengerEmail()       { return passengerEmail; }
    public Flight getFlight()               { return flight; }

    public void setId(Long id)                              { this.id = id; }
    public void setPassengerName(String passengerName)      { this.passengerName = passengerName; }
    public void setPassengerEmail(String passengerEmail)    { this.passengerEmail = passengerEmail; }
    public void setFlight(Flight flight)                    { this.flight = flight; }
}