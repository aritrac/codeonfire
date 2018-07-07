package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: Consider two linked lists, with a common node, after which both the lists merge. Our job is to find that merging point.
 * In this approach we will compare every node pointer in the first list with every other node pointer in the second list, by which
 * the matching node pointers will lead us to the intersecting node.
 */

public class Prob002_012_FindMergingPointOf2ListsBruteForce {
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
		
		ListNode mergeNode = findMergePointBruteForce(llOne, llTwo);
		
		if(mergeNode == null)
			System.out.println("The lists do not intersect");
		else
			System.out.println("The lists merge at " + mergeNode.getData());
		
	}
	
	public static ListNode findMergePointBruteForce(LinkedList llOne, LinkedList llTwo) {
		//iterating List1
		ListNode listOneTemp = llOne.getHead();
		while(listOneTemp != null) {
			ListNode listTwoTemp = llTwo.getHead();
			while(listTwoTemp != null) {
				if(listOneTemp == listTwoTemp) { //We found the merge start point
					return listOneTemp;
				}
				listTwoTemp = listTwoTemp.getNext();
			}
			listOneTemp = listOneTemp.getNext();
		}
		return null;// No merge point found, the lists do not intersect
	}
}
