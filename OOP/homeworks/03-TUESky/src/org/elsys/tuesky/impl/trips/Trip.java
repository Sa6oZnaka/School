package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.planner.TripQuery;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Trip implements org.elsys.tuesky.api.trips.Trip {

    private List<Flight> flights;
    private List<Layover> layovers;

    public Trip(List<Flight> flights, List<Layover> layovers) {
        this.flights = flights;
        this.layovers = layovers;
    }

    @Override
    public String getOrigin() {
        return flights.get(0).getOrigin();
    }

    @Override
    public String getDestination() {
        return flights.get(flights.size() - 1).getDestination();
    }

    @Override
    public Duration getDuration() {
        return flights.
                stream()
                .map(Flight::getDuration)
                .reduce(Duration.ofSeconds(0), Duration::plus)
                .plus(getLayoverDuration());
    }

    @Override
    public Duration getLayoverDuration() {
        return layovers
                .stream()
                .map(Layover::getDuration)
                .reduce(Duration.ofSeconds(0), Duration::plus);

    }

    @Override
    public int getFlightsCount() {
        return flights.size();
    }

    @Override
    public boolean matches(TripQuery query) {
        return query.matches(this);
    }

    public List<Flight> getFlights() {
        return flights;
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
