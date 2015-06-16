package aufgabe6;

public class UnbenoteteLeistung extends FachNote{

	private final boolean unbenotet;

	public UnbenoteteLeistung(String f, boolean unbenotet) {
		super(f);
		this.unbenotet = unbenotet;
	}


	public boolean istBestanden() {
		if (unbenotet) {
			return true;
		}
		return false;
	}


	public boolean istBenotet() {
		return false;
	}

}
