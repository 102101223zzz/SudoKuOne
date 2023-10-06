package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.CreateTerminalMatrixService;
import com.hs.sudokuone.service.NewSudokuService;
import com.hs.sudokuone.service.ResultValidatorService;
import com.hs.sudokuone.util.CheckIsSafe;
import com.hs.sudokuone.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.SystemClock.now;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
        sudoku.setSolve(matrix);
        //必须进行重新赋值，不能操作同一个matrix，否则solve和data一样
        int [][] max=new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                max[i][j]=matrix[i][j];
            }
        }
        diggingHoleService.digHoles(difficulty, max);
        sudoku.setData(max);
        return sudoku;
    }

    public boolean SubmitSudoku(SudoKuRtn sudoKuRtn) {
          return resultValidatorService.checkResult(sudoKuRtn.getData());
        }

}

