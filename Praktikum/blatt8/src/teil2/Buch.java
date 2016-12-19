package teil2;

public class Buch {
	private String name;
	private Benutzer user;

	public Buch(String name) {
		this.name = name;
	}

	public void userentfernen() {
		if (user == null)
			return; // user ist nicht registriert
        Benutzer neunutzer = user;
		user = null;
		neunutzer.zurueckgeben(this);
	}

	public void setUser(Benutzer u) {
		if (user != null)
			return; // user registriert !
		user = u;
		u.ausleihen(this); // set dieser user
	}

	public String getName() {
		return name;
	}

	public Benutzer getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Buch [getName()=" + getName() + ", getUser()=" + getUser().getName()
				+ "]";
	}
	
	

}