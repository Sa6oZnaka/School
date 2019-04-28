package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Flight implements org.elsys.tuesky.api.trips.Flight {


    private String origin, destination;
    private TripUnit trip;


    public Flight(String origin, String destination, TripUnit trip) {
        this.origin = origin;
        this.destination = destination;
        this.trip = trip;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public Duration getDuration() {
        return trip.getDuration();
    }

    @Override
    public TripUnit getNext() {
        return trip.getNext();
    }

    @Override
    public TripUnit getPrev() {
        return trip.getPrev();
    }
}
