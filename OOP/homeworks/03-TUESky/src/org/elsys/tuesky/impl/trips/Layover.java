package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Layover implements org.elsys.tuesky.api.trips.Layover {
    @Override
    public Duration getDuration() {
        return null;
    }

    @Override
    public TripUnit getNext() {
        return null;
    }

    @Override
    public TripUnit getPrev() {
        return null;
    }
}
