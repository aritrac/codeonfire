package ds.soln.aritra;

import java.util.Hashtable;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: Here we will find the merge point of two list, but instead of using N^2 approach, we will increase the space complexity
 * by adding a HashTable which is store all the node addresses of the first list. Then we will loop over the second list and see if
 * the node addresses are there in the HashTable or not. If yes, we have found the common merging point.
 */

public class Prob002_013_FindMergingPointOf2ListsBruteHashTable {
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
		
		ListNode mergeNode = findMergePointBruteForceHashTable(llOne, llTwo);
		
		if(mergeNode == null)
			System.out.println("The lists do not intersect");
		else
			System.out.println("The lists merge at " + mergeNode.getData());
		
	}
	
	public static ListNode findMergePointBruteForceHashTable(LinkedList llOne, LinkedList llTwo) {
		
		Hashtable<ListNode, Integer> table = new Hashtable<>();//Creating the hashtable to store the node addresses
		
		ListNode llOneTemp = llOne.getHead(); //Getting the head of the first list
		
		//Scanning the first list and storing all node addresses in the hashtable
		while(llOneTemp != null) {
			table.put(llOneTemp, llOneTemp.getData());
			llOneTemp = llOneTemp.getNext();
		}
		
		ListNode llTwoTemp = llTwo.getHead();
		
		//Scanning the second table to find any matched node addresses in the hashtable to give us the merge start point
		while(llTwoTemp != null) {
			if(table.containsKey(llTwoTemp)) //Merge start node found
				return llTwoTemp;
			llTwoTemp = llTwoTemp.getNext();
		}
		return null; //The lists don't intersect, hence return null
	}
}
