package com.company;

public class Reindeer implements Runnable{

    private int id;
    private Main contructor;

    public Reindeer(int id, Main contructor) {
        this.id = id;
        this.contructor = contructor;
    }

    @Override
    public void run() {
        System.out.println("[Reindeer] - " + id + " Created!");
        try {
            contructor.processReindeer(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }
}
