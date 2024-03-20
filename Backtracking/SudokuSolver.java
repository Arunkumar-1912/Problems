package org.example.Backtracking;

public class SudokuSolver {


    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        boolean sudokuSolve = SudokuSolver.sudoku(board);

        if (sudokuSolve){
            SudokuSolver.display(board);
        }

    }

    public static boolean sudoku(int[][] board){
        int n = board.length;
        // here we didn't get any row and col from the parameter so assume row and col as -1;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j]==0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found empty element in row , then break
            if (!emptyLeft){
                break;
            }
        }
        if (emptyLeft){
            return true;
            // which mean sudoku solved
        }
        // note the things for we didn't have any row and col details so we need to iterate and find which row and col (element) will empty...the above this run for every time

        // Backtracking
        for (int number = 1; number <= 9 ; number++) {
            if (isSafe(board,row,col,number)){
                board[row][col] = number;
                if (sudoku(board)){
//                    display(board);
                    return true;
                }
                else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void display(int[][]board) {
        for (int[]arr : board){
            for (int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board , int row , int col , int number){
        for (int i = 0; i <board.length ; i++) {
            if (board[row][i] == number){
                return false;
            }
        }

        for (int i = 0; i <board.length ; i++) {
            if (board[i][col] == number){
                return false;
            }
        }

//         need to iterate the 3*3 square only
//         so fist need to find what is the fist row,col int that 3*3 square

        int sqrt = (int)Math.sqrt(board.length);
        int tempRow = row - row % sqrt;
        int tempCol = col - col % sqrt;

        for (int i = tempRow; i <tempRow+sqrt ; i++) {

            for (int j = tempCol; j < tempCol+sqrt; j++) {

                if (board[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

}
