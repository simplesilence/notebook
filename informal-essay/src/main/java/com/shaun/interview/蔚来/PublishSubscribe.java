package com.shaun.interview.蔚来;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 解决生产者——消费者问题
 * 大致思路：
 *      定义一个容器（生产者消费者都锁住这个资源），一个线程生产资源，另一个线程消费资源
 */
public class PublishSubscribe {

    private LinkedList<Object> storage = new LinkedList<>();

    private int max_length = 5;

    public static void main(String[] args) {
        PublishSubscribe pubsub = new PublishSubscribe();
        pubsub.start();
    }

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    class Producer extends Thread {

        @Override
        public void run(){
            while (true){
                synchronized (storage){
                    while (storage.size() == max_length){
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    storage.add(new Object());
                    try {
                        System.out.println(Thread.currentThread().getName() + "生产了一个消息");
                        TimeUnit.SECONDS.sleep(2);
                        storage.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {

        @Override
        public void run(){
            while (true){
                synchronized (storage){
                    while (storage.size() == 0){
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    storage.removeLast();
                    try {
                        System.out.println(Thread.currentThread().getName() + "消费了一个消息");
                        TimeUnit.SECONDS.sleep(2);
                        storage.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

