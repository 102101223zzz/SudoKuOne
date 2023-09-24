package com.hs.sudokuone.util;

public class RandomNumberUtil {
	public static int randomNumber(int max) {
		return (int) ((Math.random() * (max - 0)) + 0);
	}
}
