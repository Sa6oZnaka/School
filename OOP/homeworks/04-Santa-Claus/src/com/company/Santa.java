package com.company;

public class Santa implements Runnable{

    private final Main constructor;

    public Santa(Main constructor) {
        this.constructor = constructor;
    }

    public Main getConstructor() {
        return constructor;
    }

    @Override
    public void run() {
        System.out.println("Santa Created!");
        while(true) {
            try {
                getConstructor().processSanta();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
