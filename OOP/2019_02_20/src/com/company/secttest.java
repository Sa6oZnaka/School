package com.company;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class secttest {

    @Test
    public void thestGetmenber(){
        Sect secta = new Sect(new Member("Stela Stefanova", 0.0)), "Elsys"
                    Arrays.asList(new Member("Milko", 1000));
        List<Member> ordered = secta.getMemebers();

    }

    public secttest() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @BeforeEach
    void setUp() {

    }
}
