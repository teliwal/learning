package org.kikala.concurrency.synchonize;

public class StaticMethod {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                StaticCounter.increment(i);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                StaticCounter.decrement(i);
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

    static class StaticCounter {
        static int cpt = 0;

        public static synchronized void increment(int val) {
            System.out.println("Je suis " + Thread.currentThread().getName() + " incremente");
            cpt += val;
        }

        public static synchronized void decrement(int val) {
            System.out.println("Je suis " + Thread.currentThread().getName() + " decremente");
            cpt -= val;
        }
    }

}
