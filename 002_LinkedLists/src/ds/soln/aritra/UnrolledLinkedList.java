package ds.soln.aritra;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
 * Author: Aritra Chatterjee
 * Date: 23/06/2018
 * Description: Contains the implementation of an Unrolled Linked Lists or Linked Block. In short suppose we have 16 elements
 * these elements with be in root(n) blocks which is 4 blocks and each block will have root(n) which is again 4 elements
 * So the 16 elements will be present in 4 blocks and each block will contain 4 elements
 * 
 *  If we need the 13th element from this List, we will first go to 13/4th block which is 3rd block and then within that block will go to 13 mod 4th element which is 1 which
 *  is the second element in the 3rd block. This structure needs to be adhered to in case of additions and deletions to the list
 *  
 *  So a insert or delete in one of the blocks, will have a cascading effect on the other blocks
 *  Each block is implemented as a singly linked list and each elements in the block is represented as a circular linked list.
 *  
 *  So if one of the blocks reaches capacity and there is an insert, we insert the element at the head of that block and remove the tail element of that same block
 *  then in the next block, we add the removed tail element as the head of its list and then remove the tail of this block and continue in the same way for the other block
 */

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E> ,Serializable{
	//The maximum number of elements that can be stored in a single node.
	private int nodeCapacity;
	//The current size of this list.
	private int size = 0;
	//The first node of this list.
	private ListNode firstNode;
	//The last node of this list.
	private ListNode lastNode;
	//Constructs an empty list with the specified capacity
	public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
		if(nodeCapacity < 8) {
			throw new IllegalArgumentException("nodeCapacity < 8");
		}
		this.nodeCapacity = nodeCapacity;
		firstNode = new ListNode();
		lastNode = firstNode;
	}
	
	public UnrolledLinkedList() {
		this(16);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//Returns true if this list contains the specified element
	public boolean contains(Object o) {
		return (indexOf(o) != -1);
	}
	
	public Iterator<E> iterator(){
		return new ULLIterator(firstNode,0,0);
	}
	
	//Append the specified element to the end of this list
	public boolean add(E e) {
		insertIntoNode(lastNode, lastNode.numElements, e);
		return true;
	}
	
	//Removes the first occurrence of the specified element from this list.
	public boolean remove(Object o) {
		ListNode node = firstNode;
		if(o == null) {
			while(node != null) {
				for(int ptr = 0; ptr < node.numElements; ptr++) {
					if(node.elements[ptr] == null) {
						removeFromNode(node, ptr);
						return true;
					}
				}
				node = node.next;
			}
		}else {
			while(node != null) {
				for(int ptr = 0; ptr < node.numElements; ptr++) {
					if(o.equals(node.elements[ptr])) {
						removeFromNode(node, ptr);
						return true;
					}
				}
				node = node.next;
			}
		}
		return false;
	}
	
	//Removes all of the elements from this list.
	public void clear() {
		ListNode node = firstNode.next;
		while(node != null) {
			ListNode next = node.next;
			node.next = null;
			node.previous = null;
			node.elements = null;
			node = next;
		}
		lastNode = firstNode;
		for(int ptr = 0; ptr < firstNode.numElements; ptr++) {
			firstNode.elements[ptr] = null;
		}
		firstNode.numElements = 0;
		firstNode.next = null;
		size = 0;
	}
	
	//Returns the element at the specified position in this list.
	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode node;
		int p = 0;
		if(size - index > index) { //Finding out where the index lies closer to. Is it the firstNode or the lastNode
			node = firstNode;
			while(p <= index - node.numElements) {//Finding out which block the index lies in starting from front
				p += node.numElements;
				node = node.next;
			}
		}else {
			node = lastNode;
			p = size;
			while((p -= node.numElements) > index) { //Finding out which block the index lies in starting from back
				node = node.previous;
			}
		}
		return (E)node.elements[index - p]; //Returns the specific element within the block
	}
	
	//Replaces the element at the specified position in this list with the specified element.
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E el = null;
		ListNode node;
		int p = 0;
		//Same logic as above to get to the specific element
		if(size - index > index) {
			node = firstNode;
			while(p <= index - node.numElements) {
				p += node.numElements;
				node = node.next;
			}
		}else {
			node = lastNode;
			p = size;
			while((p -= node.numElements) > index) {
				node = node.previous;
			}
		}
		//Simple node value replacement logic
		el = (E) node.elements[index - p];
		node.elements[index - p] = element;
		return el;
	}
	
	//Inserts the specified element at the specified position in this list.
	//Shifts the element currently at that position (if any) and any
	//subsequent elements to the right (adds one to their indices).
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode node;
		int p = 0;
		//Same logic as above to find the specified element in a block
		if(size - index > index) {
			node = firstNode;
			while(p <= index - node.numElements) {
				p += node.numElements;
				node = node.next;
			}
		}else {
			node = lastNode;
			p = size;
			while((p -= node.numElements) > index) {
				node = node.previous;
			}
		}
		//Calls this to do the insert and right adjust the entire ULL and sends the location within the node where the insertion should happen.
		insertIntoNode(node, index - p, element);
	}
	
	//Removes the element at the specified position in this list.
	//Shifts any subsequent elements to the left (subtracts one from their indices).
	@SuppressWarnings("unchecked")
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E element = null;
		ListNode node;
		int p = 0;
		//Same logic as above to get to the specified index
		if(size - index > index) {
			node = firstNode;
			while(p <= index - node.numElements) {
				p += node.numElements;
				node = node.next;
			}
		}else {
			node = lastNode;
			p = size;
			while((p -= node.numElements) > index) {
				node = node.previous;
			}
		}
		element = (E)node.elements[index - p]; //Storing the element which will be removed for returning
		//Calls this to remove the index within the block and also left adjust the entire ULL
		removeFromNode(node, index - p);
		return element;
	}
	
	private void insertIntoNode(ListNode node, int ptr, E element) {
		//if the node is full
		if(node.numElements == nodeCapacity) {
			//create a new node
			ListNode newNode = new ListNode();
			//move half of the elements to the new node
			int elementsToMove = nodeCapacity / 2;
			int startIndex = nodeCapacity - elementsToMove;
			for(int i = 0; i < elementsToMove; i++) {
				newNode.elements[i] = node.elements[startIndex + i];
				node.elements[startIndex + i] = null;
			}
			node.numElements -= elementsToMove;
			newNode.numElements = elementsToMove;
			//insert the new node into the list
			newNode.next = node.next;
			newNode.previous = node;
			if(node.next != null) {
				node.next.previous = newNode;
			}
			node.next = newNode;
			if(node == lastNode) {
				lastNode = newNode;
			}
			//check whether the element should be inserted into
			//the original node or into the new node
			if(ptr > node.numElements) {
				node = newNode;
				ptr -= node.numElements;
			}
		}
		for(int i = node.numElements; i > ptr; i--) {
			node.elements[i] = node.elements[i - 1];
		}
		node.elements[ptr] = element;
		node.numElements++;
		size++;
		modCount++;
	}
	
	private void removeFromNode(ListNode node, int ptr) {
		node.numElements--;
		for(int i = ptr; i < node.numElements; i++) { //Left shift all the elements right to the deleted element to take up its space
			node.elements[i] = node.elements[i + 1];
		}
		node.elements[node.numElements] = null;
		if(node.next != null && node.next.numElements + node.numElements <= nodeCapacity) {
			mergeWithNextNode(node);
		}else if(node.previous != null && node.previous.numElements + node.numElements <= nodeCapacity) {
			mergeWithNextNode(node.previous);
		}
		size--;
		modCount++;
	}
	
	//This method does merge the specified node with the next node
	private void mergeWithNextNode(ListNode node) {
		ListNode next = node.next;
		for(int i = 0; i < next.numElements; i++) {
			node.elements[node.numElements + i] = next.elements[i];
			next.elements[i] = null;
		}
		node.numElements += next.numElements;
		if(next.next != null) { //Deleting the next node which becomes empty after the merge is done
			next.next.previous = node;
		}
		node.next = next.next.next;
		if(next == lastNode) {
			lastNode = node;
		}
	}
	
	private static final long serialVersionUID = -674052309103045211L; //For serializing purpose
	
	/***********START OF THE BLOCK CLASS************/
	private class ListNode{
		ListNode next;
		ListNode previous;
		int numElements = 0;
		Object[] elements;
		ListNode(){
			elements = new Object[nodeCapacity];
		}
	}
	/***********END OF THE BLOCK CLASS************/
	
	/************START OF THE CUSTOM ITERATOR*****************/
	
	private class ULLIterator implements ListIterator<E>{
		ListNode currentNode;
		int ptr;
		int index;
		private int expectedModCount = modCount;
		
		ULLIterator(ListNode node, int ptr, int index){
			this.currentNode = node;
			this.ptr = ptr;
			this.index = index;
		}
		
		public boolean hasNext() {
			return (index < size - 1);
		}
		
		@SuppressWarnings("unchecked")
		public E next() {
			ptr++;
			if(ptr >= currentNode.numElements) {
				if(currentNode.next != null) {
					currentNode = currentNode.next;
					ptr = 0;
				}else {
					throw new NoSuchElementException();
				}
			}
			index++;
			checkForModification();
			return (E)currentNode.elements[ptr];
		}
		
		public boolean hasPrevious() {
			return (index > 0);
		}
		
		@SuppressWarnings("unchecked")
		public E previous() {
			ptr--;
			if(ptr < 0) {
				if(currentNode.previous != null) {
					currentNode = currentNode.previous;
					ptr = currentNode.numElements - 1;
				}else {
					throw new NoSuchElementException();
				}
			}
			index--;
			checkForModification();
			return (E)currentNode.elements[ptr];
		}
		
		public int nextIndex() {
			return (index + 1);
		}
		
		public int previousIndex() {
			return (index - 1);
		}
		
		public void remove() {
			checkForModification();
			removeFromNode(currentNode, ptr);
		}
		
		public void set(E e) {
			checkForModification();
			currentNode.elements[ptr] = e;
		}
		
		public void add(E e) {
			checkForModification();
			insertIntoNode(currentNode, ptr + 1, e);
		}
		
		private void checkForModification() {
			if(modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	/************END OF THE CUSTOM ITERATOR*************/
}
