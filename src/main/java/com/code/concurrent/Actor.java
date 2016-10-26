package com.code.concurrent;

/**
 * User:甘琪 DateTime: 2016/7/26.
 */
public class Actor extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "演出开始");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出:" + (++count));

            if (count == 100)
                keepRunning = false;

            if (count % 10 == 0) {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(Thread.currentThread().getName() + "演出结束");

    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress(), "Ms.Runnable");
        actress.start();
    }
}

class Actress implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "演出开始");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出:" + (++count));

            if (count == 100)
                keepRunning = false;

            if (count % 10 == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(Thread.currentThread().getName() + "演出结束");
    }
}
