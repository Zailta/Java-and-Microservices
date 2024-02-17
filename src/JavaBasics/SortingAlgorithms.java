package JavaBasics;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class SortingAlgorithms {
	
	public int[] bubbleSort(int[] input, int size) {
		return null;
		
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
		
		System.out.println(Arrays.toString(selectionSort));
	}

}
