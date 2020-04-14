package org.kikala.concurrency.synchonize;

public class InstanceMethodBlock {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment(i);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                counter.decrement(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    static class Counter {
        int cpt = 0;

        public void increment(int val) {
            synchronized (this) {
                System.out.println("Je suis " + Thread.currentThread().getName() + " incremente");
                this.cpt += val;
            }
        }

        public void decrement(int val) {
            synchronized (this) {
                System.out.println("Je suis " + Thread.currentThread().getName() + " decremente");
                this.cpt -= val;
            }
        }
    }

}
