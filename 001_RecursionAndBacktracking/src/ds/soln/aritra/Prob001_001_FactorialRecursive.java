package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Description: This shows how to calculate factorial of n using recursive approach
 * Date: 15th June 2018
 */

public class Prob001_001_FactorialRecursive {
	public static void main(String[] args) {
		System.out.println("Factorial of 5 = " + factorial(5));
		System.out.println("Factorial of 8 = " + factorial(8));
	}
	//Calculates factorial of a positive integer
	public static int factorial(int n) {
		//base cases: fact of 0 is 1
		if(n == 0)
			return 1;
		//recursive case: multiply n by (n-1) factorial
		else
			return n * factorial(n-1);
	}
}
