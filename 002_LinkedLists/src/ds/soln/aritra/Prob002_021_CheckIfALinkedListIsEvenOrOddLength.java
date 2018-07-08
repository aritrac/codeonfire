package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 8th July 2018
 * Description: We need to check if the given linked list is of even or odd length. The length of the list is unknown
 * We will use a fast pointer which will traverse 2 nodes at a time. If the list is even length, then
 * the fast pointer will become null at end, otherwise the fast pointer will be pointing at the last node.
 * Below is the implementation for the same.
 */

public class Prob002_021_CheckIfALinkedListIsEvenOrOddLength {
	public static void main(String[] args) {
		// Creating an even length linked list
		LinkedList llEven = new LinkedList();
		llEven.insertAtEnd(new ListNode(2));
		llEven.insertAtEnd(new ListNode(3));
		llEven.insertAtEnd(new ListNode(4));
		llEven.insertAtEnd(new ListNode(5));
		llEven.insertAtEnd(new ListNode(6));
		llEven.insertAtEnd(new ListNode(7));

		// Finding out whether the list is even or odd length
		System.out.println("Is the linked list even length? " + isEvenLengthLinkedList(llEven.getHead()));

		// Creating an even length linked list
		LinkedList llOdd = new LinkedList();
		llEven.insertAtEnd(new ListNode(2));
		llEven.insertAtEnd(new ListNode(3));
		llEven.insertAtEnd(new ListNode(4));
		llEven.insertAtEnd(new ListNode(5));
		llEven.insertAtEnd(new ListNode(6));

		// Finding out whether the list is even or odd length
		System.out.println("Is the linked list even length? " + isEvenLengthLinkedList(llEven.getHead()));
	}

	public static boolean isEvenLengthLinkedList(ListNode temp) {
		while (temp != null && temp.getNext() != null)
			temp = temp.getNext().getNext();
		return temp == null;
	}
}
