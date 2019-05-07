package org.elsys.tuesky.impl.trips;

import java.time.Duration;

public class Layover implements org.elsys.tuesky.api.trips.Layover {

    private Duration layover;

    public Layover(Duration layover) {
        this.layover = layover;
    }

    @Override
    public Duration getDuration() {
        return layover;
    }

}
