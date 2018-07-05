package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 5th July 2018
 * Description: Using Floyd's algorithm for cycle finding, we will now find the start node at which the loop begins using the following approach
 * After finding the loop in the linked list, we initialize the slow pointer to the head of the linked list. From that point onwards both
 * slow pointer and fast pointer move only one node at a time. The point at which they meet is the start of the loop.
 */

public class Prob002_007_FindStartNodeOfLoop {
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
	}
	
	public static ListNode hasCycleAtNode(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext(); //Moving the fast pointer 2 steps at a time
			slowPointer = slowPointer.getNext(); //Moving the slow pointer 1 step at a time
			
			if(fastPointer == slowPointer) { //If both the pointers intersect, then there is surely a loop and we return a true value
				slowPointer = head; //Moving slow pointer to the head, keeping fast pointer where it is
				while(slowPointer != fastPointer) { //waiting for both the pointers to meet
					slowPointer = slowPointer.getNext(); //Moving both the points at the same speed
					fastPointer = fastPointer.getNext();
				}
				return slowPointer;//This node is where the loop starts
			}
		}
		return null; //If loop exited, then it means there is no cycle and we return false;
	}
}
