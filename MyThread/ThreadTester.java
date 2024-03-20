package org.example.MyThread;

public class ThreadTester {
    public static void main(String[] args) {

        System.out.println("Main thread started");

        // 1. using Thread Class
//        Thread1 thread1 = new Thread1("thread1");

        /**  initially thread creates to user thread through the setDeamon method we an create deamon thread **/

//        thread1.setDaemon(true);

//        thread1.start();

         /*** 2.Using Runnable interface

         i) we can create thread like create class and implement interface
         ii)and other way is we can directly give a functionality of run function inside the constructor

         ***/

//        Thread thread2 = new Thread(new Thread2(),"thread2");

//        Thread thread2 = new Thread(()->{
//            System.out.println(Thread.currentThread());
//
//            for (int i = 0; i < 3; i++) {
//                System.out.println("Inside thread2 : " + i);
//            }
//        },"thread2");
//
//        thread2.start();
//
//        System.out.println("Main thread ended");


        /** Thread states --- > Thread class have Enum ...using that we can check the current state of the Thread **/

//         Thread thread3 = new Thread(()->{

//                try {
//                    Thread.sleep(1);
//                    for (int i = 1000; i > 0 ; i--);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//         },"states");
//
//         thread3.start();
//
//        while (true){
//            Thread.State state = thread3.getState();
//            System.out.println(state);
//            if (state == Thread.State.TERMINATED){
//                break;
//            }
//        }

//        Thread thread4 = new Thread(()->{
//            System.out.println(Thread.currentThread());
//        });
//        thread4.start();
//
//        try {
            /** The child thread is executing first after the child thread completed the main thread will continue to run **/
//            thread4.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Main thread Exiting");


        /** DeadLock situation creation
            when thread5 starts in acquire a lock1 and for thread6 it acquire a lock2 the both lock are acquired so in second sync no lock available
         **/
        String lock1 = "arun";
        String lock2 = "kumar";

        Thread thread5 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                      System.out.println("Lock acquired");
                  }
            }
        },lock1);


        Thread thread6 = new Thread(()->{
              synchronized (lock2){
                  try {
                      Thread.sleep(1);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  synchronized (lock1){
                      System.out.println("Lock acquired");
                  }
              }
        },lock2);

        thread5.start();
        thread6.start();
    }
}
