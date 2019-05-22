package com.company;

public class Philosof implements Runnable {

    private final String name;

    public Philosof(String name) {
        this.name = name;
    }

    public void thinking(){
        System.out.println(name + "Is thing!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat(){
        System.out.println(name + "Is hungry!");

        left.get();
        right.get();

        System.out.println(name + "Is EATING!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(true){
            thinking();
            eat();
            sleep();
        }
    }

}
