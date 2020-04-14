package org.kikala.concurrency.basic;

public class ThreadLocalExemple {

    public static void main(String args[]) {

        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        ThreadLocal<Integer> sharedNumber = new ThreadLocal<>();

        @Override
        public void run() {
            int n = (int) (Math.random() * 100D);
            System.out.println(Thread.currentThread().getName() + " calcul " + n);
            sharedNumber.set(n);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " value " + sharedNumber.get());
        }
    }
}
