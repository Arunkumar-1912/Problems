package org.example.CustomImplementation;

public class BinaryTree {

    Node root;

    class Node{
        int data;
        Node right,left;

        Node(int value){
            data = value;
            right = null;
            left = null;
        }
    }

    BinaryTree(int val){
        root = new Node(val);
    }

    public void insertLeft(Node r , int val){
        Node newNode = new Node(val);
        r.left = newNode;
    }

    public void insertRight(Node r , int val){
        Node newNode = new Node(val);
        r.right = newNode;
    }

    public static void preOrder(Node root){
        if (root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root){
        if (root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public Node delete(Node root , int val){
        if (root == null){
            return root;
        }
        if (val < root.data){
            root.left = delete(root.left,val);
        } else if (val>root.data) {
            root.right = delete(root.right,val);
        }
        else {
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            root.data = min(root.right);
            root.right = delete(root.right,root.data);
        }
        return root;
    }
    public int min(Node root){
        int minVal = root.data;

        while (root.left != null){
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

}
