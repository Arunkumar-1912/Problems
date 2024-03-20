package org.example.MyThread;

public class Thread1 extends Thread{

    public Thread1(String threadName){
        super(threadName);
    }

    @Override
    public void run(){
//        Thread.currentThread() ---> Thread[thread1,5,main] --> threadName , parity , parentThread
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside thread1 : "+i);
        }
    }
}
