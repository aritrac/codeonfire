package ds.soln.aritra;

import java.util.Arrays;
import java.util.Comparator;

import ds.soln.aritra.utilities.ListNode;

/*
 * Author: Aritra Chatterjee
 * Date: 7th July 2018
 * Description: This code finds the start of the merging point of two lists using sort and search technique.
 * First we scan the next pointers of the first list and store them in an array.
 * We sort the array 
 * The we scan the second list, and for each second list node address, we do a binary search in the array to find if the address is there.
 * If we find it, then we have found the starting of the merge point of both the lists
 */

public class Prob002_015_FindMergingPointOf2ListsSortAndSearchAppr {
	public static void main(String[] args) {
		//The common node
		ListNode commonNode = new ListNode(22);
		
		//Creating the first linked list
		LinkedList llOne = new LinkedList();
		llOne.insertAtEnd(new ListNode(12));
		llOne.insertAtEnd(new ListNode(13));
		llOne.insertAtEnd(commonNode); //Putting the intersection at this point in the list
		llOne.insertAtEnd(new ListNode(30));
		llOne.insertAtEnd(new ListNode(31));
		llOne.insertAtEnd(new ListNode(32));
		llOne.insertAtEnd(new ListNode(36));
		
		//The first linkedList
		System.out.println(llOne);
		
		//Creating the second linked list and also putting the common node
		LinkedList llTwo = new LinkedList();
		llTwo.insertAtEnd(new ListNode(4));
		llTwo.insertAtEnd(new ListNode(7));
		llTwo.insertAtEnd(new ListNode(11));
		llTwo.insertAtEnd(commonNode); //Putting the intersection at this point in the list
		
		//The second linkedList
		System.out.println(llTwo);
		
		ListNode mergeNode = findMergePointOf2ListsSortAndSearchAppr(llOne, llTwo);
		
		if(mergeNode == null)
			System.out.println("The lists do not intersect");
		else
			System.out.println("The lists merge at " + mergeNode.getData());
		
	}
	
	public static ListNode findMergePointOf2ListsSortAndSearchAppr(LinkedList llOne, LinkedList llTwo) {
		//Creating an array of node addresses from the first list
		ListNode[] addrArr = new ListNode[llOne.length()];
		int addArrIdx = 0;
		
		//Scanning the first list and populating the array
		ListNode temp = llOne.getHead();
		while(temp != null) {
			addrArr[addArrIdx++] = temp;
			temp = temp.getNext();
		}
		
		//Printing out the array content
		System.out.println("Before Sort");
		printArr(addrArr);
		
		//Sorting the array content
		Arrays.sort(addrArr, new SortListNodes());
		
		//Printing out the array content post sorting
		System.out.println("After Sort");
		printArr(addrArr);
		
		//Printing the content of the secondList
		System.out.println("Second list content: " + llTwo);
		
		//Scanning the second list to find if any node matches with the first list nodes or not. If that is the case, then we found our merge start node
		temp = llTwo.getHead();
		ListNode foundNode = null; //This will store the merge start node address
		
		while(temp != null) {
			foundNode = getNodeFromBinarySearch(temp, addrArr);
			if(foundNode != null) { //Found the matching node, we can stop the loop now
				break;
			}
			temp = temp.getNext();
		}
		return foundNode;
	}
	
	//Prints the array
	public static void printArr(ListNode[] arr) {
		for(ListNode node : arr) {
			System.out.println("Address: " + node + " Data: " + node.getData());
		}
	}
	
	//Searches for a particular node address in the array
	public static ListNode getNodeFromBinarySearch(ListNode node, ListNode[] addrArr) {
		int begin = 0; //Initializing the begin pointer for binary search
		int end = addrArr.length - 1; //Initializing the end pointer for binary search
		while(begin <= end) {
			int mid = begin + (end - begin)/2;
			System.out.println("Begin :" + begin + " End:" + end + " Mid:" + mid);
			if(addrArr[mid] == node) { //Found the node, return it
				return node; 
			}
			if(addrArr[mid].hashCode() < node.hashCode()) { //The address is in the right half
				begin = mid + 1;
			}else { //The address is in the left half
				end = mid - 1;
			}
		}
		System.out.println("Done one iteration");
		return null; //The node was not found, means the lists do not intersect, hence return null
	}
}

//Custom comparator class for sorting the array of node addresses based on its hashcode
final class SortListNodes implements Comparator<ListNode>{

	@Override
	public int compare(ListNode o1, ListNode o2) {
		Integer o1Hash = o1.hashCode();
		Integer o2Hash = o2.hashCode();
		return o1Hash.compareTo(o2Hash);
	}
	
}
