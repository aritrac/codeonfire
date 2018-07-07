package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: This code shows the approach of iterative reversing a linked list
 */

public class Prob002_010_ReversingASinglyLinkedListIterative {
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
		
		System.out.println("Before Reversal " + ll);
		
		ll.reverseIterative();
		
		System.out.println("After Reversal " + ll);
	}
}
