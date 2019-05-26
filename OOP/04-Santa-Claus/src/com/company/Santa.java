package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Santa {

    private AtomicBoolean running = new AtomicBoolean(true);
    private ReentrantLock lock = new ReentrantLock();

    private int elveCounter = 0;
    private int reindeerCounter = 0;

    private CyclicBarrier barrier = new CyclicBarrier(3);
    private Semaphore santaSemaphore = new Semaphore(0);



    public static void main(String[] args) {

        Random random = new Random();

        List<Thread> elveThreads = new ArrayList<>();
        List<Elve> elves = new ArrayList<>();

        for(int i = 0; i < 15; i ++){
            Elve o = new Elve(i);
            elves.add(o);
            elveThreads.add(new Thread(o));
            elveThreads.get(elveThreads.size() - 1).start();
        }


        while (true) {

            int elvesNeedHelp = (int) elves.stream().filter(Elve::needHelp).count();
            System.out.println("Elves need help:" + elvesNeedHelp);

            if(elvesNeedHelp > 3){
                elves.stream().filter(Elve::needHelp).forEach(Elve::helped);
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
