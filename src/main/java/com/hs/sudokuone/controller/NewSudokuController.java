package com.hs.sudokuone.controller;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.CreateTerminalMatrixService;
import com.hs.sudokuone.service.Impl.SudokuThreadServiceImpl;
import com.hs.sudokuone.service.NewSudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/newSudoku")
public class NewSudokuController {
    @Autowired
    NewSudokuService newSudokuService;
    @Autowired
    SudokuThreadServiceImpl sudokuThreadService;
    @RequestMapping("/createTerminalMatrix")
    public List<SudoKuRtn> createTerminalMatrix() {
        int difficulty=3;
        List<SudoKuRtn> l1=new ArrayList<>();
        for(int t=0;t<9;t++) {
            sudokuThreadService.setDifficulty(difficulty);
            new Thread(sudokuThreadService).start();
            l1.add(sudokuThreadService.getSudoKuRtn());
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    System.out.print(sudokuThreadService.getSudoKuRtn().getData()[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("--------------------------------------------------");
//        }
//        System.out.println(l1.size());
        }
        return l1;
    }
   @RequestMapping("/SubmitSudoku")
    public boolean SubmitSudoku(SudoKuRtn sudoKuRtn) {
        return newSudokuService.SubmitSudoku(sudoKuRtn);
    }
}
