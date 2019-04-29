package org.elsys.tuesky.impl;

import org.elsys.tuesky.api.planner.Planner;
import org.elsys.tuesky.api.trips.Flight;
import org.elsys.tuesky.api.trips.Layover;
import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.api.trips.TripBuilder;

import java.time.Duration;
import java.util.List;

public class Factory {

    public static TripBuilder startTrip() {
        return new org.elsys.tuesky.impl.trips.TripBuilder();
    }

    public static Flight createFlight(String from, String to, Duration duration) {
        return new org.elsys.tuesky.impl.trips.Flight(from, to, duration);
    }

    public static Layover createLayover(Duration duration) {
        return new org.elsys.tuesky.impl.trips.Layover(duration);
    }

    public static Planner createPlanner(List<Trip> trips) {
        return new org.elsys.tuesky.impl.planner.Planner(trips);
    }
}
