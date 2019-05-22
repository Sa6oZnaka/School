package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        String[] names = {"Socrat", "Plato", "Astra", "Denis", "Mincho"};

        List<Fork> forks = IntStream.range(0, names.length).mapToObj(t -> new Fork()).collect(Collectors.toList());

        List<Philosof> philosofi = IntStream.range(0, names.length)
                .mapToObj(i -> new Philosof(names[i], forks.get(i), ))
                .map(Thread::new)
                .collect(Collectors.toList());


    }
}
