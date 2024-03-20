package org.example.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensBackTracking {
    public static void main(String[] args) {
        System.out.println(practice(4));
    }
    public static int queens(boolean[][] board , int row){

        if (row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board[0].length; col++) {

            if (isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

static boolean isSafe(boolean[][] board, int row, int col){

    //for vertical
    for (int i = row ; i>=0 ; i--) {

        if (board[i][col]){
            return false;
        }
    }

    // for left diagonal
    int i = row;
    int j = col;
    while (i>=0 && j>=0){
        if (board[i][j]){
            return false;
        }
        i--;
        j--;
    }

    // for right diagonal
    int k = row;
    int l = col;
    while (k>=0 && l<board[0].length){
        if (board[k][l]){ // Corrected from board[i][j]
            return false;
        }
        k--;
        l++;
    }
    return true;
}
//
//    static boolean isSafe(boolean[][] board, int row, int col) {
//        // Check for vertical conflicts
//        for (int i = row; i >= 0; i--) {
//            if (board[i][col]) {
//                return false;
//            }
//        }
//
//        // Check for left diagonal conflicts
//        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j]) {
//                return false;
//            }
//        }
//
//        // Check for right diagonal conflicts
//        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
//            if (board[i][j]) {
//                return false;
//            }
//        }
//
//        return true;
//    }


    // here we can do iteration fist bool[] and next iteration can get element which is from that bool[]...that also fine

    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    private void display1(boolean[][] board){
        List<String> ans = new ArrayList<>();
        for(boolean[] arr : board){
            StringBuilder builder = new StringBuilder();
            for(boolean element : arr){
                if(element){
                    builder.append("Q");
                }
                else{
                    builder.append(".");
                }
            }
            ans.add(board.toString());
        }
    }

    // try after some days
    public static int practice(int n){
        boolean[][] board = new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                board[i][j] = false;
            }
        }
        return qAction(board,0);
    }

    private static int qAction(boolean[][] board , int row ) {

        if (row == board.length){
            return 1;
        }

        int count = 0;
        for (int col = 0; col <board[0].length ; col++) {
            boolean isSafe = queenSafeCheck(row,col,board);
            if (isSafe){
                board[row][col] = true;
                count += qAction(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean queenSafeCheck(int row, int col, boolean[][] board) {

        // 1. check -- vertical
        // note in this case column is constant so we need one loop

        for (int i = row; i>=0 ; i--) {
            if (board[i][col]){
                return false;
            }
        }

        // 2. check - left diagonal
        // here column is not constant every time we change row and column then only check if that cell is safe or not so need while loop right?
        int i=row;
        int j=col;

        while (i>=0 && j>=0){
            if (board[i][j]){
                return false;
            }
            i--;
            j--;
        }

        int k=row;
        int l = col;

        while (k>=0 && l< board.length){
            if (board[k][l]){
                return false;
            }
            k--;
            l++;
        }
        return true;
    }

}
