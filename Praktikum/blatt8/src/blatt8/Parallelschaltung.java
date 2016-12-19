package blatt8;

public class Parallelschaltung extends ZusammengesetzeSchaltung {

	public double getWiderstand() {
		double parallel = 0;
		for (Schaltung s : schaltung) {
			parallel += 1 / s.getWiderstand();

		}
		return 1 / parallel;
	}

}