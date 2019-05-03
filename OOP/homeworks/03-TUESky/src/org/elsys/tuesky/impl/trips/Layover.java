package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Layover implements org.elsys.tuesky.api.trips.Layover {

    private Duration layover;
    private TripUnit next, prev;

    public Layover(Duration layover) {
        this.layover = layover;
    }

    @Override
    public Duration getDuration() {
        return layover;
    }

    @Override
    public TripUnit getNext() {
        return next;
    }

    @Override
    public TripUnit getPrev() {
        return prev;
    }
}
