package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.service.DiggingHoleService;
import com.hs.sudokuone.service.DiggingStrategyService;
import com.hs.sudokuone.service.SolveService;
import com.hs.sudokuone.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DiggingHoleServiceImpl implements DiggingHoleService {
    public static Map<Integer, Integer> difficultyMap = new HashMap<>();
    @Autowired
    SolveService solveService;
    @Autowired
    DiggingStrategyService diggingStrategyService;
    public static int N = Constants.MATRIX_SIZE;


    DiggingHoleServiceImpl() {
        difficultyMap.put(1, 60);
        difficultyMap.put(2, 49);
        difficultyMap.put(3, 35);
        difficultyMap.put(4, 31);
        difficultyMap.put(5, 27);
    }

    public int[][] digHoles(int difficulty, int matrix[][]) {
        int lowerBound = difficultyMap.get(difficulty);
        if (difficulty < 4) {
            return diggingStrategyService.digHolesNormal(matrix, lowerBound);
        } else {
            return diggingStrategyService.digHolesHard(matrix, lowerBound);
        }
    }
}
