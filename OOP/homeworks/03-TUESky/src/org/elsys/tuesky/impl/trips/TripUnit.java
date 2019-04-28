package org.elsys.tuesky.impl.trips;

import java.time.Duration;

public class TripUnit implements org.elsys.tuesky.api.trips.TripUnit {

    private Duration duration;
    private TripUnit prev, next;

    public TripUnit(Duration duration, TripUnit prev, TripUnit next) {
        this.duration = duration;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public org.elsys.tuesky.api.trips.TripUnit getNext() {
        return next;
    }

    @Override
    public org.elsys.tuesky.api.trips.TripUnit getPrev() {
        return prev;
    }
}
