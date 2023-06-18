package linkedListPackage;

public class Palindrome {
	
	Node head;
	class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	void addNode(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	void ReverseList() {
		if(head == null || head.next == null) {
			return;
		}
		Node prev = head;
		Node curr = head.next;	
		while(curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			
			//update
			prev = curr;
			curr = nextNode;
		}
		head.next = null;
		head = prev;
		
		Node curNode = head;
		while(curNode != null) {
			System.out.print(curNode.data + "->");
			curNode = curNode.next;
		}
		System.out.println("null");
	}

	void printList() {
		Node curNode = head;
		while(curNode != null) {
			System.out.print(curNode.data + "->");
			curNode = curNode.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		Palindrome list = new Palindrome();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.printList();
		list.ReverseList();

	}

}
