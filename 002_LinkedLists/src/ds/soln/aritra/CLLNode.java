package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 23/06/2018
 * Description: This class defines a Circular Linked List node
 */
public class CLLNode {
	public int data;
	public CLLNode next;
	
	public CLLNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setNext(CLLNode next) {
		this.next = next;
	}
	
	public CLLNode getNext() {
		return next;
	}
}
