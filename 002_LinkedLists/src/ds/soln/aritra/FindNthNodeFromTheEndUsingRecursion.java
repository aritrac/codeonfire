package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 3rd July 2018
 * Description: In this approach, we print the Nth node from the last in a linked list using recursion.
 * We use recursion to go to the last element, on hitting the last element we trace back N elements and
 * print out the Nth element from the last
 */

public class FindNthNodeFromTheEndUsingRecursion {
	
	private static int n = 0;
	
	public static void main(String[] args) {
		//Creating the linked list
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(new ListNode(12));
		ll.insertAtEnd(new ListNode(22));
		ll.insertAtEnd(new ListNode(13));
		ll.insertAtEnd(new ListNode(17));
		ll.insertAtEnd(new ListNode(89));
		ll.insertAtEnd(new ListNode(100));
		
		//Printing out the list
		System.out.println(ll);
		
		//Print the Nth node from the last
		printNthNodeFromLast(3,ll.getHead());
	}
	
	public static void printNthNodeFromLast(int N, ListNode head) {
		if(head == null) //If the list is empty, return
			return;
		if(head.getNext() != null) { //Call the method recursively, until the last node is reached
			printNthNodeFromLast(N, head.getNext()); 
			n++;//this will start incrementing when the recursion call starts returning from the last node
		}
		if(n == N - 1) {//We will check if n's value is Nth from the last or not on each method return and print out the corresponding value
			System.out.println("The Nth node is " + head.getData());
		}
	}
}
