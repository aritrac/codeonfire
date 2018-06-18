package ds.soln.aritra;

/*
 * Author: Aritra Chatterjee
 * Date: 18/06/2018
 * Description: This class defines a Linked List node
 */
public class ListNode {
	private int data;
	private ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getNext() {
		return next;
	}
}
