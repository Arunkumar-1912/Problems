package org.example.CustomImplementation;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>{
    Node head;
    Node tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }

    class Node{
        T data;
        Node next;
        Node prev;
        Node(T val){
            data = val;
            next = null;
            prev = null;
        }
    }
    DoubleLinkedList(){
        head = null;
    }

    public void insertAtBeginning(T value){
        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    public void display(){
        Node temp = head;

        if (head == null){
            System.out.println("List is Empty");
        }

        while (temp != null){
            System.out.print(temp.data +" -->");
            temp = temp.next;
        }
    }
    public void displayReverse(){
        Node temp = tail;
        if (head == null){
            System.out.println("List is Empty");
        }
        while (temp != null){
            System.out.print(temp.data +" -->");
            temp = temp.prev;
        }
    }

    public void insertAtPosition(int position,T value){

        if (position == 0){
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;

        for (int i = 1; i < position ; i++) {
            temp = temp.next;

            if (temp == null){
                System.out.println("Invalid Position");
                throw new IllegalArgumentException("Invalid Position "+position);
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteAtPosition(int position){
        if (head == null){
            throw new IndexOutOfBoundsException();
        }
        if (position == 0){
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        Node prev = null;
        for (int i = 1; i <= position; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }
    public void deleteAtBeginning(){
        head = head.next;
    }

//   try the following methods
//    get(index)
//    update(index,val)
//    deleteAtEnd()
//    insertAtEnd()
//    search(val) - return index , -1
//    contains(val);- return boolean
//    size()
}
