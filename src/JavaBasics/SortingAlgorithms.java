package JavaBasics;

import java.io.IOException;

import java.util.Arrays;

public class SortingAlgorithms {

	public static int[] bubbleSort(int[] input, int size) {
		for (int i = 0; i <= size - 2; i++) {
			for (int j = 0; j <= size - 2 - i; j++) {
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
		return input;

	}

	public static int[] selectionSort(int[] input, int size) {
		int min;
		for (int i = 0; i <= size - 2; i++) {
			min = input[i];
			int k = i;
			for (int j = i + 1; j <= size - 1; j++) {
				if (input[j] < min) {
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

	public static void quickSort(int[] arr, int low, int high) {

		int j;
		if (low < high) {
			j = partition(arr, low, high);
			quickSort(arr, low, j - 1);
			quickSort(arr, j + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {

		int i = low + 1;
		int j = high;
		int key = arr[low];
		while (true) {
			while (arr[i] < key && i < high)
				i++;

			while (arr[j] > key && j < low)
				j--;

			if (i < j) {
				// swamp a[i] with a[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			} else {
				// swap a[low] with a[j] and return j ;
				int temp = arr[low];
				arr[low] = arr[j];
				arr[j] = temp;
				return j;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int[] arr = { 52, 23, 45, 67, 12, 56 };
		int[] selectionSort = selectionSort(arr, arr.length);
		int[] bubbleSort = bubbleSort(arr, arr.length);
		int[] arr1 = { 52, 23, 45, 67, 12, 56 };
		quickSort(arr1, 0, arr.length - 1);

		System.out.println("Sort using Selection Sort ->" + Arrays.toString(selectionSort));
		System.out.println("Sort using Bubble Sort ->" + Arrays.toString(bubbleSort));
		System.out.println("Sort using Quick Sort ->" + Arrays.toString(arr1));
	}

}
