package org.kikala.concurrency.basic;

public class SimpleThread {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        Thread threadRunnable = new Thread(new MyRunnable());
        threadRunnable.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("inside a thread");
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a big runnble");
        }
    }
}
