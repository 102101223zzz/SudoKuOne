package com.hs.sudokuone.service;

import com.hs.sudokuone.pojo.SudoKuRtn;

public interface NewSudokuService {
    SudoKuRtn NewSudoku(int difficulty);
    boolean SubmitSudoku(SudoKuRtn sudoKuRtn);
}
