package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.planner.TripQuery;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class Trip implements org.elsys.tuesky.api.trips.Trip {

    private String origin, destination;
    private Duration duration, layoverDuration;
    private int flightsCount;

    public Trip(String origin, String destination, Duration duration, Duration layoverDuration, int flightsCount) {
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.layoverDuration = layoverDuration;
        this.flightsCount = flightsCount;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public Duration getLayoverDuration() {
        return layoverDuration;
    }

    @Override
    public int getFlightsCount() {
        return flightsCount;
    }

    @Override
    public boolean matches(TripQuery query) {
        return query.matches(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return flightsCount == trip.flightsCount &&
                Objects.equals(origin, trip.origin) &&
                Objects.equals(destination, trip.destination) &&
                Objects.equals(duration, trip.duration) &&
                Objects.equals(layoverDuration, trip.layoverDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, duration, layoverDuration, flightsCount);
    }
}
