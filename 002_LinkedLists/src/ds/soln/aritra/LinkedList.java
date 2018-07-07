package ds.soln.aritra;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 18/06/2018
 * Description: This class has the implementation of a Singly Linked List with the following operations supported
 * 1)Get head of the List
 * 2)Insert a node at the beginning of the list
 * 3)Insert a node at the end of the list
 * 4)Insert a node at a given position of the list
 * 5)Remove and return the node at the head of the list
 * 6)Remove and return the node at the end of the list
 * 7)Remove a node matching the specified node from the list
 * 8)Remove the value at a given position
 * 9)Return a string representation of this collection, in the form ["str1","str2",...]
 * 10)Return the current length of the list
 * 11)Find the position of the first value that is equal to a given value
 * 12)Remove everything from the list
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
	public void insert(int data, int position) {
		//fix the position
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		//If the list is empty, make it be the only element
		if(head == null) {
			head = new ListNode(data);
		}
		//If adding at the front of the list
		else if(position == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		}
		//else find the correct position and insert
		else {
			ListNode temp = head;
			for(int i = 1; i<position; i+=1) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		//The list is now one value longer
		length += 1;
	}
	
	//Iteratively reverse a linked list
	public void reverseIterative() {
		ListNode current = head; //storing the head in a temporary value
		ListNode prev = null;
		
		while(current != null) {
			ListNode next = current.getNext(); //Saving the next node
			//make current point to the previous node as we are reversing it
			current.setNext(prev);
			//bringing prev to current
			prev = current;
			//updating current to reverse the next node in sequence
			current = next;
		}
		head = prev; //post reversal, the head will be at the other end, setting head to current at the end of loop will make it null, hence assigning only prev value to it
	}
	
	//Recursive reversal of a linked list
	public void reverseRecursive(ListNode prev, ListNode current) {
		if(current == null) {
			head = prev; //As this is the final step, setting the head to the other end
			return;
		}
		ListNode next = current.getNext(); //storing the current node in next
		current.setNext(prev); //making current point to the previous node
		reverseRecursive(current,next); //making prev = current and current = next for the next recursive call
	}
	
	//Remove and return the node at the head of the list
	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if(node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}
	//Remove and return the node at the end of the list
	public synchronized ListNode removeFromEnd() {
		if(head == null)
			return null;
		ListNode p = head, q =null, next = head.getNext();
		if(next == null) {
			head = null;
			return p;
		}
		while((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		return p;
	}
	//Remove a node matching the specified node from the list
	//Use equals() instead of == to test for a matched node
	public synchronized void removeMatched(ListNode node) {
		if(head == null)
			return;
		if(node.equals(head)) {
			head = head.getNext();
			return;
		}
		ListNode p = head, q = null;
		while((q = p.getNext()) != null) {
			if(node.equals(q)) {
				p.setNext(q.getNext());
				return;
			}
			p=q;
		}
	}
	//Remove the value at a given position
	//If the position is less than 0, remove the value at position 0
	//If the position is greater than length, remove the value at the last position
	public void remove(int position) {
		//fix position
		if(position < 0) {
			position = 0;
		}
		if(position >= length) {
			position = length - 1;
		}
		//If nothing is in the list, do nothing
		if(head == null)
			return;
		//if removing the head element
		if(position == 0) 
			head = head.getNext();
		//else advance to the correct position and remove
		else {
			ListNode temp = head;
			
			for(int i = 1; i < position; i+=1) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		
		//Reduce the length of the list
		length -= 1;
	}
	
	//Return a string representation of this collection, in the form ["str1","str2",...]
	public String toString() {
		String result = "[";
		if(head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		
		while(temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
	
	//Return the current length of the list
	public int length() {
		return length;
	}
	
	//Find the position of the first value that is equal to a given value
	//The equals method is used to determine equality
	public int getPosition(int data) {
		//go looking for the data
		ListNode temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.getData() == data) {
				//return the position if found
				return pos;
			}
			pos+=1;
			temp = temp.getNext();
		}
		//else return some large value
		return Integer.MAX_VALUE;
	}
	
	//This method inserts element into a sorted linked list
	public boolean insertBySortOrder(int element){
		ListNode temp = head;
		ListNode current = head;
		
		while(current != null && current.data < element) {
			temp = current; //stores the node previous to current in each iteration
			current = current.getNext();
		}
		
		
		ListNode newNode = new ListNode(element);
		
		if(current == head) { // If node was inserted before the head of the list
			newNode.setNext(current); //making the first newly added node to point to the previous first node
			head = newNode; //Changing the head to point to the newly added node
		}else {
			temp.setNext(newNode);
			newNode.setNext(current);
		}
		
		return true;
	}
	
	//Remove everything from the list
	public void clearList() {
		head = null;
		length = 0;
	}
}
