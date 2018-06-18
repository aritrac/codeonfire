package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 18/06/2018
 * Description: This class has the implementation of a Singly Linked List with the following operations supported
 * 1)Get head of the List
 * 2)Insert a node at the beginning of the list
 * 3)Insert a node at the end of the list
 * 4)Insert a node at a given position of the list
 */
public class LinkedList {
	//This is the only field of the class. It holds the head of the list
	ListNode head;
	
	//Length of the Linked List
	private int length = 0;
	
	//This class has a default constructor
	public LinkedList() {
		length = 0;
	}
	
	//Return the first node in the List
	public synchronized ListNode getHead() {
		return head;
	}
	
	//Insert a node at the beginning of the list
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	//Insert a node at the end of the list
	public synchronized void insertAtEnd(ListNode node) {
		if(head == null) {
			head = node;
		}else {
			ListNode p,q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
			length++;
		}
	}
	
	//Add a new value to the list at a given position
	//All values at that position to the end move over to make room for the new element
}
