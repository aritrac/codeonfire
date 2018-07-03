package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 3rd July 2018
 * Description: This approach finds the Nth node from the last in a linked list using two pointers
 * We will have two pointers nthPointer lastPointer. Both the pointers will start at the head node.
 * Then we will move lastPointer N times, once the move has been completed, then we will move both
 * the pointers at the same time. When lastPointer is at the last node, the nthPointer will be pointing
 * to the Nth node from the last.
 */

public class FindNthNodeFromTheEndTwoPointers {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(new ListNode(4));
		ll.insertAtEnd(new ListNode(12));
		ll.insertAtEnd(new ListNode(15));
		ll.insertAtEnd(new ListNode(8));
		ll.insertAtEnd(new ListNode(2));
		
		//Inserting elements in the list in the following order
		//4 -> 12 -> 15 -> 8 -> 2
		
		//Printing out the list
		System.out.println(ll);
		
		//printing 2nd node from the last using the two pointers approach
		printNthNodeFromLast(2,ll);
	}
	
	public static void printNthNodeFromLast(int N, LinkedList ll) {
		ListNode nthPointer = ll.getHead();
		ListNode lastPointer = ll.getHead();
		
		while(N-- > 1) { //Moving last pointer N - 1 nodes ahead of head node
			lastPointer = lastPointer.getNext();
		}
		
		while(lastPointer.getNext() != null) { //Now moving both the pointers simultaneously
			nthPointer = nthPointer.getNext();
			lastPointer = lastPointer.getNext();
		}
		
		System.out.println("Nth pointer from the last = " + nthPointer.getData());
	}
}
