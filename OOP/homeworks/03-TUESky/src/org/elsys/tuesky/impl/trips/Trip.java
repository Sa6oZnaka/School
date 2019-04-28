package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.planner.TripQuery;

import java.time.Duration;

public class Trip implements org.elsys.tuesky.api.trips.Trip {

    private String origin;


    @Override
    public String getOrigin() {
        return origin;
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
    public Duration getLayoverDuration() {
        return null;
    }

    @Override
    public int getFlightsCount() {
        return 0;
    }

    @Override
    public boolean matches(TripQuery query) {
        return false;
    }
}
