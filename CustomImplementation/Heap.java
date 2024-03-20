package org.example.CustomImplementation;

import java.util.ArrayList;

public class Heap <T extends Comparable<T>>{

    private ArrayList<T> list;

    public Heap(){
       list = new ArrayList<>();
    }

    public void insert(T value){
        list.add(value);
        upHead(list.size()-1);
    }

    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("Can't remove element from an Empty Heap");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);

        if (!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }

    private void swap(int first , int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    private void upHead(int index) {
        if (index == 0){
            return;
        }
        int parent = getParent(index);
        if (list.get(index).compareTo(list.get(parent))<0){
            swap(index,parent);
            upHead(parent);
        }
    }
    private void downHeap(int index){
        int min = index;
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        // this compareTo return 1 0 -1 based on the condition if explore we know
        if (leftChild < list.size() && list.get(min).compareTo(list.get(leftChild)) > 0){
            min = leftChild;
        }

        if (rightChild < list.size() && list.get(min).compareTo(list.get(rightChild)) > 0){
            min = rightChild;
        }
        if (min != index){
            swap(min,index);
            downHeap(min);
        }
    }


    private int getParent(int child){
        return (child-1)/2;
    }

    private int getLeftChild(int parent){
        return parent*2+1;
    }

    private int getRightChild(int parent){
        return parent*2+2;
    }

}
