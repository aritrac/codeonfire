package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Description: Write a recursive program to check if an array is sorted in ascending order or not
 * Date: 15th June 2018
 */

public class Prob001_004_CheckSortedArrayUsingRecursion {
	public static boolean checkSortedArray(int[] arr, int index) {
		if(arr.length == 1 || index == 1) {	//If array has a single element or the index came down to 1 that means the array has only single element to check, hence it is sorted
			return true; //True signifies the array is sorted
		}
		return(arr[index - 1] < arr[index - 2] ? false : checkSortedArray(arr, index - 1)); // If higher index contains less value than lower index then array is not sorted, so return false up the entire chain
																							// until it reaches the main method to show the final result, else check for lower indices in the same fashion
	}
	
	public static void main(String[] args) {
		boolean isSorted = checkSortedArray(new int[] {3,4,5,6,7,8},6);//Passing the sorted array and also the number of elements in the array serving as index
		if(isSorted)
			System.out.println("This array is sorted");
		else
			System.out.println("This array is not sorted");
		isSorted = checkSortedArray(new int[] {3,5,4,6,8,7},6);
		if(isSorted)
			System.out.println("This array is sorted");
		else
			System.out.println("This array is not sorted");
	}
}
