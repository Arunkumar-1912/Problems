package org.example.DynamicProgramming;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DPonString {
    static int prime = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        int ans = distinctSubsequences_tab(n,m,s1,s2);
        System.out.println(ans);
    }

    //0 not dynamic but printing all the common subsequences

    public static void printSubSequences(String ans , String s){
        if (s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);

        printSubSequences(ans+ch,s.substring(1));
        printSubSequences(ans,s.substring(1));
    }

    public static List<String> printSubSequencesInArray(String ans , String s){
        if (s.isEmpty()){
            System.out.println(ans);
            return Collections.singletonList(ans);
        }
        List<String> list = new ArrayList<>();
        char ch = s.charAt(0);

        list.addAll(printSubSequencesInArray(ans + ch, s.substring(1)));
        list.addAll(printSubSequencesInArray(ans, s.substring(1)));

        return list;
    }

    // 1 .Longest common subsequences
    public static int longestCommonSubsequence(int ind1 , int ind2 , String s1 , String s2){

        if (ind1 < 0 || ind2 <0){
            return 0;
        }

        // Match
        if (s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + longestCommonSubsequence(ind1-1,ind2-1,s1,s2);
        }
        // Not Match
        else {
            return Math.max(longestCommonSubsequence(ind1 - 1, ind2, s1, s2), longestCommonSubsequence(ind1, ind2 - 1, s1, s2));
        }
    }

    public static int longestCommonSubsequence_memo(int ind1 , int ind2 , String s1 , String s2,int[][]dp){

        if (ind1 < 0 || ind2 <0){
            return 0;
        }
        if (dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        // Match
        if (s1.charAt(ind1) == s2.charAt(ind2)){
            dp[ind1][ind2] =  1 + longestCommonSubsequence(ind1-1,ind2-1,s1,s2);
        }
        // Not Match
        else {
            dp[ind1][ind2] =  Math.max(longestCommonSubsequence(ind1 - 1, ind2, s1, s2), longestCommonSubsequence(ind1, ind2 - 1, s1, s2));
        }
        return dp[ind1][ind2];
    }

    // Distinct Subsequences

    public static int distinctSubsequences_rec(int n , int m , String s1 , String s2){

        if (m<0){
            return 1;
        }

        if (n<0){
            return 0;
        }

        if (s1.charAt(n) == s2.charAt(m)){
            return distinctSubsequences_rec(n-1,m-1,s1,s2) + distinctSubsequences_rec(n-1,m,s1,s2);
        }
        else {
            return distinctSubsequences_rec(n-1,m,s1,s2) ;
        }
    }

    public static int distinctSubsequences_rec_memo(int n , int m , String s1 , String s2,int[][]dp){

        if (m<0){
            return 1;
        }

        if (n<0){
            return 0;
        }

        if (dp[n][m] != -1){
            return dp[n][m];
        }

        if (s1.charAt(n) == s2.charAt(m)){
            int pick = distinctSubsequences_rec_memo(n-1,m-1,s1,s2,dp);
            int notPick = distinctSubsequences_rec_memo(n-1,m,s1,s2,dp);

            //Since the answer can be very large, print it modulo 10 ^ 9 + 7.
            return dp[n][m] = (pick+notPick)%prime;
        }
        else {
            return dp[n][m] = distinctSubsequences_rec_memo(n-1,m,s1,s2,dp) ;
        }
    }

    public static int distinctSubsequences_tab(int n, int m, String s1, String s2) {
        int prime = (int) (1e9 + 7); // Define prime modulo value

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int pick = dp[i - 1][j - 1];
                    int notPick = dp[i - 1][j];

                    dp[i][j] = (pick + notPick)%prime ;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    static int subsequenceCounting(String s1, String s2, int n, int m) {

        int dp[][] = new int[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m ; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int pick = dp[i - 1][j - 1];
                    int notPick = dp[i - 1][j];

                    dp[i][j] = (pick + notPick)%prime ;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }


}
