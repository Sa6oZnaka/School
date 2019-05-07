package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.trips.Trip;

import java.util.stream.Stream;


public class TripQuery implements org.elsys.tuesky.api.planner.TripQuery {

    private Stream<Trip> stream;

    public TripQuery(Stream<Trip> stream) {
        this.stream = stream;
    }

    @Override
    public boolean matches(Trip trip) {
        return false;
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery and(org.elsys.tuesky.api.planner.TripQuery query) {
        return this;
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery or(org.elsys.tuesky.api.planner.TripQuery query) {
        return this;
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery not() {
        return null;
    }

}
