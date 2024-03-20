package org.example.CustomImplementation;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int first = 0;
    int end = 0;
    int size;

    CircularQueue(){
        this(DEFAULT_SIZE);
    }
    CircularQueue(int size){
        data = new int[size];
    }

    public boolean add(int item){
        if (isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Circular Queue is Empty");
        }
        int removed = data[first++];
        first = first % data.length;
        size--;
        return removed;
    }

    public int getFirst() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[first];
    }

    public void display(){
        // normal for loop pottu ellathaiyum print panna try pannom na if sometimes first and end = 0 irukka chances irukku like array full add pannita ipdi than irukkum antha time la keela irukka loop ah run panna ethume print aagatuh
//        for (int i = first; i <end ; i++) {
//            System.out.print(data[i] +" ");
//        }
        if (isEmpty()){
            return;
        }
        int i = first;
        do {
            System.out.print(data[i]+" ");
            i++;
            i = i%data.length;
        }
        while (i !=end );

        System.out.print("END");

    }

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
