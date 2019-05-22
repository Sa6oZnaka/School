package com.company;

import java.util.LinkedList;

public final class BlockingQueue<E>{

    private final int size;
    private LinkedList<E> values = new LinkedList<E>();

    public BlockingQueue(int size){
        this.size = size;
    }

    public synchronized void push(E value){
        while(values.size() == size){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        values.add(value);
        notify();
    }

    public synchronized E pop(){
        while (values.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        notifyAll();
        return values.pop();
    }


}
