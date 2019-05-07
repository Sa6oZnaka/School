package org.elsys.tuesky.impl.planner;

import org.elsys.tuesky.api.trips.Trip;
import org.elsys.tuesky.impl.Factory;
import org.elsys.tuesky.impl.Trips;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlannerTest {

    @Test
    public void searchAdvancedTest() {

        List<Trip> trips = new ArrayList<>();

        trips.add(Factory.startTrip()
                .then(Factory.createFlight("Sofia", "Athens", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(90)))
                .then(Factory.createFlight("Athens", "Xania", Duration.ofHours(1)))
                .end());

        trips.add(Factory.startTrip()
                .then(Factory.createFlight("North Makedonia", "North Korea", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(90)))
                .then(Factory.createFlight("North Korea", "Xania", Duration.ofHours(1)))
                .end());

        Planner p = new Planner(trips);
        assertEquals(p.search(Trips.withOrigin("North Makedonia")), trips.get(1));

    }

    @Test
    public void searchSimpleTest() {

        List<Trip> trips = new ArrayList<>();

        trips.add(Factory.startTrip()
                .then(Factory.createFlight("Sofia", "Athens", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(90)))
                .then(Factory.createFlight("Athens", "Xania", Duration.ofHours(1)))
                .end());

        trips.add(Factory.startTrip()
                .then(Factory.createFlight("North Makedonia", "North Korea", Duration.ofHours(1)))
                .then(Factory.createLayover(Duration.ofMinutes(90)))
                .then(Factory.createFlight("North Korea", "Xania", Duration.ofHours(1)))
                .end());

        List<Trip> expedcted = new ArrayList<>();
        expedcted.add(trips.get(1));

        Planner p = new Planner(trips);
        List<Trip> tripsList = new ArrayList<>();
        tripsList.add(trips.get(1));
        assertEquals(p.search(new TripQuery(tripsList)), expedcted);

    }







}
