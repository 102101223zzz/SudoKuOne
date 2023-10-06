package com.hs.sudokuone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SudoKuRtn {
    int [][] data;//[9][9]
    int [][] Solve;
    LocalDateTime time;
}
