package com.company;

public class Santa implements Runnable{

    private Main contructor;

    public Santa(Main contructor) {
        this.contructor = contructor;
    }

    @Override
    public void run() {
        System.out.println("[Santa] Created!");
        while(true) {
            try {
                contructor.processSanta();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
