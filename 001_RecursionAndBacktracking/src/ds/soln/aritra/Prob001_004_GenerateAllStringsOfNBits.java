package ds.soln.aritra;
/*
 * Author: Aritra Chatterjee
 * Date: 18/06/2018
 * Description: Given an array of size N such as A[0..n-1], we need to generate all the possible permutations of the array content
 * For example A = {0,0,0,0} so the program will print 2^A.length combinations of the array representing all the binary bit strings possible with 4 bits
 * 0000
 * 0001
 * 0010
 * 0011
 * ...
 * ...
 * 1111
 * The output of the code should be like shown above on an input of value N
 */

public class Prob001_004_GenerateAllStringsOfNBits {
	private static int LENGTH = 4;
	private static int[] arr = new int[LENGTH]; // Creating an empty array of 4 elements each of which can be 0 or 1

	public static void main(String[] args) {
		printBinaryCombinations(LENGTH);
	}

	public static void printBinaryCombinations(int n) {
		if (n < 1)
			printArr(arr); //When the leaf node will be reached, that is when the recursion stops and returns, you print out the state of the entire array
									 //which will be one of the 2^4 combinations.
		else {
			arr[n - 1] = 0;//We are setting each location in the array to either 0 or 1 and starting a recursive call to generate the children in the same fashion
			printBinaryCombinations(n - 1);
			arr[n - 1] = 1;
			printBinaryCombinations(n - 1);
		}
	}
	
	private static void printArr(int[] arr) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
