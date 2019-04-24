package org.elsys.streams.practice;

import java.util.IntSummaryStatistics;
import java.util.List;

public class PeopleStats {

    public static IntSummaryStatistics getStats(List<Person> people) {

        return people.stream().mapToInt(Person::getAge).summaryStatistics();
    }

}
