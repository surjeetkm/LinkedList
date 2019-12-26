package linkedlist;

import java.util.Stack;

public class SingleLinkedList {

	private Node head;
	private Node tail;
	public void add(int data) {
		if(head==null && tail==null) {
			head=new Node(data);
			tail=head;
		}else {
			tail.next=new Node(data);
			tail=tail.next;
		}
	}
	//Reverse Linkedlist using Iterative
	public void reverse_Iterative() {
		Node pre=null;
		Node current=head;
		Node nxt=null;
		while(current!=null) {
			nxt=current.next;
			current.next=pre;
			pre=current;
			current=nxt;
		}
		head=pre;
	}
	//Reverse Linkedlist using Recurssive
	public void reverse_Recursive(Node p) {
		
		if(p.next==null) {
			head=p;
			return ;
		}
		reverse_Recursive(p.next);
		Node q=p.next;
		q.next=p;
		p.next=null;
		
		//return null;
	}
	public void reverse_Recursive() {
		reverse_Recursive(head);
	}
	public Node getMiddleNode(Node n) {
		Node slow=n;
		Node fast=n.next;
		while(fast!=null) {
			fast=fast.next;
			if(fast!=null) {
				slow=slow.next;
				fast=fast.next;
			}
		}
		return slow;
	}
	//Sort LinkedList
	public Node sort(Node n) {
		if(n.next==null)
			return n;
		Node middle=getMiddleNode(n);
		Node nxt=middle.next;
		middle.next=null;
		Node left=sort(n);
		Node right=sort(nxt);
		Node tmp=merge(left, right);
		return tmp;
	}
	public Node merge(Node a, Node b) {
		if(a==null)
			return b;
		if(b==null)
			return a;
		Node tmp;
		if(a.data<b.data) {
			tmp=a;
			tmp.next=merge(a.next, b);
		}else {
			tmp=b;
			tmp.next=merge(a, b.next);
		}

		head=tmp;
		return tmp;
	}
	//Remove duplicate from Linkedlist
	public void removeDuplicate() {
		Node current=head;
		while(current!=null) {
			Node tmp=current;
			while(tmp!=null && tmp.data==current.data) {
				tmp=tmp.next;
			}
			current.next=tmp;
			current=current.next;
		}
	}
	//Remove middleNode from Linkedlist
	public void removeMiddleNode() {
		Node slow=head;
		Node fast=head.next;
		Node pre=null;
		while(fast!=null) {
			fast=fast.next;
			if(fast!=null) {
				pre=slow;
				fast=fast.next;
				slow=slow.next;
			}
		}
		if(pre!=null)
			pre.next=slow.next;
		//System.out.println("Mid:"+slow.data);
	}
	public int getLength() {
		int count=0;
		Node current=head;
		while(current!=null) {
			count++;
			current=current.next;
		}
		return count;
	}
	public int getLength(Node n) {
		if(n.next==null)
			return 1;
		return 1+getLength();
	}
	//Find Nth Node from end of LinkedList
	public void findNthNodeFromEnd(int pos) {
		if(pos>getLength() || pos==0)
		{
			System.out.println("Index Outof Bound Exception");
			return;
		}
		Node slow=head;
		Node fast=head;
		while(pos>0) {
			fast=fast.next;
			pos--;
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("NthNode from End:"+slow.data);
	}
	//Check if Linkedlist is Pallindrome
	public boolean isPallindrome(Node n) {
		Stack<Integer> stack=new Stack();
		Node tmp=n;
		Node current=n;
		while(tmp!=null) {
			stack.add(tmp.data);
			tmp=tmp.next;
		}
		while(current!=null) {
			int data=stack.pop();
			if(current.data!=data)
				return false;
			current=current.next;
		}
		return true;
	}
	//Intersection or merge point of two Linkedlist
	public Node findMergePoint(Node a,Node b) {
		int len1=getLength(a);
		int len2=getLength(b);
		int diff=0;
		if(len1>len2) {
			diff=len1-len2;
		}else {
			Node tmp=a;
			a=b;
			b=tmp;
			diff=len2-len1;
		}
		while(diff>0) {
			a=a.next;
			diff--;
		}
		while(a!=null && b!=null) {
			if(a==b)
				return a;
			a=a.next;
			b=b.next;
		}
		return null;
	}
	public void print() {
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data+",");
			tmp=tmp.next;
		}
		System.out.println();
	}
	public void print(Node n) {
		Node tmp=n;
		while(tmp!=null){
			System.out.print(tmp.data+",");
			tmp=tmp.next;
		}
		System.out.println();
	}
	public Node sort() {
		return sort(head);
	}
	public void swapAlternateData() {
		Node curnt=head;
		Node nxt=head.next;
		while(curnt!=null && nxt!=null) {
			int tmp=curnt.data;
			curnt.data=nxt.data;
			nxt.data=tmp;
			curnt=curnt.next.next;
			nxt=nxt.next.next;
		}
		
	}
	public void swapAlternateNode(int data1,int data2) {
		//10->15->12->13->20->14
		Node c1=head;
		Node c2=head;
		Node p1=null;
		Node p2=null;
		while(c1!=null) {
			if(c1.data==data1) {
				break;
			}
			p1=c1;
			c1=c1.next;
		}
		while(c2!=null) {
			if(c2.data==data2) {
				break;
			}
			p2=c2;
			c2=c2.next;
		}
		
		
	}
	public void reverseEvenElement() {
		//Given a linked list, the task is to reverse the contiguous even elements and print the updated linked list.
		//Input: 1 -> 2 -> 3 -> 3 -> 4 -> 6 -> 8 -> 5 -> NULL
		//Output: 1 2 3 3 8 6 4 5
	}
	public static void main(String[] args) {

		SingleLinkedList ll=new SingleLinkedList();
		ll.add(30);ll.add(40);ll.add(70);ll.add(20);ll.add(10);ll.add(10);ll.add(50);ll.add(10);
		ll.print();
		ll.reverse_Iterative();
		System.out.println("Reverse Linkedlist using Iterative");
		ll.print();
		System.out.println("Reverse Linkedlist using Recursive");
		ll.reverse_Recursive();
		ll.print();
		System.out.println("Sort Linkedlist");
		ll.sort();
		ll.print();
		Node mdl=ll.getMiddleNode(ll.head);
		System.out.println("MiddleNode:"+mdl.data);
		System.out.println("Removing duplicated:");
		ll.removeDuplicate();
		ll.print();
		System.out.println("Remove MiddleNode:");
		ll.removeMiddleNode();
		ll.print();
		//ll.findNthNodeFromEnd(2);
		System.out.println("Test Pallindrome:");
		/*
		 * Node n1=new Node(10); n1.next=new Node(20); n1.next.next=new Node(30);
		 * n1.next.next.next=new Node(20); n1.next.next.next.next=new Node(10); boolean
		 * b=ll.isPallindrome(n1); System.out.println(b);
		 */
		//ll.add(100);
		ll.print();
		System.out.println("Swap Alternate Node");
		ll.swapAlternateData();
		ll.print();
	}

}
