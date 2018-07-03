package ds.soln.aritra;

import java.util.HashMap;
import java.util.Map;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 27/06/2018
 * Description: In this approach we will use a hash map to store the LinkedList information in the following format
 * <position of node, address of node>
 * Then we will get the length of the HashMap by finding its length
 * After that we will find the Length - N key to get the address of the Node and then return the data in that node
 */

public class Prob002_002_FindNthNodeFromTheEndHashMapAppr {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		HashMap<Integer, ListNode> nodeMap = new HashMap<Integer, ListNode>();
		int count = 1;

		// 1st node
		ListNode newNode = new ListNode(45); // creating the node
		nodeMap.put(count++, newNode); // adding the position of node and the node address to HashMap
		ll.insertAtEnd(newNode);// inserting the node into the list at the rear

		// 2nd node, operations same as above
		newNode = new ListNode(87);
		nodeMap.put(count++, newNode);
		ll.insertAtEnd(newNode);

		// 3rd node, operations same as above
		newNode = new ListNode(12);
		nodeMap.put(count++, newNode);
		ll.insertAtEnd(newNode);

		// 4th node, operations same as above
		newNode = new ListNode(55);
		nodeMap.put(count++, newNode);
		ll.insertAtEnd(newNode);

		// 5th node, operations same as above
		newNode = new ListNode(99);
		nodeMap.put(count++, newNode);
		ll.insertAtEnd(newNode);

		// 6th node, operations same as above
		newNode = new ListNode(3);
		nodeMap.put(count++, newNode);
		ll.insertAtEnd(newNode);

		// printing out the current state of the list
		System.out.println(ll);

		// printing 1st Node from the last which is 55
		printNthNodeFromLast(1, nodeMap);

		// printing the 3rd node which is 20 from the last
		printNthNodeFromLast(3, nodeMap);

		// printing the 6th node which is 50 from the last
		printNthNodeFromLast(6, nodeMap);

		// printing the 7th node which is 60 from the last
		printNthNodeFromLast(7, nodeMap);

		// printing the 8th node which is INVALID from the last
		printNthNodeFromLast(8, nodeMap);
	}
	
	public static void printNthNodeFromLast(int N, Map<Integer, ListNode> nodeMap) {
		if(nodeMap.size() == 0) { //List is empty, nothing to print
			System.out.println("List is empty, nothing to print");
			return;
		}
		if(nodeMap.size() < N || N < 0) { //If N is greater than size of list or N < 0 which is not a valid index, return in these cases
			System.out.println("Value of N is invalid");
			return;
		}
		System.out.println(N + "th node from the end is = " + nodeMap.get(new Integer(nodeMap.size() - N + 1)).getData()); 
	}
}
