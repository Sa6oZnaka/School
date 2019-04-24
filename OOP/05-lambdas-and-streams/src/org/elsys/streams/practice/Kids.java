package org.elsys.streams.practice;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Kids {

    public static Set<String> getKidNames(List<Person> people) {
        return people.stream().map(p -> p.getName()).collect(Collectors.toSet());
    }

    public static Map<String, String> getKidsAgeByName(List<Person> people) {
        return null;
        
    }

}
