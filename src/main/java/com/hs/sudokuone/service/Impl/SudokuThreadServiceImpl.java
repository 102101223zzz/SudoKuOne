package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.pojo.SudoKuRtn;
import com.hs.sudokuone.service.NewSudokuService;
import jdk.nashorn.internal.ir.Block;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.list.SynchronizedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class SudokuThreadServiceImpl implements Runnable{

    private  List<int[][]> l1=new ArrayList<>();
    private  List<int[][]> l2=new ArrayList<>();//题解
    private final ReentrantLock lock=new ReentrantLock();
    private int difficulty;
    public void setDifficulty(int difficulty)
    {
        this.difficulty=difficulty;
    }

    @Autowired
    NewSudokuServiceImpl newSudokuService;
    @Override
    public void run()
    {
            try {
                lock.lock();
                SudoKuRtn sudoKuRtn=newSudokuService.NewSudoku(difficulty);
                this.l1.add(sudoKuRtn.getData());
                this.l2.add(sudoKuRtn.getSolve());
            }finally {
                lock.unlock();
            }

    }

}
