package com.company;

import java.util.Random;

public class Elf extends Santa implements Runnable{

    private final int id;

    public Elf(int id, Main contructor) {
        super(contructor);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println("Elf - " + id + " Created!");

        Random random = new Random();
        while(true) {
            try {
                getConstructor().processElf(this);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
