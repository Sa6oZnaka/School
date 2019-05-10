package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.TUESkyException;
import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TripBuilder implements org.elsys.tuesky.api.trips.TripBuilder {

    private List<Flight> flights = new ArrayList<>();
    private List<Layover> layovers = new ArrayList<>();

    public static List<Trip> trips = new ArrayList<>();

    @Override
    public org.elsys.tuesky.api.trips.TripBuilder then(TripUnit nextUnit) {

        if(nextUnit instanceof Flight){
            if(flights.size() > 0){
                if(! flights.get(flights.size() - 1).getDestination().equals(((Flight) nextUnit).getOrigin())){
                    throw new TUESkyException();
                }
            }
            flights.add((Flight) nextUnit);
            return this;
        }

        layovers.add((Layover) nextUnit);
        return this;
    }

    @Override
    public Trip end() {

        int flightsCount = flights.size();
        String origin = flights.get(0).getOrigin();
        String destination = flights.get(flightsCount - 1).getDestination();
        Duration layoverDuration = layovers
                .stream()
                .map(Layover::getDuration)
                .reduce(Duration.ofSeconds(0), Duration::plus);
        Duration duration = flights.
                stream()
                .map(Flight::getDuration)
                .reduce(Duration.ofSeconds(0), Duration::plus)
                .plus(layoverDuration);

        trips.add(new org.elsys.tuesky.impl.trips.Trip(origin, destination, duration, layoverDuration, flightsCount));

        return getLast();
    }

    private Trip getLast(){
        return trips.get(trips.size() - 1);
    }

}
