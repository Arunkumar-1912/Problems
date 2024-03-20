package org.example.MyThread;

import org.example.CustomImplementation.CustomQueue;

public class BlockingQueue {

    /** i just try to use my custom queue implementation ....we can go with java Queue **/

    CustomQueue queue ;
    private int capacity;

    public BlockingQueue(int capacity){
        this.queue = new CustomQueue(capacity);
        this.capacity = capacity;
    }

    public boolean add(int val){
        synchronized (queue){
            /** normally here we using just if condition right ....but assume thread1 have in wait state and thread 2 also have in wait state so can we can have a chance to lot of thread in wait state so after one notify all it again need to check the condtion**/
            while (queue.isFull()){
                try {
                    /** if there is no space to add a value this thread will wait until it get any notification(here in remove method we will notify if any item will removed) then **/
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.insert(val);
            /** This method notify all the threads which are in wait() state **/
            queue.notifyAll();
            return true;
        }
    }
    public int remove() throws Exception {
        /** in this object we use queue as a lock **/
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }
            int val = queue.remove();
            queue.notify();
            return val;
        }
    }
}
