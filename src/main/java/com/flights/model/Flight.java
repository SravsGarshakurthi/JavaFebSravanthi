package com.flights.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flightNumber;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String departureTime;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int availableSeats;

    public Flight() {}

    // Getters and Setters
    public Long getId()                     { return id; }
    public String getFlightNumber()         { return flightNumber; }
    public String getOrigin()               { return origin; }
    public String getDestination()          { return destination; }
    public String getDepartureTime()        { return departureTime; }
    public int getTotalSeats()              { return totalSeats; }
    public int getAvailableSeats()          { return availableSeats; }

    public void setId(Long id)                          { this.id = id; }
    public void setFlightNumber(String flightNumber)    { this.flightNumber = flightNumber; }
    public void setOrigin(String origin)                { this.origin = origin; }
    public void setDestination(String destination)      { this.destination = destination; }
    public void setDepartureTime(String departureTime)  { this.departureTime = departureTime; }
    public void setTotalSeats(int totalSeats)            { this.totalSeats = totalSeats; }
    public void setAvailableSeats(int availableSeats)    { this.availableSeats = availableSeats; }

    public boolean isFullyBooked() {
        return availableSeats == 0;
    }
}