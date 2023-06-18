package linkedListPackage;

public class LL1 {
	private int size=0;
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
	
	void printList() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next; 
		}
		System.out.println("null");
	}
	
	int getSize() {
		Node curr = head;
		while(curr != null) {
			curr = curr.next;
			size ++;
		}
		return size;
	}
	
	void findNodeAndDelete(int size, int nodeIndex) {
		Node curr = head; 
		if(size > nodeIndex) {
		for(int i=0; i<size - nodeIndex; i++) {
			curr = curr.next;
		}
		System.out.println(curr.next.data);
		curr.next = curr.next.next;
		Node newcur = head;
		for(int i=0; i<size-1; i++) {
			System.out.print(newcur.data + "->");			
			newcur = newcur.next;
		}
		System.out.println("null");
		}
		
	}
	
	public static void main(String[] args) {
		LL1 nodelist = new LL1();
		nodelist.addNode(1);
		nodelist.addNode(2);
		nodelist.addNode(3);
		nodelist.addNode(4);
		nodelist.addNode(5);
		nodelist.addNode(6);
		nodelist.printList();
		int ssize = nodelist.getSize();
		nodelist.findNodeAndDelete(ssize, 3);

	}

}
