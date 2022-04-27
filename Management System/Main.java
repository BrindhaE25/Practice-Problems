/* ---- LinkedList ---- */
import java.util.*;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data= data;
		this.next = null; }
}
class LinkedList {
	Node head;
	Scanner s = new Scanner(System.in);
	
	void InsertNodeAtFront() {
		System.out.println("Enter the data:");
		int data = s.nextInt();
		Node temp = new Node(data);
		if(head == null)
			head = temp;
		else {
			temp.next = head;
			head = temp;
			
		}                                                                                                                                                                                                                                  
		
	}
	 
	void PrintLinkedList() {
		Node temp;
		temp = head;
		while(temp.next != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			
		}
			
		System.out.print(temp.data);
		
	}
	
	void InsertAtMiddle() {
		System.out.println("Enter the position to insert the element");
		int position = s.nextInt();
		Node prev = null, curr = null , aftr = null ;
		curr = head;
		for(int i=1;i<=position-1;i++) {
			prev = curr;
			curr = curr.next;
			aftr = curr.next;
			
		}
		System.out.println("Enter the data");
		int data = s.nextInt();
		Node temp = new Node(data);
		prev.next = temp;
		temp.next = curr;
		
	}
	
	void InsertNodeAtEnd() {
		System.out.println("Enter the data");
		int data = s.nextInt();
		Node newnode = new Node(data);
		Node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = newnode;
			
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ls = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose 1 - add numbers \n 0 - Stop");
		int ch = sc.nextInt();
		while(ch != 0) {
			System.out.println("Choose 1 - insert node at front \n 2 - node at middle \n 3 - at the end");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 : ls.InsertNodeAtFront();
					break;
			case 2 : ls.InsertAtMiddle();
					break;
			case 3 : ls.InsertNodeAtEnd();
					 break; 
			}

			ls.PrintLinkedList();
			System.out.println("Choose 1 - add numbers \n 0 - Stop");
			 ch = sc.nextInt();

			
		}
			
		
			}
}
