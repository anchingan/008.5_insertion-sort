/*
 * Practice 008.5_Insertion sort
 * Date 20170809
 */

import java.util.Scanner;
import java.util.Arrays;

public class insertion_sort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Declare array to store input data.
		int[] array = new int[10];
		
		//Declare integers will be used.
		int count = 0, status = 0, input, index; 
		
		do {
			switch (status) {
			case 0: //Ask the user to choose an option.
				System.out.print("Option: 1) Add. 2) Insert sort. -1) Quit: ");
				status = inputOption(scanner.nextInt());
				break;
				
			case 1: //Insert grade.
				System.out.print("Insert grade (-1 to end): ");
				input = scanner.nextInt();
				if (input == -1)
					status = 0;
				else if (input < 0) 
					System.out.println("Input error!");
				else {
					if (count >= array.length)
						array = Arrays.copyOf(array, count * 2);
					array[count++] = input;
				}
				break;
				
			case 2: //Print array before and after sorting and do insertion sort.
				System.out.print("Before sorting:\n");
				for (int i = 0; i < count; i++)
					System.out.printf("%d ", array[i]);
				
				insertionSort(array,count);
				
				System.out.print("\nAfter sorting:\n");
				for (int i = 0; i < count; i++)
					System.out.printf("%d ", array[i]);
				
				System.out.print("\n");
				status = 0;
				break;
			}
		} while (status != -1);
		
		System.out.print("Program terminate.");

	}
	
	public static int inputOption(int input) {
		if (input == 1)
			return 1;
		else if (input == 2)
			return 2;
		else if (input == -1)
			return -1;
		else {
			System.out.println("Input error!");
			return 0;
		}
	}
	
	public static void insertionSort(int a[], int n) {
		int temp;
		
		if (n == 1)
			;
		else {
			insertionSort(a, n - 1);
			for (int i = n - 1; i > 0; i--) {
				if (a[i] < a[i - 1]) {
					temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}
				else
					break;
			}
		}
	}
	

}
