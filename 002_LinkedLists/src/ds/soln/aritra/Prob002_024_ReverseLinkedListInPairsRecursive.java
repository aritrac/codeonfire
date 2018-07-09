package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 9th July 2018
 * Description: Suppose you are given an odd length list such as
 * 1 -> 2 -> 3 -> 4 -> 5 
 * Output of the code should be
 * 2 -> 1 -> 4 -> 3 -> 5
 * 
 * Suppose you are given an even length list such as
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output of the code should be
 * 2 -> 1 -> 4 -> 3 -> 6 -> 5
 */

public class Prob002_024_ReverseLinkedListInPairsRecursive {
	public static void main(String[] args) {
		LinkedList llEven = new LinkedList(); //Creating an even length list
		llEven.insertAtEnd(new ListNode(20));
		llEven.insertAtEnd(new ListNode(30));
		llEven.insertAtEnd(new ListNode(40));
		llEven.insertAtEnd(new ListNode(50));
		llEven.insertAtEnd(new ListNode(60));
		llEven.insertAtEnd(new ListNode(70));
		
		//Printing out the original list
		System.out.println("Original => " + llEven);
		
		//Reversing one pair at a time
		ListNode revHead = reverseListByPairRecursive(llEven.getHead());
		
		//Printing out the new reversed list
		System.out.print("Reversed => ");
		LinkedList.printList(revHead);
		
		LinkedList llOdd = new LinkedList(); //Creating an odd length list
		llOdd.insertAtEnd(new ListNode(20));
		llOdd.insertAtEnd(new ListNode(30));
		llOdd.insertAtEnd(new ListNode(40));
		llOdd.insertAtEnd(new ListNode(50));
		llOdd.insertAtEnd(new ListNode(60));
		
		//Printing out the original list
		System.out.println("Original => " + llOdd);
		
		//Reversing one pair at a time
		revHead = reverseListByPairRecursive(llOdd.getHead());
		
		//Printing out the new reversed list
		System.out.print("Reversed => ");
		LinkedList.printList(revHead);
	}
	
	public static ListNode reverseListByPairRecursive(ListNode head) {
		if(head == null || head.getNext() == null) //This is the base case for null for 1 element lists
			return head;
		ListNode temp = head.getNext(); //Storing next node of head
		head.setNext(reverseListByPairRecursive(temp.getNext())); //as head will come to right of temp, setting the next node of head via recursive call
		temp.setNext(head); //finally on return of call, setting temp which is on left to head whhich is on right 
		return temp;
	}
}
