package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 25/06/2018
 * Description: This implementation shows how to print the Nth node from the end of the linked list
 * This is a simple approach in which we traverse the list to get the length of the list, then subtract the value of N from it
 * and then from the start traverse Length - N nodes to arrive at the required node
 */

public class FindNthNodeFromTheEndBruteForce {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		//Inserting the nodes into the list
		//60 50 40 30 20 44 55
		ll.insertAtBegin(new ListNode(20));
		ll.insertAtBegin(new ListNode(30));
		ll.insertAtBegin(new ListNode(40));
		ll.insertAtBegin(new ListNode(50));
		ll.insertAtBegin(new ListNode(60));
		ll.insertAtEnd(new ListNode(44));
		ll.insertAtEnd(new ListNode(55));
		
		//printing out the current state of the list
		System.out.println(ll);
		
		//printing 1st Node from the last which is 55
		printNthNodeFromLast(1, ll);
		
		//printing the 3rd node which is 20 from the last
		printNthNodeFromLast(3, ll);
		
		//printing the 6th node which is 50 from the last
		printNthNodeFromLast(6, ll);
		
		//printing the 7th node which is 60 from the last
		printNthNodeFromLast(7, ll);
		
		//printing the 8th node which is INVALID from the last
		printNthNodeFromLast(8, ll);
	}
	
	public static void printNthNodeFromLast(int N, LinkedList ll) {
		if(N > ll.length()) {
			System.out.println("N exceeds the size of the list");
			return;
		}
		if(ll.getHead() == null) {
			System.out.println("List is empty");
			return;
		}
		ListNode current = ll.getHead();
		int i = 0;
		while(i++ < ll.length() - N) {
			current = current.getNext();
		}
		System.out.println(N + "th node from end is = " + current.getData());
	}
}
