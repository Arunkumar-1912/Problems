package org.example.MyThread;

public class StackForSynTesting {
    int[] data ;
    int top = -1;
    public static final int DEFAULT_SIZE = 10;

    // this lock is for locking synchronized block
    final Object lock;

    public StackForSynTesting(){
        this(DEFAULT_SIZE);
    }

    public StackForSynTesting(int size){
        data = new int[size];
        lock = new Object();
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.data.length-1;
    }

    /** if we give a some code inside synchronized block one thread can access at a time ...this is for thread safety
        suppose if we didn't to like this try to access some different threads some try to push and some try to pop in that case
        it have problem.
     **/

//    public boolean push(int val) throws Exception{
//        synchronized (lock){
//            if (isFull()){
//                throw new Exception("Stack is Full !!");
//            }
//            try {Thread.sleep(1000);}catch (Exception ignored){}
//            top++;
//            data[top] = val;
//            return true;
//        }
//
//    }
//
//    public int pop() throws Exception{
//        synchronized (lock){
//            if (isEmpty()) {
//                throw new Exception("Stack is Empty !!");
//            }
//            int val = data[top];
//            try {Thread.sleep(1000);}catch (Exception ignored){}
//            top--;
//            return val;
//        }
//    }

    /** Instead of giving like above we can mention a method as synchronized method in this case the `this` acts as lock internally

      **/

    public synchronized boolean push(int val) throws Exception{

        if (isFull()){
            throw new Exception("Stack is Full !!");
        }
        try {Thread.sleep(1000);}catch (Exception ignored){}
        top++;
        data[top] = val;
        return true;

    }

    public synchronized int pop() throws Exception{

        if (isEmpty()) {
            throw new Exception("Stack is Empty !!");
        }
        int val = data[top];
        try {Thread.sleep(1000);}catch (Exception ignored){}
        top--;
        return val;

    }

    /** for static method **/
    public static void get(int index){
        synchronized (StackForSynTesting.class){
            System.out.println("just test");
        }
    }
}
