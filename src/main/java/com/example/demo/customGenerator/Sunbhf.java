package com.example.demo.customGenerator;

public class Sunbhf<T> {

	private T mine;

	public static <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.println(element);
		}
	}
}
