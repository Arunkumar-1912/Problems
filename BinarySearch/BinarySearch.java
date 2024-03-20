package org.example.BinarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        char[] letters = new char[]{'x','x','y','y'};

        System.out.println(findInInfiniteArray(arr,target));
    }

    //1 . Ceiling
    public static int searchInsert(int[] nums, int target) {

        int start = 0 ;
        int end = nums.length-1;

        while(start <= end ){
            int mid = start + (end - start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                return mid;
            }
        }
        return start;
    }
    // 2 .Floor
    public static int floorOfTarget(int[] nums, int target) {

        int start = 0 ;
        int end = nums.length-1;

        while(start <= end ){
            int mid = start + (end - start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                return mid;
            }
        }
        return end;
    }

    //3.
    public static char nextGreatestLetter(char[] letters, char target) {
        // if no letter greater than target return first letter of letters
        int start = 0;
        int end = letters.length-1;
        int targetNumber = (int) target;

        if (target > letters[end])
            return letters[0];

        while(start<=end){
            int mid = start+(end-start)/2;

            // no need to make int ..if normally compart to char it convert to ascii then only it compares so these is a no need
            int val = (int) letters[mid];
            if( val <=targetNumber){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return letters[start];
    }

    //4 . Find First and Last Position of Element in Sorted Array
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findStart(nums , target);
        ans[1] = findEnd( nums , target);

        return ans;
    }

    public static int findStart(int[] nums , int target){
        int start = 0;
        int end = nums.length-1;
        int first = -1;

        while(start <= end ){
            int mid = start + (end-start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }
            else{
                first = mid;
                end = mid-1;
            }
        }
        return first;
    }
    public static int findEnd(int[] nums , int target){
        int start = 0;
        int end = nums.length-1;
        int last = -1;

        while(start <= end ){
            int mid = start + (end-start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }
            else{
                last = mid;
                start = mid+1;
            }
        }
        return last;
    }

    public static int findInInfiniteArray(int[] nums , int target){
        int start = 0;
        int end = 1;

        while (target > nums[end]){
            int temp = end +1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return bs(nums,target,start,end);
    }
    public static int bs(int[] nums , int target , int start , int end){

        while(start <= end ){
            int mid = start + (end-start)/2;

            if(nums[mid]<target){
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


}
