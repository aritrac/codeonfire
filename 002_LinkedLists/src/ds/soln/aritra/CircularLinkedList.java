package ds.soln.aritra;

import ds.soln.aritra.utilities.CLLNode;

/*
 * Author: Aritra Chatterjee
 * Date: 23/06/2018
 * Description: A Circular Linked List implementation which has the following operations
 * 1)Add data to the beginning of list
 * 2)Add element to the tail of list
 * 3)Return data at the head of list
 * 4)Returns data at the tail of list
 * 5)Returns and removes data from head of list
 * 6)Returns and removes data from tail of list
 * 7)Returns if the list contains the data and returns true else false
 * 8)Removes and returns element equal to data, or null
 * 9)Returns the length of the CLL
 * 10)Returns whether the CLL contains no element at all
 * 11)Removes everything from CLL
 * 12)Returns a string representation of this collection, in the form: ["str1","str2",...]
 */
public class CircularLinkedList {
	protected CLLNode tail;
	protected int length;
	
	//Constructs a new circular list
	public CircularLinkedList() {
		tail = null;
		length = 0;
	}
	
	//Adds data to beginning of list
	public void add(int data) {
		addToHead(data);
	}
	
	//Adds element to head of list
	public void addToHead(int data) {
		CLLNode temp = new CLLNode(data);
		if(tail == null) {//first data added
			tail = temp;
			tail.setNext(tail); //Head tail is pointing to temp, also tail.getNext() points to temp, hence the else part works
		}else {//there are elements in the list
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}
	
	//Adds element to tail of list
	public void addToTail(int data) {
		//new entry
		addToHead(data);
		tail = tail.getNext();
	}
	
	//Returns data at the head of list
	public int peek() {
		return tail.getNext().getData();
	}
	
	//Returns data at tail of list
	public int tailPeek() {
		return tail.getData();
	}
	
	//Returns and removes data from head of list
	public int removeFromHead() {
		CLLNode temp = tail.getNext();	//the head of the list
		if(tail == tail.getNext()) { //If there is only one element in the list
			tail = null;
		}else {
			tail.setNext(temp.getNext());
			temp.setNext(null);//helps clean things up; temp is free
		}
		length--;
		return temp.getData();
	}
	
	//Returns true if no elements are in the list
	public boolean isEmpty() {
		return tail == null;
	}
	
	//Returns and removes data from tail of list
	public int removeFromTail() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		CLLNode finger = tail;
		while(finger.getNext() != tail) {
			finger = finger.getNext();
		}
		//finger now points to second-to-last data
		CLLNode temp = tail;
		if(finger == tail) { //In case the list has only one element
			tail = null;
		}else {
			finger.setNext(tail.getNext());
			tail = finger;
		}
		length--;
		return temp.getData();
	}
	
	//Returns true if list contains data, else false
	public boolean contains(int data) {
		if(tail == null)
			return false;
		CLLNode finger;
		finger = tail.getNext(); //Finger points to the first node
		while(finger != tail && (!(finger.getData() == data))) {
			finger = finger.getNext();
		}
		return finger.getData() == data;
	}
	
	//Removes and returns element equal to data, or null
	public int remove(int data) {
		if(tail == null)
			return Integer.MIN_VALUE;
		CLLNode finger = tail.getNext();
		CLLNode previous = tail;
		int compares;
		for(compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
			previous = finger;
			finger = finger.getNext();
		}
		if(finger.getData() == data) {
			//an example of the pigeon-hole principle
			if(tail == tail.getNext()) { //If there is only one element in the list
				tail = null;
			}else {
				if(finger == tail) // if the element was found at the tail
					tail = previous;
				previous.setNext(previous.getNext().getNext());
			}
			//finger data free
			finger.setNext(null); //to keep things disconnected
			length--;			  //fewer elements
			return finger.getData();
		}else {
			return Integer.MIN_VALUE; //Element not found!
		}
	}
	
	//Return the current length of the CLL.
	public int size() {
		return length;
	}
	
	//Return the current length of the CLL.
	public int length() {
		return length;
	}
	
	//Removes everything from the CLL.
	public void clear() {
		length = 0;
		tail = null;
	}
	
	//Returns a string representation of this collection, in the form: ["str1","str2",...]
	public String toString() {
		String result = "[";
		if(tail == null) {
			return result + "]";
		}
		CLLNode temp = tail.getNext();
		while(temp != tail) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		result = result + "," + tail.getData();
		return result + "]";
	}
}
