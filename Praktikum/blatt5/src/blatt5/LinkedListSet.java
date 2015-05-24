package blatt5;




public class LinkedListSet<T> extends AbstractSet<T>{

	private Node<T> head;
	private int size;
	private int modCount = 0;
	
	
	public LinkedListSet() {
		clear();
	}

	static private class Node<T> {
		private Node<T> next;
		private T data;
		public Node(T x, Node<T> p) {
			data =  x;
			next = p;

		}
		
	}
	
	public final void clear() {
		head = new Node<T>(null,null); // Hilfsknoten
		size = 0;
		modCount++;
		
	}
	public int size() {
		return size ;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(T x) {
		Node<T> p = head;
//		while(p.next != null && p.next.data < x  ) { // sort ?!! 
//			p = p.next;
//		}
//		
////		if(p.next.data == x) {
////			return;
////		}
		if(!contains(x)) {
			p.next = new Node<T>(x,p.next);
			size++;
			modCount++;
		}

	}
		
	


	public boolean contains(T x) {
		Node<T> p = head.next;
		while(p != null && p.data != x) {   // mit equals Nullpointer !
				p = p.next;		
		}
		
		if(p == null) {
			return false;
		} else {
			return true;
		}
	}

	public void remove(T x){

		Node<T> p = head;
		while(p.next != null && p.next.data != x) {
			p = p.next;
		}
		if(p.next.data != x) {
		//	System.out.println("node does not exist ");
			return;
		}
		 if (p.next != null && p.next.data ==x) {  
			p.next = p.next.next;
			size--;
		}
	}

	public T get(int index) {
		if (index < 0 || index >= size) 
		throw new IndexOutOfBoundsException();
		Node<T> p = head.next;
		for (int i = 0 ; i< index; i++)
			p = p.next;
		return p.data;
	}
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder(""); 
        for(Node<T> p = head.next ; p != null; p = p.next ) {
            s.append(p.data).append(", "); 
        }
        s.append("size = ").append(size); 
        return s.toString();
	}

	


}
