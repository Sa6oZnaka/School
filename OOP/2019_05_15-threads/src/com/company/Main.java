package com.company;

public class Main {

    public static void main(String[] args) {

        //System.out.println("Block Queue");

        BlockingQueue<Integer> queue = new BlockingQueue<>(10);
        new Thread(() -> {
            for(int i=0; i < 100;i ++){
                queue.push(i);
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(queue.pop());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
