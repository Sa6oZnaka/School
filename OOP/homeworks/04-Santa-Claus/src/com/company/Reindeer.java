package com.company;

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
        try {
            getConstructor().processReindeer(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
