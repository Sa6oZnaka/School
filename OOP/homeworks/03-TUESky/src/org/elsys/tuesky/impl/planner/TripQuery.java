package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.impl.trips.TripBuilder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TripQuery implements org.elsys.tuesky.api.planner.TripQuery {

    private List<Trip> trips;

    public TripQuery(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean matches(Trip trip) {
        return trips.stream().anyMatch(t -> t.equals(trip));
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery and(org.elsys.tuesky.api.planner.TripQuery query) {
        return new TripQuery(trips
                .stream().filter(t -> t.matches(query))
                .collect(Collectors.toList())
        );
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery or(org.elsys.tuesky.api.planner.TripQuery query) {
        return new TripQuery(Stream
                .concat(trips.stream(), ((TripQuery) query).getTrips().stream())
                .collect(Collectors.toList())
        );
    }

    @Override
    public org.elsys.tuesky.api.planner.TripQuery not() {
        return new TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> !t.matches(this))
                .collect(Collectors.toList())
        );
    }

    private List<Trip> getTrips() {
        return trips;
    }


}
