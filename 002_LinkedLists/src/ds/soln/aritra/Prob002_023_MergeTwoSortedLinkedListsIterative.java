package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 9th July 2018
 * Description: We will be given two sorted linked lists, we have to merge them into a third list in sorted order iteratively
 */

public class Prob002_023_MergeTwoSortedLinkedListsIterative {
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
		ListNode llThirdHead = mergeSortedListsIterative(llFirst.getHead(), llSecond.getHead());
		
		//Printing out the third merged list
		System.out.print("Merged List => ");
		LinkedList.printList(llThirdHead);
		
	}
	
	public static ListNode mergeSortedListsIterative(ListNode first, ListNode second) {
		if(first == null)
			return second; //No need of merging, return the head of the second list
		if(second == null)
			return first; //No need of merging, return the head of the first list
		
		ListNode firstPointer = first;
		ListNode secondPointer = second;
		ListNode thirdPointer = null;
		ListNode thirdHead = null;
		
		while(firstPointer != null && secondPointer != null) {
			if(firstPointer.getData() <= secondPointer.getData()) {
				if(thirdPointer == null) { //This will only run once for setting the head of the third list
					thirdPointer = firstPointer; //thirdPointer is the current pointer of the thirdList
					thirdHead = firstPointer; //thirdHead is the head pointer of the thirdList
				}
				else {
					thirdPointer.setNext(firstPointer);
					thirdPointer = firstPointer;
				}
				firstPointer = firstPointer.getNext(); //Incrementing the first list pointer as one element was read
			}else {
				if(thirdPointer == null) { //This will only run once for setting the head of the third list
					thirdPointer = secondPointer; //thirdPointer is the current pointer of the thirdList
					thirdHead = secondPointer; //thirdHead is the head pointer of the thirdList
				}else {
					thirdPointer.setNext(secondPointer);
					thirdPointer = secondPointer;
				}
				secondPointer = secondPointer.getNext(); //Incrementing the second list pointer as one element was read
			}
		}
		if(firstPointer != null) { //If elements are remaining to be processed in the first list, set firstList current node as the next node of the third list
			thirdPointer.setNext(firstPointer);
		}
		if(secondPointer != null) { //If elements are remaining to be processed in the second list, set secondList current node as the next node of the third list
			thirdPointer.setNext(secondPointer);
		}
		return thirdHead; //returning the head of the thirdList
	}
}
