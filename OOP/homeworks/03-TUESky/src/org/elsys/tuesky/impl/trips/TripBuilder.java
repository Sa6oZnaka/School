package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.api.trips.TripUnit;

import java.util.ArrayList;

public class TripBuilder implements org.elsys.tuesky.api.trips.TripBuilder {


    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Layover> layovers = new ArrayList<>();


    @Override
    public org.elsys.tuesky.api.trips.TripBuilder then(TripUnit nextUnit) {

        if(nextUnit instanceof Flight){

            if(flights.size() > 0){
                if(! flights.get(flights.size() - 1).getDestination().equals(((Flight) nextUnit).getOrigin())){
                    throw new RuntimeException();
                }
            }

            flights.add((Flight) nextUnit);

        }else {
            layovers.add((Layover) nextUnit);
        }

        return this;
    }

    @Override
    public Trip end() {
        return new org.elsys.tuesky.impl.trips.Trip(flights, layovers);
    }
}
