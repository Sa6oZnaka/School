package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Flight implements org.elsys.tuesky.api.trips.Flight {
    @Override
    public String getOrigin() {
        return null;
    }

    @Override
    public String getDestination() {
        return null;
    }

    @Override
    public Duration getDuration() {
        return null;
    }

    @Override
    public TripUnit getNext() {
        return null;
    }

    @Override
    public TripUnit getPrev() {
        return null;
    }
}
