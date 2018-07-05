package ds.soln.aritra;

import java.util.HashMap;
import java.util.Map;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 5th July 2018
 * Description: This finds whether a LinkedList has a cycle using a hashmap to keep a tab on the nodes visited in the following fashion
 * 1)Traverse the linked list one by one
 * 2)Check if the address of the node is available in the hash table or not.
 * 3)If it is available in the hash table, that indicates that we are visiting the node that was already visited. This is possible only
 * if the given linked list has a loop in it
 * 4)If the address of the node is not available in the hash table, insert the node's address into the hash table.
 * 5)Continue this process until we reach the end of the linked list or we find the loop.
 */

public class Prob002_005_FindIfALinkedListHasCycle {
	public static void main(String[] args) {
		//Creating 10 nodes numbered 1 to 10 and then making the 10th node point to the 4th node to create a cycle
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		
		//Test for list having a cycle
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(node4); //Creating the cycle here by linking 10th to 4th node
		System.out.println("Case1: Does the list have a cycle? " + hasCycle(node1));
		
		//Test for list not having a cycle
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(null); //Removing the cyclic dependency
		
		System.out.println("Case2: Does the list have a cycle? " + hasCycle(node1));
	}
	
	public static boolean hasCycle(ListNode head) {
		Map<ListNode,ListNode> map = new HashMap<ListNode,ListNode>(); //This stores the addresses of the listnodes as and when we are scanning them
		ListNode temp = head;
		if(temp == null)
			return false;
		while(temp != null) {
			if(map.get(temp) == null) { //New node not traversed before
				map.put(temp, temp); //putting the node address in the hashmap
				temp = temp.getNext(); //advancing the temp pointer to the next node
			}else {
				return true; //loop detected
			}
		}
		return false;
	}
}
