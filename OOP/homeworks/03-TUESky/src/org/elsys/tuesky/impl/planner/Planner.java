package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.planner.TripQuery;
import org.elsys.tuesky.api.trips.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class Planner implements org.elsys.tuesky.api.planner.Planner {


    private List<Trip> trips;

    public Planner(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public List<Trip> search(TripQuery query) {
        return trips.stream().filter(t -> t.matches(query)).collect(Collectors.toList());
    }

    @Override
    public boolean anyMatch(TripQuery query) {
        return trips.stream().anyMatch(t -> t.matches(query));
    }

    @Override
    public int count(TripQuery query) {
        return trips.stream().filter(t -> t.matches(query)).collect(Collectors.toList()).size();
    }
}
