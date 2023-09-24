package com.hs.sudokuone.service.Impl;
import com.hs.sudokuone.service.ResultValidatorService;
import com.hs.sudokuone.util.CheckIsSafe;
import com.hs.sudokuone.util.Constants;
import org.springframework.stereotype.Service;

@Service
public class ResultValidatorServiceImpl implements ResultValidatorService{
    public boolean checkResult(int[][] matrix)
    {
        for(int i = 0;i< Constants.MATRIX_SIZE;i++) {
            for(int j = 0;j<Constants.MATRIX_SIZE;j++) {
                int n = matrix[i][j];
                matrix[i][j] = 0;
                if(!CheckIsSafe.checkSafe(matrix,i,j,n)) {
                    return false;
                }
            }
        }
        return true;
    }


}
