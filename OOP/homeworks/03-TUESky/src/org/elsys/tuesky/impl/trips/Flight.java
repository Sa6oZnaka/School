package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Flight implements org.elsys.tuesky.api.trips.Flight {


    private String origin, destination;
    private Duration duration;
    private TripUnit next, prev;

    public Flight(String origin, String destination, Duration duration) {
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public void setNext(TripUnit next) {
        this.next = next;
    }

    public void setPrev(TripUnit prev) {
        this.prev = prev;
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
        return duration;
    }

    @Override
    public TripUnit getNext() {
        return next;
    }

    @Override
    public TripUnit getPrev() {
        return prev;
    }
}
