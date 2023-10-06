package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.service.CreateTerminalMatrixService;
import com.hs.sudokuone.util.CheckIsSafe;
import com.hs.sudokuone.util.Constants;
import org.springframework.stereotype.Service;
@Service
public class CreateTerminalMatrixServiceImpl implements CreateTerminalMatrixService {


        public static int SRN = (int) Math.sqrt(Constants.MATRIX_SIZE);

        public  int [][] matrix = null;

        public int[][] createTerminalMatrix(){
            matrix = new int[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];
            fillDiagonalBlocks();
            fillRemaining(0, 0);
            return matrix;
        }

        public boolean fillRemaining(int row,int col) {
            if(row == Constants.MATRIX_SIZE-1 && col == Constants.MATRIX_SIZE)
                return true;

            if(col==Constants.MATRIX_SIZE) {
                col = 0;
                row++;
            }

            if(row<SRN) {
                if(col==0)
                    col += SRN;
            } else if(row>=SRN&&row<Constants.MATRIX_SIZE-SRN) {
                if(col==SRN) {
                    col += SRN;
                }
            }else if(row>=Constants.MATRIX_SIZE-SRN){
                if(col==Constants.MATRIX_SIZE-SRN) {
                    row++;
                    col = 0;
                    if(row==Constants.MATRIX_SIZE)
                        return true;
                }
            }

            for(int i = 1;i<=Constants.MATRIX_SIZE;i++) {
                if(CheckIsSafe.checkSafe(matrix, row, col, i)) {
                    matrix[row][col] = i;
                    if(fillRemaining(row,col+1))
                        return true;
                }
                matrix[row][col] = 0;
            }
            return false;

        }

        public void fillDiagonalBlocks() {
            for(int i = 0;i<Constants.MATRIX_SIZE;i+=3) {
                for(int x = 0;x<3;x++) {
                    for(int y = 0;y<3;y++) {
                        int random = 0;
                        while(true) {
                            random = getRandomNumber(Constants.MATRIX_SIZE+1);
                            if(CheckIsSafe.checkBlock(matrix, x+i, y+i, random)) {
                                break;
                            }
                        }
                        matrix[x+i][y+i] = random;
                    }
                }
            }
        }

        public int getRandomNumber(int max) {

            return (int) ((Math.random() * (max - 1)) + 1);
        }

}
