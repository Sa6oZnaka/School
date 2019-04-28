package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.api.trips.TripUnit;

public class TripBuilder implements org.elsys.tuesky.api.trips.TripBuilder {


    private Trip trip;


    @Override
    public org.elsys.tuesky.api.trips.TripBuilder then(TripUnit nextUnit) {

        return this;
    }

    @Override
    public Trip end() {
        return trip;
    }
}
