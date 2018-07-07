package ds.soln.aritra;

import java.util.Stack;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: This will find the start of merge node in two linked lists. In this approach
 * we will use two stacks. We will traverse the first list and put all node references on the first stack.
 * We will then traverse the second list and put all node references on the second stack.
 * Next, we will compare the top, if both are same, we will store it in a separate variable
 * Whenever we encounter that both tops are not matching, we will return the value we stored previously
 * in the separate variable, as that is the start of the list merge
 */

public class Prob002_014_FindMergingPointOf2ListsTwoStacksApproach {
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
		
		ListNode mergeNode = findMergePointBruteForceTwoStacksApproach(llOne, llTwo);
		
		if(mergeNode == null)
			System.out.println("The lists do not intersect");
		else
			System.out.println("The lists merge at " + mergeNode.getData());
		
	}
	
	public static ListNode findMergePointBruteForceTwoStacksApproach(LinkedList llOne, LinkedList llTwo) {
		Stack<ListNode> stackOne = new Stack<ListNode>(); //This will store the node references of the first list
		Stack<ListNode> stackTwo = new Stack<ListNode>(); //This will store the node references of the second list
		
		ListNode llOneTemp = llOne.getHead();
		//Iterating the first list to populate the first stack
		while(llOneTemp != null) {
			stackOne.push(llOneTemp);
			llOneTemp = llOneTemp.getNext();
		}
		
		ListNode llTwoTemp = llTwo.getHead();
		//Iterating the second list to populate the second stack
		while(llTwoTemp != null) {
			stackTwo.push(llTwoTemp);
			llTwoTemp = llTwoTemp.getNext();
		}
		
		//Now comes the stack top comparison part to find the merge start node
		ListNode commonNode = null;
		while(!stackOne.isEmpty() && !stackTwo.isEmpty()) { //We will continue until one of the stacks are empty
			if(stackOne.peek() == stackTwo.peek()) {
				commonNode = stackOne.pop(); //Removing the top elements of both the stacks as they are same
				stackTwo.pop();//and storing one of them into the separate variable commonNode
			}else {
				return commonNode;
			}
		}
		return null; //The lists don't merge, hence return null.
	}
}
