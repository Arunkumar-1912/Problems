package org.example.MyThread;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());

        for (int i = 0; i < 3; i++) {
            System.out.println("Inside thread2 : " + i);
        }
    }
}
