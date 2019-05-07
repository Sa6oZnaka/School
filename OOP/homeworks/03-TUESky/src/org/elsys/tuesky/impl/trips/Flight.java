package org.elsys.tuesky.impl.trips;

import java.time.Duration;

public class Flight implements org.elsys.tuesky.api.trips.Flight {


    private String origin, destination;
    private Duration duration;

    public Flight(String origin, String destination, Duration duration) {
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
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

}
