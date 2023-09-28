package com.hs.sudokuone.service;

import com.hs.sudokuone.pojo.SudoKuRtn;

import java.util.List;

public interface NewSudokuService {
    SudoKuRtn NewSudoku(int difficulty);
    boolean SubmitSudoku(SudoKuRtn sudoKuRtn);

}
