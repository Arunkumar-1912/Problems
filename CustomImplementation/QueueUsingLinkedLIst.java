package org.example.CustomImplementation;

public class QueueUsingLinkedLIst<T> {

    Node front;
    Node rear;
    int size;

    QueueUsingLinkedLIst(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void insert(T item){
        Node node = new Node(item);
        if (isEmpty()){
            this.front = node;
        }
        else {
            this.rear.next = node;
        }
        this.rear = node;
    }
    public T remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is Empty !!");
        }
        T data = front.val;
        front = front.next;
        // suppose only one node is available in stack..if we delete that one node ...but rear pointing that node may be it affects memeory thats the reason why we here do rear = null; now we cut the referece between that node and and rear.
        if (front == null){
            rear = null;
        }

        return data;
    }
    public boolean isEmpty(){
        return front == null;
    }

    class Node{
        T val ;
        Node next;

        Node(T val){
            this.val = val;
            this.next = null;
        }
    }
}
