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

    private  List<SudoKuRtn> l1=new ArrayList<>();
    private final ReentrantLock lock=new ReentrantLock();
    private int difficulty;
    public void setDifficulty(int difficulty)
    {
        this.difficulty=difficulty;
    }

    @Autowired
    NewSudokuService newSudokuService;
    @Override
    public void run()
    {
            try {
                lock.lock();
                this.l1.add(newSudokuService.NewSudoku(difficulty));
                System.out.println("当前的"+l1.size());
            }finally {
                lock.unlock();
            }

    }

}
