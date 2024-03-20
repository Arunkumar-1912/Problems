package org.example.CustomImplementation;

import java.util.Iterator;

public class StackUsingLinkedList<T> implements Iterable<T> {

    Node top ;
    int size = 0;

    StackUsingLinkedList(){
        this.top = null;
    }

    public void push(T val){
        Node node = new Node(val);
        node.next = top;
        top = node;
        size++;
    }

    public T pop () {
        if (top == null){
            throw new IndexOutOfBoundsException("Stack is Empty!!");
        }
        T data = top.val;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return size;
    }

    public T peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack is Empty!!");
        }
        return top.val;
    }

    public boolean contains(T val){
        Node temp = top;
        while (temp != null){
            if (temp.val == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int search(T val){
        Node temp = top;
        int index = -1;
        while (temp != null){
            index++;
            if (temp.val.equals(val)){
               return size-index-1;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = top;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T val = temp.val;
                temp = temp.next;
                return val;
            }
        };
    }

    class Node{
        Node next;
        T val;

        Node(T val ){
            this.val = val;
            this.next = null;
        }
    }
}
