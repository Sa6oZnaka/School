package com.company;

public class Reindeer implements Runnable {

    private int count = 0;
    private int id;

    public Reindeer(int id) {
        this.id = id;
    }

    private void sleep(){
        System.out.println("[R] Sleeping");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("[R] Started!");
        while (true) {
            sleep();
            count++;
        }
    }
}
