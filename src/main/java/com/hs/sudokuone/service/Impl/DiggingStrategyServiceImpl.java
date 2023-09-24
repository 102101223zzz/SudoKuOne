package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.service.DiggingStrategyService;
import com.hs.sudokuone.service.SolveService;
import com.hs.sudokuone.util.CheckIsSafe;
import com.hs.sudokuone.util.CopyMatrixUtil;
import com.hs.sudokuone.util.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiggingStrategyServiceImpl implements DiggingStrategyService {
    @Autowired
    SolveService solver;
    public int[][] digHolesHard(int[][] matrix, int lowerBound)
    {
        int[][] visited = new int[N][N];
        int totalGiven = N * N;
        boolean flag = false;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                flag = true;
                int n = matrix[row][col];
                if (visited[row][col] != 1) {
                    visited[row][col] = 1;
                    for (int i = 1; i <= N; i++) {
                        if (i != n) {
                            matrix[row][col] = 0;
                            if (CheckIsSafe.checkSafe(matrix, row, col, i)) {
                                matrix[row][col] = i;
                                if (solver.solve(CopyMatrixUtil.copyMatrix(matrix), 0, 0)) {
                                    matrix[row][col] = n;
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (flag) {
                        matrix[row][col] = 0;
                        totalGiven--;
                        if (totalGiven <= lowerBound) {
                            return matrix;
                        }
                    }

                }
            }
        }
        return matrix;
    }
    public int[][] digHolesNormal(int[][] matrix, int lowerBound)
    {int[][] visited = new int[N][N];
        int totalGiven = N * N;
        boolean flag = false;
        while (totalGiven >= lowerBound) {
            flag = true;
            int row = RandomNumberUtil.randomNumber(N);
            int col = RandomNumberUtil.randomNumber(N);
            int n = matrix[row][col];
            if (visited[row][col] != 1) {
                visited[row][col] = 1;
                for (int i = 1; i <= N; i++) {
                    if (i != n) {
                        matrix[row][col] = 0;
                        if (CheckIsSafe.checkSafe(matrix, row, col, i)) {
                            matrix[row][col] = i;
                            if (solver.solve(CopyMatrixUtil.copyMatrix(matrix), 0, 0)) {
                                matrix[row][col] = n;
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    matrix[row][col] = 0;
                    totalGiven--;
                }

            }

        }
        return matrix;
    }

}
