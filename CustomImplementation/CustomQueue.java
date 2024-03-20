package org.example.CustomImplementation;

public class CustomQueue {

    protected int[] data ;
    int end = 0;
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }
    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is Full");
        }
        int removed =  data[0];

        // shift the elements to the left side
        for (int i = 1; i <end ; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" <-");
        }
        System.out.println("END");
    }

    public boolean isFull() {
        // here have a confusion data.length or data.length-1
        return end == data.length;
    }

    public boolean isEmpty(){
        return end == 0;
    }
}
