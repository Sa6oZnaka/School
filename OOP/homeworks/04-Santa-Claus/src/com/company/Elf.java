package com.company;

public class Elf extends Santa implements Runnable{

    private final int id;

    public Elf(int id, Main contructor) {
        super(contructor);
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Elf - " + id + " Created!");
        try {
            getConstructor().processElf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
