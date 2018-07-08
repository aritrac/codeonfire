package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 8th July 2018
 * Description: This code prints a linked list from the end using recursion
 */

public class Prob002_020_PrintALinkedListFromTheEnd {
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));
		ll.insertAtEnd(new ListNode(6));
		
		//Printing out the normal linked list
		System.out.println(ll);
		
		//Printing out the linked list in reverse
		System.out.print("[");
		printReverseLinkedList(ll.getHead(), ll.getHead());
	}
	
	public static void printReverseLinkedList(ListNode temp, ListNode head) {
		if(temp == null) {
			return;
		}
		printReverseLinkedList(temp.getNext(), head);
		
		if(temp == head) {
			System.out.print(temp.getData());
			System.out.print("]");
		}else {
			System.out.print(temp.getData() + ",");
		}
	}
}
