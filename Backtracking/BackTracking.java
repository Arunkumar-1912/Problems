package org.example.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {

    public static int mazeProblem(int n , int m){

        if (n== 1 || m == 1){
            return 1;
        }
        int right = mazeProblem(n,m-1);
        int down = mazeProblem(n-1,m);
        return right+down;
    }

    public static void printPath(String p , int n , int m){
        if (n==1 && m==1){
            System.out.println(p);
            return;
        }

        if (n>1){
            printPath(p+"D",n-1,m);
        }
        if (m>1){
            printPath(p+"R",n,m-1);
        }
    }

    public static List<String> printPathReturn(String p , int n , int m){
        if (n==1 && m==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (n>1){
            list.addAll(printPathReturn(p+"D",n-1,m));
        }
        if (m>1){
           list.addAll(printPathReturn(p+"R",n,m-1));
        }
        return list;
    }

    // assume the same question you can go horizontal , vertical and diagonal also...code below

    public static List<String> pathReturnDiagonal(String p , int n , int m){
        if (n==1 && m==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (n>1 && m>1){
            list.addAll(pathReturnDiagonal(p+"D",n-1,m-1));
        }
        if (n>1){
            list.addAll(pathReturnDiagonal(p+"V",n-1,m));
        }
        if (m>1){
            list.addAll(pathReturnDiagonal(p+"H",n,m-1));
        }
        return list;
    }

    // assume you have some restrictions like river or rock in that column so you can't go that place so now what are the ways

    // we can now try from 0 to n

    public static void pathWithRestrictions(String p ,boolean[][] maze, int row , int col){
        if (row == maze.length-1 && col==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[row][col]){
            return;
        }
        if (row < maze.length-1){
            pathWithRestrictions(p+"D",maze,row+1,col);
        }
        if (col < maze[0].length-1){
            pathWithRestrictions(p+"R",maze,row,col+1);
        }
    }

    // Real backtracking problem
    // important problem for understanding backtracking , i think

    public static void allPaths(String p ,boolean[][] maze, int row , int col){
        if (row == maze.length-1 && col==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[row][col]){
            return;
        }
        // i am considering this block in my path so marked as false
        maze[row][col] = false;

        if (row < maze.length-1){
            allPaths(p+"D",maze,row+1,col);
        }
        if (col < maze[0].length-1){
            allPaths(p+"R",maze,row,col+1);
        }
        if (col > 0){
            allPaths(p+"L",maze,row,col-1);
        }
        if (row > 0){
            allPaths(p+"U",maze,row-1,col);
        }

        // this line is where the function call will be over
        // so before the function gets removed , also remove the changes that were made by function

        maze[row][col] = true;
    }

    public static void allPathsPrintWithNumbers(String p ,boolean[][] maze, int row , int col,int[][]paths,int step){
        if (row == maze.length-1 && col==maze[0].length-1){
            paths[row][col] = step;
            for (int[]path : paths){
                System.out.println(Arrays.toString(path));
            }
            System.out.println(p);
            System.out.println();
            return;

        }
        if (!maze[row][col]){
            return;
        }
        // i am considering this block in my path so marked as false
        maze[row][col] = false;
        paths[row][col] = step;

        if (row < maze.length-1){
            allPathsPrintWithNumbers(p+"D",maze,row+1,col,paths,step+1);
        }
        if (col < maze[0].length-1){
            allPathsPrintWithNumbers(p+"R",maze,row,col+1,paths,step+1);
        }
        if (col > 0){
            allPathsPrintWithNumbers(p+"L",maze,row,col-1,paths,step+1);
        }
        if (row > 0){
            allPathsPrintWithNumbers(p+"U",maze,row-1,col,paths,step+1);
        }

        // this line is where the function call will be over
        // so before the function gets removed , also remove the changes that were made by function

        maze[row][col] = true;
        paths[row][col] = 0;
    }
}
