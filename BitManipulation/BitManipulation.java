package org.example.BitManipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int[] arr = {2,3,5,2,5,6,6};
        System.out.println("The Unique element is : " + findNonDuplicate(arr));
    }
    public static boolean isOdd(int n){
        return (n&1) == 1 ;
    }
    public static int findNonDuplicate(int[] arr){
        int unique = 0;

        for (int i : arr){
            unique ^= i;
        }
        return unique;
    }
}
