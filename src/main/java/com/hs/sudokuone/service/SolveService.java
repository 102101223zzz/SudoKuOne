package com.hs.sudokuone.service;

public interface SolveService {
    public boolean solve(int[][] sudoku, int row, int col);
    public void print(int[][] matrix);
}
