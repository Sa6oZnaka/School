package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.planner.TripQuery;
import org.elsys.tuesky.api.trips.Trip;

import java.util.List;

public class Planner implements org.elsys.tuesky.api.planner.Planner {
    @Override
    public List<Trip> search(TripQuery query) {
        return null;
    }

    @Override
    public boolean anyMatch(TripQuery query) {
        return false;
    }

    @Override
    public int count(TripQuery query) {
        return 0;
    }
}
