package org.example.DynamicProgramming;

import java.util.Arrays;

public class DynamicProgramming{
    public static void main(String[] args) {
        String s = "06";
        int n = s.length();
        System.out.println(rec(n-1,s,0));
    }

    public static int start(int n){

        int[] arr = new int[]{2,7,9,3,1};
        int m = arr.length-1;
        int[] dp = new int[m+1];
        Arrays.fill(dp,-1);
        return houseRobber_tab(arr,m,dp);
    }
    // TOPIC - ID relations

    // 1.Fibonacci problem

    private static int fib_rec(int n){

        if (n==0 || n==1){
            return n;
        }

        return fib_rec(n-1)+fib_rec(n-2);
    }
    private static int fib_memo(int n ,int[]dp){
        if (n==0 || n==1){
            return n;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        dp[n] = fib_memo(n-1,dp)+fib_memo(n-2,dp);
        return dp[n];
    }
    private static int fib_tab(int n){
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
            System.out.println(prev2);
        }
        return prev1;
    }


    //2.Climbing stairs
    private static int stairCase_rec(int n){
        if (n<=2){
            return n;
        }
        return stairCase_rec(n-1)+stairCase_rec(n-2);
    }

    private static int stairCase_Memo(int n , int[] dp){
        if (n<=2){
            return n;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        dp[n] = stairCase_Memo(n-1,dp)+stairCase_Memo(n-2,dp);
        return dp[n];
    }

    private static int stairCase_tab(int n){
        int prev1 = 2;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    // acutally fibonacci and staircase 2um same type of problem than like nth value enna varum apdi..oru difference than inth
    // maathri problem ku irukkum nu nenaikran like base case mattum maarum ...so ipdi problem vantha pattern find panni base eluthitta solve pannidalam.



    //3.Frog jump -- not in leetcode , in codingninjas

    private static int frogJump_rec(int[]arr,int n){
        if (n==0){
            return 0;
        }

        // Math.abs(arr[n]-arr[n-1]) inth part ethukkaga nu confusion vantha konjam staircase problem ah refer panna anga ithellam pannirka mattom becase munnadi irukka 2 number kaana steps la min than athoda ans
        // but intha munnadi n-1 ans and n-1 la irunthu n varathukku evlo enary theva paduthunu theiyanum la so athukkaga than antha line

        int left = frogJump_rec(arr,n-1) + Math.abs(arr[n]-arr[n-1]);
        int right = Integer.MAX_VALUE;
        if (n>=2){
             right = frogJump_rec(arr,n-2) + Math.abs(arr[n] - arr[n-2]);
        }
        return Math.min(left,right);
    }

    // recursion tree la same sub problem overlapping aagirntha naama memo method la pannalam right.
    private static int frogJump_Memo(int[] arr , int n , int[] dp){
        if (n==0){
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int left = frogJump_rec(arr,n-1) + Math.abs(arr[n]-arr[n-1]);
        int right = Integer.MAX_VALUE;
        if (n>=2){
            right = frogJump_rec(arr,n-2) + Math.abs(arr[n] - arr[n-2]);
        }
        return Math.min(left,right);
    }

    private static int frogJump_Tab(int[] arr , int n , int[] dp){
        dp[0] = 0;

        for (int i = 1; i < n ; i++) {

            int left = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;
            if (i>=2){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }

            dp[i] = Math.min(left,right);
        }
        return dp[n-1];

    }

    private static int frogJump_reduce_space(int[] arr , int n){
        int prev2 = 0;
        int prev = 0;

        for (int i = 1; i < n ; i++) {
            int left = prev + Math.abs(arr[i-1]-arr[i]);
            int right = Integer.MAX_VALUE;
            if(i>=2){
                right = prev2 + Math.abs(arr[i-2]-arr[i]);
            }
            int cur = Math.min(left,right);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    // 4.Frog jump -2 -----> instead of jump 1 or 2 ...now the frog can jum k jumps if k = 4 --> it can jump 1 or 2 or or 4
    // it is code ninja solution we can refer in code ninja..i solved it using memo method ..can try

//    import java.util.Arrays;
//
//    public class Solution {
//        public static int minimizeCost(int n, int k, int[] height) {
//            // Base case: if n is 0 (start), the cost is 0.
//            int[] dp = new int[n+1];
//            Arrays.fill(dp, -1);
//
//            return minCost(n-1,k,height,dp);
//        }
//
//        public static int minCost(int n, int k, int[] height,int[]dp) {
//            if (n == 0) {
//                return 0;
//            }
//            if(dp[n] != -1){
//                return dp[n];
//            }
//            // Initialize the cost to maximum value.
//            int cost = Integer.MAX_VALUE;
//
//            // Loop through the steps from 1 to k.
//            for (int i = 1; i <= k; i++) {
//                // Calculate the index for the previous step.
//                int prevIndex = n - i;
//
//                // Check if the previous index is within bounds.
//                if (prevIndex >= 0) {
//                    // Calculate the cost for the current step and update the minimum cost.
//                    int temp = minCost(prevIndex, k, height,dp) + Math.abs(height[n] - height[prevIndex]);
//                    cost = Math.min(cost, temp);
//                }
//            }
//
//            // Return the minimum cost.
//            dp[n] = cost;
//            return dp[n];
//        }
//    }

    // HERE HAVE TABULATION APPROACH

//    public static int minCost(int n, int k, int[] height,int[]dp) {
//        dp[0] = 0;
//
//
//        // Loop through the steps from 1 to k.
//        for(int i = 1 ; i<=n ; i++){
//
//            // Initialize the cost to maximum value.
//            int cost = Integer.MAX_VALUE;
//
//            for (int j = 1; j <= k; j++) {
//                // Calculate the index for the previous step.
//                int prevIndex = i - j;
//
//                // Check if the previous index is within bounds.
//                if (prevIndex >= 0) {
//                    // Calculate the cost for the current step and update the minimum cost.
//                    int temp = dp[prevIndex] + Math.abs(height[i] - height[prevIndex]);
//                    cost = Math.min(cost, temp);
//                }
//            }
//            dp[i] = cost;
//        }
//
//        return dp[n];
//    }


    // 5. House robber or Maximum sum of non adjacent elements

    public static int houseRobber_rec(int [] arr,int index){

        if(index == 0){
            return arr[index];
        }
        if (index < 0){
            return 0;
        }

        int pick = arr[index]+houseRobber_rec(arr,index-2);
        int notPick = 0 + houseRobber_rec(arr,index-1);

        return Math.max(pick,notPick);
    }

    public static int houseRobber_memo(int[] arr , int index,int[] dp){
        if(index == 0){
            return arr[index];
        }
        if (index < 0){
            return 0;
        }
        if (dp[index] != -1){
            return dp[index];
        }

        int pick = arr[index]+houseRobber_rec(arr,index-2);
        int notPick = 0 + houseRobber_rec(arr,index-1);

        dp[index] =  Math.max(pick,notPick);

        return dp[index];
    }

    public static int houseRobber_tab(int[] arr , int index,int[] dp){
        // base case modify

        dp[0] = arr[0];

        for (int i = 1; i <= index; i++) {

            int pick;
            if (i-2 >= 0){
                pick = arr[i]+dp[i-2];
            }
            else {
                pick = arr[i]+0;
            }
            int notPick = 0 + dp[i-1];

            dp[i] =  Math.max(pick,notPick);
        }

        return dp[index];
    }

    // free ah irukkapo space optimization try pannalam for the above problem;


    // 6.HOUSE ROB -II

    public static int houseRobberII_rec(int [] arr,int index){

        if(index == 0){
            return arr[index];
        }
        if (index < 0){
            return 0;
        }

        int pick = arr[index]+houseRobberII_rec(arr,index-2);
        int notPick = 0 + houseRobberII_rec(arr,index-1);

        return Math.max(pick,notPick);
    }

    //[
    // [true, true, false, false, false, false],
    // [true, true, false, false, true, true],
    // [true, true, false, false, true, true],
    // [true, true, false, false, true, true]]0



    // code word

    public static int  rec(int index , String s,int sum){

        if(index<0){
            return 0;
        }

        int c = s.charAt(index)-'0';

        int take = 0;
        if( (c==0 && sum ==0) || (c!= 0 && c+sum <= 26) ){
            take = 1 + rec(index-1,s,0);
        }

        int notTake = rec(index-1,s,sum+(c*10));

        return take+notTake;
    }
}
