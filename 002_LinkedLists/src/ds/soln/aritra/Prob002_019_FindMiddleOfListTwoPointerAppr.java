package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 8th July 2018
 * Description: This finds the middle node of the linked list using a slow and fast pointer like the following
 * 1)slow pointer will move one step at a time
 * 2)fast pointer will move two step at a time
 * 3)when the fast pointer will reach the end of the list, the slow pointer will be pointing to the middle node
 */

public class Prob002_019_FindMiddleOfListTwoPointerAppr {
	public static void main(String[] args) {

		// Creating a list having odd number of elements
		LinkedList ll = new LinkedList();

		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));

		// Printing out the list
		System.out.println(ll);

		ListNode midNode = findMiddleOfListTwoPtrAppr(ll); // The middle element

		System.out.println("The middle of list contains " + midNode.getData());

		// Creating a list having even number of elements
		LinkedList ll2 = new LinkedList();

		ll2.insertAtEnd(new ListNode(1));
		ll2.insertAtEnd(new ListNode(2));
		ll2.insertAtEnd(new ListNode(3));
		ll2.insertAtEnd(new ListNode(4));

		// Printing out the list
		System.out.println(ll2);

		midNode = findMiddleOfListTwoPtrAppr(ll2); // The middle element

		System.out.println("The middle of list contains " + midNode.getData());
	}
	
	public static ListNode findMiddleOfListTwoPtrAppr(LinkedList ll) {
		ListNode slowPtr = ll.getHead(); //Initializing the slow pointer
		ListNode fastPtr = ll.getHead(); //Initializing the fast pointer
		
		while(fastPtr != null && fastPtr.getNext() != null) { //Waiting for the fastPtr to reach the end and also checking if there is a second node
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		return slowPtr;
	}
}
