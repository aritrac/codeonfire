package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 21/06/2018
 * Description: An implementation of Doubly Linked List which has the following operations
 * 1)Get the value at a given position
 * 2)Get the first position where a data occurs
 * 3)Return the current length of the DLL
 * 4)Add a new value to the front of the list
 * 5)Add a new value to the list at a given position
 * 6)Add a new value to the rear of the list
 * 7)Remove the value at a given position
 */

public class DoublyLinkedList {
	//properties
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	//Create a new empty list
	public DoublyLinkedList() {
		head = new DLLNode(Integer.MIN_VALUE,null,null);
		tail = new DLLNode(Integer.MIN_VALUE,null,null);
		head.setNext(tail);
		length = 0;
	}
	
	//Get the value at a given position
	public int get(int position) {
		if(head == null)
			return Integer.MIN_VALUE;
		else {
			DLLNode temp = head;
			while(position-- >= 0) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
	}
	
	//Find the position of the head value that is equal to a given value
	//The equals method is used to determine equality
	public int getPosition(int data) {
		//go looking for the data
		DLLNode temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.getData() == data) {
				//return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		//else return some large value
		return Integer.MIN_VALUE;
	}
	
	//Return the current length of the DLL
	public int length() {
		return length;
	}
	
	//Add a new value to the front of the list
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue, null, head.getNext());
		newNode.getNext().setPrev(newNode);
		head = newNode;
		length += 1;
	}
	
	//Add a new value to the list at a given position
	//All values at that position to the end move over to make room
	public void insert(int data, int position) {
		//fix the position
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		//if the list is empty, make it be the only element
		if(head == null) {
			head = new DLLNode(data);
			tail = head;
		}
		//if adding at the front of the list...
		else if(position == 0) {
			DLLNode temp = new DLLNode(data);
			temp.setNext(head);
			head = temp;
		}
		//else find the correct position and insert
		else {
			DLLNode temp = head;
			for(int i = 1; i < position; i+=1) {
				temp = temp.getNext();
			}
			DLLNode newNode = new DLLNode(data);
			newNode.setNext(temp.getNext());
			newNode.setPrev(temp);
			newNode.getNext().setPrev(newNode);
			temp.setNext(newNode);
		}
		//the list is now one value longer
		length += 1;
	}
	
	//Add a new value to the rear of the list.
	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, tail.getPrev(), tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length += 1;
	}
	
	//Remove the value at a given position
	//If the position is less than 0, remove the value at position 0.
	//If the position is greater than 0, remove the value at the last position
	public void remove(int position) {
		//fix position
		if(position < 0) {
			position = 0;
		}
		if(position >= length) {
			position = length - 1;
		}
		
		//If nothing in the list, do nothing
		if(head == null)
			return;
		//If removing the head element...
		if(position == 0) {
			head = head.getNext();
			if(head == null)
				tail = null;
		}
		//else advance to the correct position and remove
		else {
			DLLNode temp = head;
			for(int i = 1; i < position; i+=1) {
				temp = temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}
		//reduce the length of the list
		length -= 1;
	}
	
	
}
