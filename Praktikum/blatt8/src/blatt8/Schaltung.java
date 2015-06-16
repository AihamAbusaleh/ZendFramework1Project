package blatt8;

public interface Schaltung {  // Die Komponente
	
	public double getWiderstand();  // Operation()
	public int getAnzahlWiderstaende(); // Operation()
	public void add(Schaltung s);
	public void remove(Schaltung s);
	

}