package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 8th July 2018
 * Description: We will be given two sorted linked lists, we have to merge them into a third list in sorted order recursively
 */

public class Prob002_022_MergeTwoSortedLinkedListsRecursive {
	public static void main(String[] args) {
		//Creating the first sorted list
		LinkedList llFirst = new LinkedList();
		llFirst.insertAtEnd(new ListNode(3));
		llFirst.insertAtEnd(new ListNode(8));
		llFirst.insertAtEnd(new ListNode(10));
		llFirst.insertAtEnd(new ListNode(14));
		llFirst.insertAtEnd(new ListNode(23));
		llFirst.insertAtEnd(new ListNode(34));
		
		//Creating the second sorted list
		LinkedList llSecond = new LinkedList();
		llSecond.insertAtEnd(new ListNode(1));
		llSecond.insertAtEnd(new ListNode(7));
		llSecond.insertAtEnd(new ListNode(11));
		llSecond.insertAtEnd(new ListNode(20));
		llSecond.insertAtEnd(new ListNode(30));
		
		//Printing the first list
		System.out.println("First Sorted List => " + llFirst);
		
		//Printing the second list
		System.out.println("Second Sorted List => " + llSecond);
		
		//Creating the third sorted list
		ListNode llThirdHead = mergeSortedListsRecursive(llFirst.getHead(), llSecond.getHead());
		
		//Printing out the third merged list
		System.out.print("Merged List => ");
		LinkedList.printList(llThirdHead);
		
	}
	
	public static ListNode mergeSortedListsRecursive(ListNode first, ListNode second) {
		if(first == null)
			return second; //No need of merging, return the head of the second list
		if(second == null)
			return first; //No need of merging, return the head of the first list
		ListNode third;
		//If first list has less data, then add that to the third list
		if(first.getData() <= second.getData()) {
			third = first;
			third.setNext(mergeSortedListsRecursive(first.getNext(), second)); //Here we are recursively creating the new references in the third list which
																			   //points to the first list
		//If second list has less data, then add that to the third list
		}else {
			third = second;
			third.setNext(mergeSortedListsRecursive(first, second.getNext())); //Here we are recursively creating the new references in the third list which
																		       //points to the second list
		}
		return third;
	}
}
