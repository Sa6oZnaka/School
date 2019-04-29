package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.planner.TripQuery;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class Trip implements org.elsys.tuesky.api.trips.Trip {

    private ArrayList<Flight> flights;
    private ArrayList<Layover> layovers;

    public Trip(ArrayList<Flight> flights, ArrayList<Layover> layovers) {
        this.flights = flights;
        this.layovers = layovers;
    }

    @Override
    public String getOrigin() {
        return flights.get(0).getOrigin();
    }

    @Override
    public String getDestination() {
        return flights.get(getFlightsCount() - 1).getDestination();
    }

    @Override
    public Duration getDuration() {
        Duration duration = getLayoverDuration();

        for (Flight flight : flights) {
            duration = duration.plus(flight.getDuration());
        }

        return duration;
    }

    @Override
    public Duration getLayoverDuration() {
        Duration duration = Duration.ofSeconds(0);

        for (Layover layover : layovers) {
            duration = duration.plus(layover.getDuration());
        }

        return duration;
    }

    @Override
    public int getFlightsCount() {
        return flights.size();
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
        return Objects.equals(flights, trip.flights) &&
                Objects.equals(layovers, trip.layovers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flights, layovers);
    }
}
