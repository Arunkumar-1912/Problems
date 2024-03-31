package org.example.SlidingWindow;

public class SlidingWindow {
    public static void main(String[] args){

//        System.out.println(maxSumSubArray(new int[]{4,2,1,7,8,1,2,8,0},3));
        System.out.println(smallestSbuArray(new int[]{4,2,1,7,8,1,2,8,0},8));
    }


    /**
      Find the maximum sum subarray of the fixed length k

      example input : [4,2,1,7,8,1,2,8,10]
     */

    public static int maxSumSubArray(int[] arr,int k){

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            if (i>=k-1){
                maxSum = Math.max(maxSum,curSum);
                curSum = curSum-(arr[i-(k-1)]);
            }
        }

        return maxSum;
    }
    /**
     find the smallest subarray size which have smallest sum great than target
     **/
    public static int smallestSbuArray(int[] arr,int target){
        int smallestSumSize = Integer.MAX_VALUE;
        int curSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            curSum += arr[windowEnd];

            while (curSum >= target){
                smallestSumSize = Math.min(smallestSumSize,windowEnd-windowStart+1);
                curSum = curSum-arr[windowStart];
                windowStart++;
            }
        }
        return smallestSumSize;
    }

}
