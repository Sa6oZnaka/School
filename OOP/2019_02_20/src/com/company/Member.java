package com.company;

public class Member {

    private String name;

    private double subscription;

    public Member(String name, double subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public double getSubscription() {
        return subscription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubscription(double subscription) {
        this.subscription = subscription;
    }



}
