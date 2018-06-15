package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Description: This shows how we can visualize a recursive process
 * Date: 15th June 2018
 */

public class Prob001_002_VisualizingRecursion {
	public static void main(String[] args) {
		System.out.println(printRecurse(5)); //Prints 5 4 3 2 1 0
	}
	
	//This method only prints 5 4 3 2 1, the main method prints the final 0
	public static int printRecurse(int n) {
		if(n == 0) {
			return 0;
		}else {
			System.out.println(n);
			return printRecurse(n - 1);
		}
	}
}
