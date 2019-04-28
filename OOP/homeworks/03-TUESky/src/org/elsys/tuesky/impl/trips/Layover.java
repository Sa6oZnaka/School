package org.elsys.tuesky.impl.trips;

import org.elsys.tuesky.api.trips.TripUnit;

import java.time.Duration;

public class Layover implements org.elsys.tuesky.api.trips.Layover {

    private TripUnit layover;

    public Layover(TripUnit layover) {
        this.layover = layover;
    }

    @Override
    public Duration getDuration() {
        return layover.getDuration();
    }

    @Override
    public TripUnit getNext() {
        return layover.getNext();
    }

    @Override
    public TripUnit getPrev() {
        return layover.getPrev();
    }
}
