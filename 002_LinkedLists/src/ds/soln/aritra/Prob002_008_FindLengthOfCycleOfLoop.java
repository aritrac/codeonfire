package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: We already know how to find the start of the cycle in a linked list using above approach.
 * We just need to count the number of nodes traversed, when we put the slow pointer at the start and
 * start incrementing both slow and fast pointers by 1 until they meet. The following code does the same.
 */

public class Prob002_008_FindLengthOfCycleOfLoop {
	
	private static int cycleLength = 0;
	
	public static void main(String[] args) {
		//Creating 10 nodes numbered 1 to 10 and then making the 10th node point to the 4th node to create a cycle
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		
		//Test for list having a cycle
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(node4); //Creating the cycle here by linking 10th to 4th node
		System.out.println("Case1: The cycle starts at node with data " + hasCycleAtNode(node1).getData());
		System.out.println("The length of the cycle is = " + cycleLength);
		
		//Test for list not having a cycle
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(null); //Removing the cyclic dependency
		
		System.out.println("Case2: The cycle starts at node with data " + (hasCycleAtNode(node1) == null? "No cycle":"Cycle present"));
		System.out.println("The length of the cycle is = " + cycleLength);
	}
	
	public static ListNode hasCycleAtNode(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		cycleLength = 0;
		while(fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext(); //Moving the fast pointer 2 steps at a time
			slowPointer = slowPointer.getNext(); //Moving the slow pointer 1 step at a time
			
			if(fastPointer == slowPointer) { //If both the pointers intersect, then there is surely a loop and we return a true value
				slowPointer = head; //Moving slow pointer to the head, keeping fast pointer where it is
				while(slowPointer != fastPointer) { //waiting for both the pointers to meet
					slowPointer = slowPointer.getNext(); //Moving both the points at the same speed
					fastPointer = fastPointer.getNext();
					cycleLength++;
				}
				return slowPointer;//This node is where the loop starts
			}
		}
		return null; //If loop exited, then it means there is no cycle and we return false;
	}
}