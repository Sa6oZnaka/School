package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.planner.TripQuery;
import org.elsys.tuesky.api.trips.Trip;

import java.util.ArrayList;
import java.util.List;

public class Planner implements org.elsys.tuesky.api.planner.Planner {


    private List<Trip> trips;

    public Planner(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public List<Trip> search(TripQuery query) {

        List<Trip> result = new ArrayList<>();
        for (Trip trip : trips) {
            if (query.matches(trip)) {
                result.add(trip);
            }
        }

        return result;
    }

    @Override
    public boolean anyMatch(TripQuery query) {
        for (Trip trip : trips) {
            if (query.matches(trip)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int count(TripQuery query) {
        int count = 0;
        for (Trip trip : trips) {
            if (query.matches(trip)) {
                count ++;
            }
        }
        return count;
    }
}
