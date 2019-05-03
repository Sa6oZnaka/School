package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.trips.Trip;


public class TripQuery implements org.elsys.tuesky.api.planner.TripQuery {


    // TODO
    // no idea what i need to do :(

    private Trip trip;

    public TripQuery(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean matches(Trip trip) {
        return this.trip.equals(trip);
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery and(org.elsys.tuesky.api.planner.TripQuery query) {
        return null;
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery or(org.elsys.tuesky.api.planner.TripQuery query) {
        return null;
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery not(org.elsys.tuesky.api.planner.TripQuery query) {
        return null;
    }


}
