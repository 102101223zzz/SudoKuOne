package com.hs.sudokuone.service;

public interface CreateTerminalMatrixService {
    public int[][] createTerminalMatrix();
    public boolean fillRemaining(int row,int col);
    public void fillDiagonalBlocks();
    public int getRandomNumber(int max);
}
