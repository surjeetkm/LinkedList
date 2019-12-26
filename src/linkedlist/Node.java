package linkedlist;

public class Node {

	protected int data;
	protected Node next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(int data) {
		this.data=data;
		next=null;
	}
	
}
