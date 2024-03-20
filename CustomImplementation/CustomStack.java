package org.example.CustomImplementation;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack (){
        // here this line calls the constructor
        // this keyword id used for refernce the object and call the constructor
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is Full !! .");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Cannot pop from an Empty stack!!");
        }
        // here if we push one element we increase ptr value which mean ptr indicated the last value thats why here remove that element
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Cannot Peek from an Empty stack!!");
        }
        return data[ptr];
    }

    private boolean isFull() {
        return ptr == data.length-1;
    }
    private boolean isEmpty(){
        return ptr == -1;
    }
}
