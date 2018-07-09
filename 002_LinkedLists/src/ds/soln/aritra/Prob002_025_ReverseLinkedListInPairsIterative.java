package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 9th July 2018
 * Description: Suppose you are given an odd length list such as (ITERATIVE)
 * 1 -> 2 -> 3 -> 4 -> 5 
 * Output of the code should be
 * 2 -> 1 -> 4 -> 3 -> 5
 * 
 * Suppose you are given an even length list such as
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output of the code should be
 * 2 -> 1 -> 4 -> 3 -> 6 -> 5
 */

public class Prob002_025_ReverseLinkedListInPairsIterative {
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
		ListNode revHead = reverseListByPairIterative(llEven.getHead());
		
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
		revHead = reverseListByPairIterative(llOdd.getHead());
		
		//Printing out the new reversed list
		System.out.print("Reversed => ");
		LinkedList.printList(revHead);
	}
	
	public static ListNode reverseListByPairIterative(ListNode head) {
		ListNode temp = head; //Storing head value in temp
		boolean firstIter = true;
		while(temp != null && temp.getNext() != null) {
			ListNode first = temp;				//Storing the first node reference
			ListNode second = first.getNext();  //Storing the second node reference
			ListNode third = second.getNext();  //Storing the third node reference
			
			second.setNext(first);	//Setting second node in each iteration to point to first node for reversal to work
			
			if(firstIter) {	//Setting up the head pointer of the reversed list which runs only once
				head = second;
				firstIter = !firstIter;
			}
			if(third != null && third.getNext() != null) { //If two nodes are present after the current pair which is being reversed
				first.setNext(third.getNext());
			}
			if(third != null && third.getNext() == null) { //If only one is present after the current pair which is being reversed
				first.setNext(third);
			}
			if(third == null) {	//If there are no nodes after the current two nodes, set the first nodes next to null
				first.setNext(null);
			}
			temp = third; //advancing the iteration to point to the third node
		}
		return head; //returning the new modified head
	}
}
