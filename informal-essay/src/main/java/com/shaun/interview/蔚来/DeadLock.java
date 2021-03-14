package com.shaun.interview.蔚来;

/**
 * 用Java编写一个会导致死锁的程序
 * 下面是网上的例子，感觉略微麻烦
 */
public class DeadLock {

    public static void main(String[] args) {
//        DeadLockThread deadlock1 = new DeadLockThread();
//        DeadLockThread deadlock2 = new DeadLockThread();
//        deadlock1.flag = true;
//        deadlock2.flag = false;
//        new Thread(deadlock1).start();
//        new Thread(deadlock2).start();

        deadLockTest();
    }


    /**
     * 自己实现的版本
     */
    public static void deadLockTest(){
        // 给定两个资源
        Object a = new Object();
        Object b = new Object();

        // 第一个线程先拿到a资源，然后睡两秒，再去获取b资源
        new Thread(() -> {

            synchronized (a) {
                System.out.println(Thread.currentThread().getName()+"get a resource.");
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName()+"get b resource.");
                }
            }
        }).start();

        // 第二个线程先拿到b资源，然后睡两秒，再去获取a资源
        new Thread(() -> {

            synchronized (b) {
                System.out.println(Thread.currentThread().getName()+"get b resource.");
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName()+"get a resource.");
                }
            }
        }).start();
    }
}

class DeadLockThread implements Runnable{

    private static final Object objectA = new Object();
    private static final Object objectB = new Object();
    public boolean flag;

    @Override
    public void run() {
        if (flag) {
            synchronized (objectA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag=true && lock objectA");
                synchronized (objectB) {
                    System.out.println("flag=true && lock objectB");
                }
            }
        } else {
            synchronized (objectB) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag=false && lock objectB");
                synchronized (objectA) {
                    System.out.println("flag=false && lock objectA");
                }
            }
        }
    }
}