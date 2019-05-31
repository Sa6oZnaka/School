package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

// wait = accuire
// signal = release

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
        System.out.println("Reindeer count " + reindeerCount);

        mutex.acquire();
        reindeerCount ++;
        if (reindeerCount  >= 9){
            santaSem.release();
        }
        mutex.release();
        reindeerSem.acquire();
        getHitched ();
    }

    public void processElve() throws Exception {
        System.out.println("Elve count " + elvesCount);

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
        elvesCount  --;
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
        System.out.println("Elves Helped!");
        //elvesCount = 0;
    }

    private void prepareSleigh() {
        System.out.println("9 ELVES!!!!!");
    }

    private void getHelp(){
        // TODO
    }

    public synchronized static void main(String[] args) {
        Random random = new Random();
        Santa constructor = new Santa();

        int elve = 0;
        int reindeer = 0;

        while (true) {
            if (random.nextInt(2) == 0) {
                Reindeer r = new Reindeer(++ elve, constructor);
                new Thread(r).start();
            } else {
                Elve e = new Elve(++ reindeer, constructor);
                new Thread(e).start();
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
