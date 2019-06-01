package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Santa {

    private int elvesCount = 0;
    private int reindeerCount = 0;
    private Semaphore santaSem = new Semaphore(0);
    private Semaphore reindeerSem = new Semaphore(0);
    private Semaphore elfTex = new Semaphore(1);
    private Semaphore mutex = new Semaphore(1);

    public void SantaClaus() throws Exception {
        santaSem.acquire();
        mutex.acquire();
        if(reindeerCount  >= 9) {
            prepareSleigh();
            reindeerSem.release(9);
            reindeerCount -= 9;
        }else if(elvesCount == 3){
            helpElves();
        }
        mutex.release();
    }

    public void processReindeer() throws Exception{
        mutex.acquire();
        reindeerCount ++;
        if (reindeerCount  >= 9){
            santaSem.release();
        }
        mutex.release();
        reindeerSem.acquire();
        getHitched ();
    }

    public void processElf() throws Exception {
        elfTex.acquire();
        mutex.acquire();
        elvesCount ++;
        if(elvesCount  >= 3) {
            santaSem.release();
        }else {
            elfTex.release();
        }
        mutex.release();
        getHelp();
        mutex.acquire();
        elvesCount --;
        if(elvesCount  == 0) {
            elfTex.release();
        }
        mutex.release();
    }

    private void getHitched() {
        System.out.println("Hitched!");
        try {
            SantaClaus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void helpElves() {
        System.out.println("Santa helped 3 Elves!");
    }

    private void prepareSleigh() {
        System.out.println("Santa's reindeers are ready!");
    }

    private void getHelp(){
        try {
            SantaClaus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        elvesCount -= 2;
    }

    public synchronized static void main(String[] args) {
        Random random = new Random();
        Santa constructor = new Santa();

        int elves = 0;
        int reindeers = 0;

        while (true) {
            if (random.nextInt(2) == 0) {
                Reindeer r = new Reindeer(++ elves, constructor);
                new Thread(r).start();
            } else {
                Elf e = new Elf(++ reindeers, constructor);
                new Thread(e).start();
            }

            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
