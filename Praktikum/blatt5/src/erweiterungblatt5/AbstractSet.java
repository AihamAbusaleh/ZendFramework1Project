package erweiterungblatt5;


public abstract class AbstractSet<T> implements Set<T> {
		
	
	@Override
	public boolean containsAll(Set<T> s) {
//		for (int i = 0; i < s.size(); i++) {
//			if(!contains(s.get(i)))
//				return false;
//		}
		for (T t : s) {
			if(!contains(t))
				return false;
		
		}
		
		return true;
	}

	@Override
	public void addAll(Set<T> s) {
//		for (int i = 0; i < s.size(); i++) {
//			add(s.get(i));
//		}
		for (T t : s) {
			if(!contains(t))
				s.add(t);
		}
	}

	@Override
	public void removeAll(Set<T> s) {
//		for (int i = 0; i < s.size(); i++) {
//			 remove(s.get(i));
//		}	
		for (T t : s) {
			if(contains(t))
				s.remove(t);
		}
	}
	
}
