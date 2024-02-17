package JavaBasics;


import java.io.IOException;

import java.util.Arrays;


public class SortingAlgorithms {
	
	public static int[] bubbleSort(int[] input, int size) {
		for(int  i =0; i<=size-2;i++) {
			for(int j = 0; j<=size-2-i;j++) {
				if(input[j] >input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
		return input;
		
	}
	
	public static int[] selectionSort(int[] input, int size) {
		int min;
		for(int i = 0; i<=size-2; i++) {
			min = input[i];
			int k = i;
			for(int j = i+1; j<=size-1; j++) {
				if(input[j]<min) {
					min = input[j];
							k = j;
				}
			}
			int temp = input[i];
			input[i] = input[k];
			input[k] = temp;
		}
		return input;
		
	}

	public static void main(String[] args) throws IOException {
		int[] arr = {52,23,45,67,12,56};
		int[] selectionSort = selectionSort(arr, arr.length);
		int[] bubbleSort = bubbleSort(arr, arr.length);
		System.out.println("Sort using Selection Sort ->"+Arrays.toString(selectionSort));
		System.out.println("Sort using Selection Sort ->"+Arrays.toString(bubbleSort));
	}

}
