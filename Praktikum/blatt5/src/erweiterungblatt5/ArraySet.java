package erweiterungblatt5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> extends AbstractSet<T>{
	
	public static final int capacity = 8;
	private int size;
	private T[] elem;
	
	
	
	public ArraySet() {
		clear();
	}
	@SuppressWarnings("unchecked")
	private void increaseCapacity(int newCap) {
		if(newCap < size)
			return;
		T[] old = elem;
		elem = (T[])new Object[newCap];
        System.arraycopy(old, 0, elem, 0, size); 
	}
	@SuppressWarnings("unchecked")
	public void clear() {

		size = 0;
		elem = (T[]) new Object[capacity];

	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ;
	}

	@Override
	public void add(T x) {
		if(elem.length == size)
			increaseCapacity(2* size);
		if(!contains(x))
			elem[size++] = x; 
//		for (int i = 0; i < size; i++) {
//			 for (int j = 0; j < size; j++) {
//				 if(elem[j] > elem[j+1])
//					 
//			}
//		}
		
	
	}

	@Override
	public void remove(T x) {
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
	public boolean contains(T x) {
		for (int i = 0; i < size; i++) {
			if(get(i) == x)
				return true;
		}
//		for (T t : elem) {
//			 if(t.equals(x))
//				 return true;
//			 if(t == x)
//				 return true;
		
		return false;
	}

	public T get(int index) {
		return elem[index];
	}
	
//	public class MyIterator<T> implements Iterator<T>{
//
//		@Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public T next() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
//	@Override
//	public String toString() {
//		return "ArraySet ::"
//				+ " size = "  + size +  " , Elemente = " + Arrays.toString(elem)
//				+  " ";
//	}
	 
	
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder("Elemente in ArraySet : " ); 
        for (int i = 0; i < size; i++) { 
            s.append(elem[i]).append(", "); 
        } 
        s.append("[[[[size = ").append(size).append("]]]]"); 
        return s.toString(); 
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int position = 0;


			@Override
			public boolean hasNext() {
				if( position < size)
					return true;
				return false;
			//	return it.hasNext();
			}

			@Override
			public T next() {
				if(!hasNext())
			          throw new NoSuchElementException("kein Element ");
				else return elem[position++];
			}
			@Override
			public void remove() {
					throw new UnsupportedOperationException("not supported");
			}
			
			
		};
	}
	
	
//	 public  Iterator<T> sortedIterator(Iterator<T> it, Comparator<T> comparator) {
//	      ArrayList<T> list = new ArrayList<T>();
//	      while (it.hasNext()) {
//	          list.add(it.next());
//	      }
//
//	      Collections.sort(list, comparator);
//	      return list.iterator();
//	  }

}
