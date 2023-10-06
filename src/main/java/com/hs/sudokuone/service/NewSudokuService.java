package com.hs.sudokuone.service;

import com.hs.sudokuone.pojo.SudoKuRtn;

import java.util.List;

public interface NewSudokuService {
    int [][] Solve=null;//题解
    SudoKuRtn NewSudoku(int difficulty);
    boolean SubmitSudoku(SudoKuRtn sudoKuRtn);

}
