package blatt2;


public abstract class AbstractSet implements Set {
		

	public boolean containsAll(Set s) {
		for (int i = 0; i < s.size(); i++) {
//			for (int i = j; i < s.size(); i++) {
				if(!contains(s.get(i)))
					return false;
//			}
			
		}	
		return true;
	}
	public void addAll(Set s) {  // füge alle Elemente aus s zur Menge hinzu
		for (int i = 0; i < s.size(); i++) {
			 add(s.get(i));
		}
   }
	public void removeAll(Set s) {
		for (int i = 0; i < s.size(); i++) {
			 remove(s.get(i));
		}
   }
}
