package org.elsys.streams.practice;

import java.util.List;

public class Sum {

    public static int calculate(List<Integer> people) {
        return people.stream().reduce(0, (i, j) -> i + j);
    }

}
