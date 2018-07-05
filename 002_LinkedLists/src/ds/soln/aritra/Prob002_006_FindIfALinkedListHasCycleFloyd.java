package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 5th July 2018
 * Description: Here we will find if the linked list has a cycle or not using Floyd's cycle finding algorithm which goes like this
 * It uses two pointers moving at different speeds to walk the linked list.Once they enter the loop they are expected to meet,
 * which denotes that there is a loop.
 */

public class Prob002_006_FindIfALinkedListHasCycleFloyd {
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
		System.out.println("Case1: Does the list have a cycle? " + hasCycle(node1));
		
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
		
		System.out.println("Case2: Does the list have a cycle? " + hasCycle(node1));
	}
	
	public static boolean hasCycle(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext(); //Moving the fast pointer 2 steps at a time
			slowPointer = slowPointer.getNext(); //Moving the slow pointer 1 step at a time
			
			if(fastPointer == slowPointer) { //If both the pointers intersect, then there is surely a loop and we return a true value
				return true;
			}
		}
		return false; //If loop exited, then it means there is no cycle and we return false;
	}
}
