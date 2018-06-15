package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Description:
 * Solving the tower of hanoi problem using recursion.
 * Requirement is as follows:
 * 1)Move all disks from Source peg to Destination peg
 * 2)Only one peg can be moved at a time
 * 3)Only smaller pegs can be put on top of larger pegs
 * 
 * To solve this, we have Source, Auxillary and Destination peg. Our job is to move items from Source to Destination peg
 * Let us consider that we have n pegs to we have to move from source to destination pegs. We can achieve the same using the following recursive steps
 * 1)Move (n - 1) disks from Source to Auxillary peg
 * 2)Move nth disk from Source to Destination
 * 3)Move (n - 1) disks on the Auxillary peg to Destination peg
 * 
 * If the number of disks are n then the number of moves are (2^n - 1)
 * 
 * So the complexity would be O(2^n)
 */

public class Prob001_003_TowerOfHanoi {
	private static int moveCount = 0;//Will keep track of the number of moves required to solve the problem
	
	public static void main(String[] args) {
		solveTowerOfHanoi(5, 'A', 'C', 'B');
		System.out.println("Problem solved in " + moveCount + " moves");
	}
	
	public static void solveTowerOfHanoi(int n, char from, char to, char aux) {
		if(n == 1) {
			System.out.println("Moved disk from peg " + from + " to peg " + to);
			moveCount++;
			return;
		}
		//Move top n-1 disks from source to auxillary peg
		solveTowerOfHanoi(n - 1, from, aux, to);
		//Move nth disk from source to destination peg
		System.out.println("Moved disk from peg " + from + " to peg " + to);
		moveCount++;
		//Move n-1 disks from auxillary to destination peg
		solveTowerOfHanoi(n - 1, aux, to, from);
	}
}
