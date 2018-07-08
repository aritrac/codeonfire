package ds.soln.aritra;

import java.util.Dictionary;
import java.util.Hashtable;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: In this approach we find the middle of the list using a HashTable with the following steps
 * 1)We will scan the list and put all the node addresses in the HashTable
 * 2)Next we will find the size of the hash table, calculate the index of the middle element
 * 3)Read the node address of the middle element based on the index calculated
 */

public class Prob002_018_FindMiddleOfListHashTableAppr {
	public static void main(String[] args) {

		// Creating a list having odd number of elements
		LinkedList ll = new LinkedList();

		ll.insertAtEnd(new ListNode(1));
		ll.insertAtEnd(new ListNode(2));
		ll.insertAtEnd(new ListNode(3));
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(5));

		// Printing out the list
		System.out.println(ll);

		ListNode midNode = findMiddleOfListHashTable(ll); // The middle element

		System.out.println("The middle of list contains " + midNode.getData());

		// Creating a list having even number of elements
		LinkedList ll2 = new LinkedList();

		ll2.insertAtEnd(new ListNode(1));
		ll2.insertAtEnd(new ListNode(2));
		ll2.insertAtEnd(new ListNode(3));
		ll2.insertAtEnd(new ListNode(4));

		// Printing out the list
		System.out.println(ll2);

		midNode = findMiddleOfListHashTable(ll2); // The middle element

		System.out.println("The middle of list contains " + midNode.getData());
	}

	public static ListNode findMiddleOfListHashTable(LinkedList ll) {
		// Creating an empty hash table to store the node addresses
		Dictionary<Integer, ListNode> table = new Hashtable<Integer, ListNode>();

		ListNode temp = ll.getHead();

		int idx = 0; // This will be the index which serves as key in the HashTable

		// Putting all list nodes in the hash table
		while (temp != null) {
			table.put(++idx, temp);
			temp = temp.getNext();
		}

		int size = table.size();

		if (size % 2 == 0) { // if the list is even
			return table.get(size / 2);
		} else {
			return table.get((size / 2) + 1);
		}
	}
}
