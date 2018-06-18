package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 18/06/2018
 * Description:
 * Suppose A is an array of size k such as [5,3,6,8,1,2,8,9,78] where k = 9
 * Suppose I want another array of size n lets say n = 4
 * We need to generate all combinations of array with size 4 so it takes up all possible values from the array with size k to generate the permutations
 * So the combinations might be like follows
 * [5,3,6,8]
 * [5,3,8,9]
 * [2,8,9,78]
 * ...
 * ...
 * [8,1,2,8] 
 */
public class Prob001_005_GenerateAllStringsOfLengthNDrawnFromAnArrayOfSizeK {
	private static int n = 4;
	private static int[] nArr = new int[n];
	private static int COMBO_COUNT = 0;
	
	private static int k = 9;
	private static int[] kArr = {5,3,6,8,1,2,9,7,4};
	
	public static void main(String[] args) {
		printNAryCombinations(n,k);
		System.out.println("Total Generated Combinations = " + COMBO_COUNT);
	}
	
	private static void printNAryCombinations(int N,int K) {
		if(N < 1) {
			printArr(nArr);
			COMBO_COUNT++;
		}else {
			for(int j = 0; j < K; j++) {
				nArr[N-1] = kArr[j];
				printNAryCombinations(N-1, K);
			}
		}
	}
	
	private static void printArr(int[] arr) {
		for(int a: arr) {
			System.out.print(a + "");
		}
		System.out.println();
	}
}
