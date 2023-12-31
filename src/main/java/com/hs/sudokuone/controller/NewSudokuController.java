package com.hs.sudokuone.controller;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.Impl.SolveServiceImpl;
import com.hs.sudokuone.service.Impl.SudokuThreadServiceImpl;
import com.hs.sudokuone.service.NewSudokuService;
import com.hs.sudokuone.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewSudokuController {
    @Autowired
    NewSudokuService newSudokuService;
    @Autowired
    SudokuThreadServiceImpl sudokuThreadService;
    @RequestMapping("/NewSudoku")
    public String createTerminalMatrix(@RequestParam("difficulty") int difficulty, Model model) throws InterruptedException {
        //发现bug，如果不清空的话每次刷新会会导致l1的size越来越大，而且返回的值还是不变这一步清空后就可以了
        sudokuThreadService.getL1().removeAll(sudokuThreadService.getL1());
        sudokuThreadService.getL2().removeAll(sudokuThreadService.getL2());
        sudokuThreadService.setDifficulty(difficulty);
            for(int i=0;i<9;i++)
                new Thread(sudokuThreadService).start();

        //发现bug，执行到这边的时候，l1的size还是0，所以要等待一下
        while(true)
        {
            if(sudokuThreadService.getL1().size()==9)
                break;
        }

        List<int[][]> l1=new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            l1.add(sudokuThreadService.getL1().get(i));
        }
//        for(int t=0;t<9;t++) {
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    System.out.print(l1.get(t)[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("--------------------------------------------------");
//        }
       // model.addAttribute("sudokuList",sudokuThreadService.getL1());
        model.addAttribute("sudokuList",l1);
        model.addAttribute("sudokuSolveList",sudokuThreadService.getL2());
        return "Sudoku";
    }
   @RequestMapping("/SubmitSudoku")
    public boolean SubmitSudoku(SudoKuRtn sudoKuRtn) {
        return newSudokuService.SubmitSudoku(sudoKuRtn);
    }
    @RequestMapping("/Helloworld")
    public String Hello() {
        return "helloWord";
    }
    @RequestMapping("/index")
    public String test(Model model) {
        model.addAttribute("msg","zzzz");
        return "index";
    }
    @RequestMapping("/GetSolve")
    public String GetSolve(Model model) {
        System.out.println("this is Solve");
        List<int[][]> l2 = sudokuThreadService.getL2();
        for (int t = 0; t < 9; t++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(l2.get(t)[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------------------------");
    }
        model.addAttribute("sudokuList",l2);
       // sudokuThreadService.getL2().removeAll(sudokuThreadService.getL2());
        return  "GetSolve";
    }

}
