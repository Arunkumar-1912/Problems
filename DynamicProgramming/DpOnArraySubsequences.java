package org.example.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DpOnArraySubsequences {
    public static void main(String[] args) {
        int target = 4;
        int[] arr = {1,2,3,5};
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for (int[] a : dp){
            Arrays.fill(a,-1);
        }
        int totalSum = 0;
        for(int num : arr){
            totalSum+=num;
        }
        if (totalSum %2 == 0){
            System.out.println(subsetEqualsToTarget_rec(arr,n-1,totalSum/2));
        }
        else{
            System.out.println(false);
        }
    }

    //1. Subset Sum Equals to Target
    private static boolean subsetEqualsToTarget_rec(int [] arr ,int ind, int target){

        if (target == 0){
            return true;
        }
        if (ind == 0){
            return arr[ind] == target;
        }

        boolean take = false;
        if (arr[ind]<=target){
            take = subsetEqualsToTarget_rec(arr , ind-1,target-arr[ind]);
        }
        boolean notTake = subsetEqualsToTarget_rec(arr , ind-1,target);

        return take || notTake;
    }

    private static boolean subsetEqualsToTarget_memo(int [] arr ,int ind, int target , int[][]dp){

        if (target == 0){
            return true;
        }
        if (ind == 0){
            return arr[ind] == target;
        }

        if (dp[ind][target] != -1){
            return dp[ind][target] == 0 ? false : true;
        }

        boolean take = false;
        if (arr[ind]<=target){
            take = subsetEqualsToTarget_memo(arr , ind-1,target-arr[ind],dp);
        }
        boolean notTake = subsetEqualsToTarget_memo(arr , ind-1,target,dp);

        dp[ind][target] = take || notTake ? 1 : 0;

        return take || notTake;
    }

    private static boolean subsetEqualsToTarget_tab(int [] arr ,int ind, int target){


        boolean[][] dp = new boolean[ind][target+1];

        for (int i = 0; i < ind; i++) {
            dp[i][0] = true;
        }
        if (arr[0]<=target){
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < ind; i++) {

            for (int j = 1; j <= target ; j++) {

                boolean take = false;
                if (arr[i]<=j){
                     take = dp[i-1][j-arr[i]];
                }

                boolean notTake = dp[i-1][j];

                dp[i][j] = take || notTake;
            }
        }

        return dp[ind-1][target];
    }


}
