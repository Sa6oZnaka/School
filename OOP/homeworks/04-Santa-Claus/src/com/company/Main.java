package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    private int elfCount = 0;
    private int reindeerCount = 0;

    private Semaphore santaSem = new Semaphore(0);
    private Semaphore reindeerSem = new Semaphore(0);
    private Semaphore elfTex = new Semaphore(1);
    private Semaphore mutex = new Semaphore(1);

    public void processSanta() throws InterruptedException {
        santaSem.acquire();
        mutex.acquire();
        if(reindeerCount  >= 9) {
            prepareSleigh();
            reindeerSem.release(9);
            reindeerCount -= 9;
        }else if(elfCount == 3){
            helpElves();
        }
        mutex.release();
    }

    public void processReindeer(Reindeer reindeer) throws Exception{
        mutex.acquire();
        reindeerCount ++;
        if (reindeerCount  >= 9){
            santaSem.release();
        }
        mutex.release();
        reindeerSem.acquire();
        getHitched(reindeer);
    }

    public void processElf() throws Exception {
        elfTex.acquire();
        mutex.acquire();
        elfCount ++;
        if(elfCount == 3) {
            santaSem.release();
        }else {
            elfTex.release();
        }
        mutex.release();
        getHelp();
        mutex.acquire();
        elfCount --;
        if(elfCount == 0) {
            elfTex.release();
        }
        mutex.release();
    }

    private void getHitched(Reindeer reindeer) {
        System.out.println("Hitched reindeer - " + reindeer.getId());
    }

    private void helpElves() {
        System.out.println("Santa helped elves!");
    }

    private void prepareSleigh() {
        System.out.println("Santa's reindeers are ready!");
    }

    private void getHelp(){
        //System.out.println("[Elve] Need help!");
    }

    public static synchronized void main(String[] args) {
        Random random = new Random();
        Main constructor = new Main();

        int elves = 0;
        int reindeers = 0;

        Santa s = new Santa(constructor);
        new Thread(s).start();

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
