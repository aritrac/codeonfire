package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: Here we need to insert an element in a sorted linked list. We will scan the list and find 
 * an item greater than or equal to the element specified and then insert it before the bigger or equal
 * item.
 */

public class Prob002_009_InsertAnElementInASortedLinkedList {
	
	public static void main(String[] args) {
		//Adding elements without repetition
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));
		ll.insertAtEnd(new ListNode(6));
		ll.insertAtEnd(new ListNode(7));
		ll.insertAtEnd(new ListNode(8));
		ll.insertAtEnd(new ListNode(9));
		ll.insertAtEnd(new ListNode(10));
		
		System.out.println("Original Sorted List " + ll);
		
		//inserting 3 into the list
		ll.insertBySortOrder(3); //adding in the middle
		
		System.out.println("Inserting 3 " + ll);
		
		ll.insertBySortOrder(0); //adding at the first
		
		System.out.println("Inserting 0 " + ll);
		
		ll.insertBySortOrder(11); //adding at the last location
		
		System.out.println("Inserting 11 " + ll);
	}
}
