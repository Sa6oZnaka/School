package com.company;

public class Reindeer implements Runnable{

    private int id;
    private Santa contructor;

    public Reindeer(int id, Santa contructor) {
        this.id = id;
        this.contructor = contructor;
    }

    @Override
    public void run() {
        System.out.println("Reindeer:" + id + " Created!");
        try {
            contructor.processReindeer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
