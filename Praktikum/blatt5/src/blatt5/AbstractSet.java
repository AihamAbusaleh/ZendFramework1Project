package blatt5;


public abstract class AbstractSet<T> implements Set<T> {
		
	
	@Override
	public boolean containsAll(Set<T> s) {
		for (int i = 0; i < s.size(); i++) {
			if(!contains(s.get(i)))
				return false;
		}
		
		return true;
	}

	@Override
	public void addAll(Set<T> s) {
		for (int i = 0; i < s.size(); i++) {
			add(s.get(i));
		}
	}

	@Override
	public void removeAll(Set<T> s) {
		for (int i = 0; i < s.size(); i++) {
			 remove(s.get(i));
		}		
	}
	
}
