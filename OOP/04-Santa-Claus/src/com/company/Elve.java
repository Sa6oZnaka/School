package com.company;

public class Elve implements Runnable{

    private int id;
    private Santa contructor;

    public Elve(int id, Santa contructor) {
        this.id = id;
        this.contructor = contructor;
    }

    @Override
    public void run() {
        System.out.println("Elve:" + id + " Created!");
        try {
            contructor.processElve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
