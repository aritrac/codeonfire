package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: This finds the merge start point of two lists by the following approach
 * 1)Find lengths of both the lists
 * 2)Take the difference in lengths which is d
 * 3)Make d steps in the longer list
 * 4)Now take one step in both lists to find the common merge point
 */

public class Prob002_016_FindMergingPointOf2ListsByDiffAppr {
	public static void main(String[] args) {
		//The common node
		ListNode commonNode = new ListNode(22);
		
		//Creating the first linked list
		LinkedList llOne = new LinkedList();
		llOne.insertAtEnd(new ListNode(12));
		llOne.insertAtEnd(new ListNode(13));
		llOne.insertAtEnd(commonNode); //Putting the intersection at this point in the list
		llOne.insertAtEnd(new ListNode(30));
		llOne.insertAtEnd(new ListNode(31));
		llOne.insertAtEnd(new ListNode(32));
		llOne.insertAtEnd(new ListNode(36));
		
		//The first linkedList
		System.out.println(llOne);
		
		//Creating the second linked list and also putting the common node
		LinkedList llTwo = new LinkedList();
		llTwo.insertAtEnd(new ListNode(4));
		llTwo.insertAtEnd(new ListNode(7));
		llTwo.insertAtEnd(new ListNode(11));
		llTwo.insertAtEnd(commonNode); //Putting the intersection at this point in the list
		
		//The second linkedList
		System.out.println(llTwo);
		
		ListNode mergeNode = findMergePointOf2ListsByDifferenceAppr(llOne, llTwo);
		
		if(mergeNode == null)
			System.out.println("The lists do not intersect");
		else
			System.out.println("The lists merge at " + mergeNode.getData());
		
	}
	
	public static ListNode findMergePointOf2ListsByDifferenceAppr(LinkedList llOne, LinkedList llTwo) {
		//calculating the difference in lengths of both the lists
		LinkedList longer = null; //this will point to the longer list
		LinkedList shorter = null; //this will point to the shorter list
		if(llOne.length() > llTwo.length()) { //finding out which one is short
			longer = llOne;
			shorter = llTwo;
		}else {
			longer = llTwo;
			shorter = llOne;
		}
		
		int diff = longer.length() - shorter.length(); //calculating the difference
		
		ListNode longHead = longer.getHead();
		ListNode shortHead;
		
		if(diff >= 0) {//Lists are not equal in length, then only advance the long pointer
			while(diff-- > 0) { //Advancing the pointer for the longer list by diff steps
				longHead = longHead.getNext();
			}
		}
		shortHead = shorter.getHead();
		//Moving both long and short list pointer by 1 step until they match
		while(longHead != null) {
			if(longHead == shortHead) //We got the merge start point, hence returning it
				return longHead; 
			longHead = longHead.getNext(); //Advancing both the pointers
			shortHead = shortHead.getNext();
		}
		return null; //As no matching nodes were found, the lists do not merge, hence returning null
	}
}
