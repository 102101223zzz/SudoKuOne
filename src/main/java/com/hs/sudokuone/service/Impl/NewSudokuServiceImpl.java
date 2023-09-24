package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.CreateTerminalMatrixService;
import com.hs.sudokuone.service.NewSudokuService;
import com.hs.sudokuone.service.ResultValidatorService;
import com.hs.sudokuone.util.CheckIsSafe;
import com.hs.sudokuone.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.core.toolkit.SystemClock.now;

@Service
public class NewSudokuServiceImpl implements NewSudokuService {
    @Autowired
    CreateTerminalMatrixService createTerminalMatrixService;
    @Autowired
    DiggingHoleServiceImpl diggingHoleService;
    @Autowired
    ResultValidatorService resultValidatorService;
    public SudoKuRtn NewSudoku(int difficulty)
    {
        SudoKuRtn sudoku = new SudoKuRtn();
        sudoku.setTime(LocalDateTime.now());
        int[][] matrix = createTerminalMatrixService.createTerminalMatrix();
        diggingHoleService.digHoles(difficulty, matrix);
        sudoku.setData(matrix);
        return sudoku;
    }

    public boolean SubmitSudoku(SudoKuRtn sudoKuRtn) {
          return resultValidatorService.checkResult(sudoKuRtn.getData());
        }
}

