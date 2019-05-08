package org.elsys.tuesky.impl;

import org.elsys.tuesky.api.planner.TripQuery;
import org.elsys.tuesky.api.trips.Trip;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trips {

    public static TripQuery withOrigin(String origin) {
        List<Trip> trips = new ArrayList<>();
        trips = trips.stream().filter(t -> t.getOrigin().equals(origin)).collect(Collectors.toList());
        return new org.elsys.tuesky.impl.planner.TripQuery(trips);
    }

    public static TripQuery withDestination(String destination) {
        List<Trip> trips = new ArrayList<>();
        trips = trips.stream().filter(t -> t.getDuration().equals(destination)).collect(Collectors.toList());
        return new org.elsys.tuesky.impl.planner.TripQuery(trips);
    }

    public static TripQuery via(String via) {
        return null;
    }

    public static TripQuery withMaxDuration(Duration duration) {
        List<Trip> trips = new ArrayList<>();
        trips = trips.stream().filter(t -> t.getDuration().compareTo(duration) < 0).collect(Collectors.toList());
        return new org.elsys.tuesky.impl.planner.TripQuery(trips);
    }

    public static TripQuery withMaxLayoverDuration(Duration duration) {
        List<Trip> trips = new ArrayList<>();
        trips = trips.stream().filter(t -> t.getLayoverDuration().compareTo(duration) < 0).collect(Collectors.toList());
        return new org.elsys.tuesky.impl.planner.TripQuery(trips);
    }

    public static TripQuery withMaxFlights(int flights) {
        List<Trip> trips = new ArrayList<>();
        trips = trips.stream().filter(t -> t.getFlightsCount() < flights).collect(Collectors.toList());
        return new org.elsys.tuesky.impl.planner.TripQuery(trips);
    }
}
