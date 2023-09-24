package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.service.SolveService;
import com.hs.sudokuone.util.CheckIsSafe;
import org.springframework.stereotype.Service;
@Service
public class SolveServiceImpl implements SolveService {


        public static int NUM = 9;

        public boolean solve(int[][] sudoku, int row, int col) {

            if (row == NUM - 1 && col == NUM) {
                return true;
            }

            if (col == NUM) {
                col = 0;
                row++;
            }

            if (sudoku[row][col] != 0) {
                return solve(sudoku, row, col + 1);
            }
            for (int i = 1; i <= NUM; i++) {

                if (CheckIsSafe.checkSafe(sudoku, row, col, i)) {
                    sudoku[row][col] = i;
                    if (solve(sudoku.clone(), row, col + 1)) {
                        return true;
                    }
                }
                sudoku[row][col] = 0;
            }

            return false;
        }

        public void print(int[][] matrix) {
            for (int i = 0; i < NUM; i++) {
                for (int j = 0; j < NUM; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
}


