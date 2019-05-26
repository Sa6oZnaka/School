package com.company;

import java.util.Random;

public class Elve implements Runnable {

    private int id;
    private boolean help = false;

    public Elve(int id) {
        this.id = id;
    }

    private void sleep(){
        Random random = new Random();
        System.out.println("[E](" + id + ") is working...");
        try {
            Thread.sleep(random.nextInt(100000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {
        System.out.println("[E](" + id + ") Started!");
        while (true) {
            sleep();
            System.out.println("[E](" + id + ") Need help!");
            help = true;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean needHelp(){
        return help;
    }

    public synchronized void helped(){
        help = false;
        notify();
    }

}
