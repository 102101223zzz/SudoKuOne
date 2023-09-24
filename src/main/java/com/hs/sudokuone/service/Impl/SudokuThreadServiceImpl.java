package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.NewSudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SudokuThreadServiceImpl implements Runnable{
    private SudoKuRtn sudoKuRtn;
    private int difficulty;
    public SudoKuRtn getSudoKuRtn() {
        return sudoKuRtn;
    }
    public void setDifficulty(int difficulty)
    {
        this.difficulty=difficulty;
    }

    @Autowired
    NewSudokuService newSudokuService;
    @Override
    public void run()
    {
        this.sudoKuRtn=newSudokuService.NewSudoku(difficulty);
    }

}
