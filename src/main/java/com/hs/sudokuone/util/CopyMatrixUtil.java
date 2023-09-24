package com.hs.sudokuone.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CopyMatrixUtil {
	public static int[][] copyMatrix(int[][] matrix){
		return Arrays.stream(matrix).map(i -> i.clone()).toArray($ -> matrix.clone());
	}
}
