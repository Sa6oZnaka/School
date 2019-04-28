package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.planner.TripQuery;

import java.time.Duration;
import java.util.ArrayList;

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
        Duration duration = Duration.ofSeconds(0);

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
        return false;
    }

}
