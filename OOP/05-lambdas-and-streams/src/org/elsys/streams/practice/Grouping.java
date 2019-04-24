package org.elsys.streams.practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream().collect(groupingBy(Person::getNationality));
    }

    public static Map<String, List<String>> groupNamesByNationality(List<Person> people) {
        return people.stream().
                collect(Collectors.groupingBy(Person::getNationality, Collectors.mapping(i -> i.getName(), Collectors.toList())));
    }

}
