package com.company;

import java.util.Random;

public class Reindeer extends Santa implements Runnable{

    private final int id;

    public Reindeer(int id, Main contructor) {
        super(contructor);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println("Reindeer - " + id + " Created!");

        Random random = new Random();
        while(true) {
            try {
                getConstructor().processReindeer(this);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
