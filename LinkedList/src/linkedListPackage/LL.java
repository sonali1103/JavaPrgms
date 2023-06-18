package linkedListPackage;

public class LL {
	int size = 0;
	Node head;
	class Node {
		String data;
		Node next;
		
		Node(String data){
			this.data = data;
			this.next = null;
		}
	}
		
	public void addFirst(String data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(String data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
	}
	
	public void deleteFirst() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		head = head.next;
		size--;
	}
	public void deleteLast() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		size--;
		if(head.next == null) {
			head = null;
			return;
		}
		Node curr = head;
		while(curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
	}
	
	public void printNode() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;		
		}
		System.out.println("null");
	}
	public void printSize() {
		System.out.println(size);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LL list = new LL();
		list.addFirst("Sonali");
		list.addFirst("hello");
		list.addLast("How");
		list.addLast("are");
		list.addLast("you?");
		list.printNode();
		list.deleteFirst();
		list.deleteFirst();
		list.printNode();
		list.printSize();
		list.addFirst("Rani");
		list.addFirst("hello");
		list.printNode();
		list.printSize();
		list.deleteFirst();
		list.printNode();
		list.deleteFirst();
		list.printNode();
		list.deleteFirst();
		list.printNode();
		list.deleteFirst();
		list.printNode();
		list.deleteFirst();
		list.printNode();
		list.printSize();

	}

}
