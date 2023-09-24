package com.hs.sudokuone.util;


public class CheckIsSafe {

    public static int NUM = 9;

    public static int check[];

    public static boolean checkSafe(int[][] sudoku,int row,int col,int n) {
        check = new int[10];
        for(int i = 0;i<NUM;i++) {
            check[sudoku[row][i]]++;
            if(sudoku[row][i] == n)
                return false;
            if (check[sudoku[row][i]]>1 && sudoku[row][i] != 0)
                return false;
        }
        check = new int[10];
        for(int i = 0;i<NUM;i++) {
            if(sudoku[i][col] == n)
                return false;
            if (check[sudoku[row][i]]>1 && sudoku[row][i] != 0)
                return false;
        }

        return checkBlock(sudoku, row, col, n);
    }

    public static boolean checkBlock(int[][] sudoku, int row, int col, int n) {
        check = new int[10];
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                if(sudoku[i+startRow][j+startCol] == n) {
                    return false;
                }
                if (check[sudoku[row][i]]>1 && sudoku[row][i] != 0)
                    return false;
            }
        }
        return true;
    }
}