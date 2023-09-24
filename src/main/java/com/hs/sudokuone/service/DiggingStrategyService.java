package com.hs.sudokuone.service;

import com.hs.sudokuone.util.Constants;

public interface DiggingStrategyService {
    public static int N = Constants.MATRIX_SIZE;
    public int[][] digHolesHard(int[][] matrix, int lowerBound);
    public int[][] digHolesNormal(int[][] matrix, int lowerBound);
}
