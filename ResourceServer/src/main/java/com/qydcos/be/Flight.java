package com.qydcos.be;

/**
 * Created by renjun on 8/24/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Domain object for tracking flights
 *
 * @author Craig Walls
 * @author Greg Turnquist
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String origin;

    private String destination;

    private String airline;

    private String flightNumber;

    private Date date;

    private String traveler;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTraveler() {
        return this.traveler;
    }

    public void setTraveler(String traveler) {
        this.traveler = traveler;
    }

}