package blatt2;

public class LinkedListSet extends AbstractSet{
	
	private Node head;
	private int size;
	
	
	public LinkedListSet() {
		clear();
	}

	static private class Node {
		private Node next;
		private int data;
		public Node(int x, Node p) {
			data = x;
			next = p;

		}
		
	}
	
	public final void clear() {
		head = new Node(0,null); // Hilfsknoten
		size = 0;
		
	}
	public int size() {
		return size ;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(int x) {
		Node p = head;
		while(p.next != null && p.next.data < x) {
			p = p.next;
		}
		
		if(p.next != null && p.next.data == x) {
			return;
		}
		
		p.next = new Node(x,p.next);
		size++;
	}
		
	


	public boolean contains(int x) {
		Node p = head.next;
		while(p != null && p.data != x) {   
				p = p.next;		
		}
		if(p == null) {
			return false;
		}	
		else {
	//		System.out.println(x + "  ist NICHT in der Liste");
			return true;
		}
	}

	public void remove(int x){

		Node p = head;
		while(p.next != null && p.next.data != x) {
			p = p.next;
		}
		if(p.next == null) {
		//	System.out.println("node does not exist ");
			return;
		}
		else {
			p.next = p.next.next;
			size--;
		}
	}

	public int get(int index) {
		if (index < 0 || index >= size) 
		throw new IndexOutOfBoundsException();
		Node p = head.next;
		for (int i = 0 ; i< index; i++)
			p = p.next;
		return p.data;
	}
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder(""); 
        for(Node p = head.next ; p != null; p = p.next ) {
            s.append(p.data).append(", "); 
        }
        s.append("size = ").append(size); 
        return s.toString();
	}

	

}
