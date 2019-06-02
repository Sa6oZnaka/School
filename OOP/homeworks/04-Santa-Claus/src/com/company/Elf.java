package com.company;

public class Elf implements Runnable{

    private int id;
    private Main contructor;

    public Elf(int id, Main contructor) {
        this.id = id;
        this.contructor = contructor;
    }

    @Override
    public void run() {
        System.out.println("[Elf] - " + id + " Created!");
        try {
            contructor.processElf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
