package blatt8;

import java.util.LinkedList;
import java.util.List;

public abstract class ZusammengesetzeSchaltung implements Schaltung {
	protected List<Schaltung> schaltung = new LinkedList<>();

	public int getAnzahlWiderstaende() {
		int anzahl = 0;
		for (Schaltung s : schaltung) {
			anzahl += s.getAnzahlWiderstaende();
		}
		return anzahl;

	}

	public void add(Schaltung s) {
		schaltung.add(s);

	}

	public void remove(Schaltung s) {
		schaltung.remove(s);

	}
}