package blatt2;

public class ArraySet extends AbstractSet{
	
	public static final int capacity = 8;
	private int size;
	private int elem[];
	
	public ArraySet() {	
		clear();
	}

	public final void clear() {
		size = 0;
	    elem = new int[capacity];		
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void increaseCapacity(int newCap) {
		if(newCap < size)
			return;
		int[] old = elem;
		elem = new int[newCap];
        System.arraycopy(old, 0, elem, 0, size); 
	}

	@Override
	public void add(int x) {
		if(elem.length == size) {
			increaseCapacity(2*size);
		}
		if(!contains(x)) {
			elem[size] = x;
			size++;
		}
	}	

	@Override
	public void remove(int x) {
		for (int i = 0; i < size ; i++) {
			if(elem[i]==x) {
				for (int j = i ; j < size; j++) {
					elem[j] = elem[j + 1];
				}
				size--;
				break;
			}
		}
	}

	@Override
	public boolean contains(int x) {
		
//		for (Integer i : elem) {
//			if(i.equals(x))
//				return true;
//		}
		for (int i = 0; i < size; i++) {
			if(get(i)==x)
			return true;	
		}
			return false;
	}

	public int get(int i) {
//		if(i >= 0 || i < size) {
			return elem[i];
//		}	
//		return i;
	}
	
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder("Elemente : " ); 
        for (int i = 0; i < size; i++) { 
            s.append(elem[i]).append(", "); 
        } 
        s.append("[[[[size = ").append(size).append("]]]]"); 
        return s.toString(); 
	}

}
