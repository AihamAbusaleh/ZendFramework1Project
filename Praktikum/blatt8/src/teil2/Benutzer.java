package teil2;

import java.util.LinkedList;
import java.util.List;

public class Benutzer {
	private String name;
	private List<Buch> mybooks = new LinkedList<>();

	public Benutzer(String name) {
		this.setName(name);
	}

	public void ausleihen(Buch buch) {
		if (mybooks.contains(buch))
			return; // Das Buch wurde bereits ausgeliehen von dieser Person
		if (buch.getUser() != null && !buch.getUser().equals(this)) //
			return; // Das Buch ist nicht vorhanden
		if(buch.getUser() != null && !buch.getUser().equals(this)){
			buch.getUser().zurueckgeben(buch); 
		}
		
		mybooks.add(buch);
		buch.setUser(this);
	}

	public void zurueckgeben(Buch buch) {
		if (!mybooks.contains(buch))
			return; // Buch ist nicht in der Liste
		if (buch.getUser() != null && !buch.getUser().equals(this)) {
			return;
		}
		mybooks.remove(buch);
		buch.userentfernen();
	}

	public List<Buch> getMybooks() {
		return mybooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Benutzer [name=" + name + ", getMybooks()_Size=" + getMybooks().size()
				+ "]";
	}
}
