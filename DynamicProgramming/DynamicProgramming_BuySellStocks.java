package org.example.DynamicProgramming;

public class DynamicProgramming_BuySellStocks {

    public static long buySell_II(long[] prices,int n){
        long[][]dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return buySell_II_Action(0,1,prices,n);
    }
    public static long buySell_II_Action(int index,int buy ,long[] prices,int n){
        if (index == n){
            return 0;
        }
        long profit = 0;

        if (buy==1){
            profit = Math.max(-prices[index]+buySell_II_Action(index+1,0,prices,n),0+ buySell_II_Action(index + 1, 1, prices, n));
        }
        else {
            profit = Math.max(prices[index]+buySell_II_Action(index+1,1,prices,n),0+buySell_II_Action(index+1,0,prices,n));
        }
        return profit;
    }

    public static long buySell_II_Action_Opt1(int index,int buy ,long[] prices,int n,long[][]dp){
        if (index == n){
            return 0;
        }
        if (dp[index][buy] != -1){
            return dp[index][buy];
        }

        long profit = 0;

        if (buy==1){
            profit = Math.max(-prices[index]+buySell_II_Action_Opt1(index+1,0,prices,n,dp),0+ buySell_II_Action_Opt1(index + 1, 1, prices, n,dp));
        }
        else {
            profit = Math.max(prices[index]+buySell_II_Action_Opt1(index+1,1,prices,n,dp),0+buySell_II_Action_Opt1(index+1,0,prices,n,dp));
        }
        return dp[index][buy] = profit;
    }


    // tabulation completer pannala morning pannanum
    public static long buySell_II_Action_Tabulation_1(int index,int buy ,long[] prices,int n,long[][]dp){
        if (index == n){
            return 0;
        }
        if (dp[index][buy] != -1){
            return dp[index][buy];
        }

        long profit = 0;

        if (buy==1){
            profit = Math.max(-prices[index]+buySell_II_Action_Opt1(index+1,0,prices,n,dp),0+ buySell_II_Action_Opt1(index + 1, 1, prices, n,dp));
        }
        else {
            profit = Math.max(prices[index]+buySell_II_Action_Opt1(index+1,1,prices,n,dp),0+buySell_II_Action_Opt1(index+1,0,prices,n,dp));
        }
        return dp[index][buy] = profit;
    }
}
