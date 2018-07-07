package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: This code shows how to find the middle of the list by the following approach
 * 1)Traverse the list to find its length
 * 2)Traverse length/2 again from start, to get to the middle node
 */

public class Prob002_017_FindMiddleOfListFullTraversalAppr {
	public static void main(String[] args) {

		// Creating a list of even length
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));
		ll.insertAtEnd(new ListNode(6));
		ll.insertAtEnd(new ListNode(7));

		// Printing out the list
		System.out.println(ll);
		
		findMiddleNode(ll);

		// Creating a list of even length
		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(new ListNode(1));
		ll2.insertAtEnd(new ListNode(2));
		ll2.insertAtEnd(new ListNode(3));
		ll2.insertAtEnd(new ListNode(4));
		ll2.insertAtEnd(new ListNode(5));
		ll2.insertAtEnd(new ListNode(6));
		
		//Printing out the list
		System.out.println(ll2);
		
		findMiddleNode(ll2);
	}

	public static void findMiddleNode(LinkedList ll) {
		// Finding the list length
		int length = ll.length();

		// if odd, we define step as follows
		int step = 0;
		if (length % 2 != 0) { // odd case
			step = (length / 2) + 1;
		} else { // even case
			step = length / 2;
		}

		// advancing step times from the start to get the middle node
		ListNode temp = ll.getHead();
		while (step-- > 1) {
			temp = temp.getNext();
		}

		System.out.println("The middle node is = " + temp.getData());
	}
}
