package org.kikala.concurrency.synchonize;

public class InstanceMethod {

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

        public synchronized void increment(int val) {
            System.out.println("Je suis " + Thread.currentThread().getName() + " incremente");
            this.cpt += val;
        }

        public synchronized void decrement(int val) {
            System.out.println("Je suis " + Thread.currentThread().getName() + " decremente");
            this.cpt -= val;
        }
    }

}
