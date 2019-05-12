package org.elsys.tuesky.impl;

import org.elsys.tuesky.api.planner.TripQuery;
import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.impl.trips.Flight;
import org.elsys.tuesky.impl.trips.TripBuilder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trips {

    public static TripQuery withOrigin(String origin) {
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> t.getOrigin().equals(origin))
                .collect(Collectors.toList())
        );
    }

    public static TripQuery withDestination(String destination) {
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> t.getDestination().equals(destination))
                .collect(Collectors.toList())
        );
    }

    public static TripQuery via(String via) {
<<<<<<< HEAD
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream().filter(t -> t.getFlights().stream().anyMatch(f -> f.getDestination().equals(via)))
                .collect(Collectors.toList()));
=======
        List<Trip> result = new ArrayList<>();
        for(Trip trip : TripBuilder.trips){
            if(trip.getOrigin().equals(via)){
                continue;
            }
            for(Flight flight : TripBuilder.flights){
                if(flight.getOrigin().equals(via)){
                    result.add(trip);
                }
            }

        }

        return new org.elsys.tuesky.impl.planner.TripQuery(result);
>>>>>>> f2dc647cbd3b74bc05bd7e326b800ef1180185eb
    }

    public static TripQuery withMaxDuration(Duration duration) {
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> t.getDuration().compareTo(duration) <= 0)
                .collect(Collectors.toList())
        );
    }

    public static TripQuery withMaxLayoverDuration(Duration duration) {
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> t.getLayoverDuration().compareTo(duration) <= 0)
                .collect(Collectors.toList())
        );
    }

    public static TripQuery withMaxFlights(int flights) {
        return new org.elsys.tuesky.impl.planner.TripQuery(TripBuilder.trips
                .stream()
                .filter(t -> t.getFlightsCount() <= flights)
                .collect(Collectors.toList())
        );
    }
}
