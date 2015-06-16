// HtmlNotenspiegel.java

package aufgabe6;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.text.html.HTML.Tag; 


/**
 * HtmlNotenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen
 * Noten in eine verkettete Liste ein und gibt dann einen Notenspiegel im
 * HTML-Format aus. Aufruf mit dem Namen des Studenten als Argument(e)
 * 
 * @author Aiham Abusaleh
 * @version 15.06.15
 */
public final class HtmlNotenspiegel {
	private HtmlNotenspiegel() {
	}

	/**
	 * main muss mit mindestens zwei Argumenten aufgerufen werden.
	 * 
	 * @param args
	 *            Vorname(n) Nachname
	 * @throws IOException
	 *             bei Einleseproblemen
	 */
	public static void main(final String[] args) throws IOException {
		if (args.length < 2) {
			System.err
					.println("Aufruf: java HtmlNotenspiegel Vorname(n) Nachname");
			System.exit(1);
		}

		System.err.println("Faecher mit Noten eingeben (Ende mit Strg-D):");

		final BufferedReader eingabe = new BufferedReader(
				new InputStreamReader(System.in));
		final PrintWriter ausgabe = new PrintWriter(System.out);

		FachNotenListe notenListe = einlesen(eingabe);
		ausgeben(ausgabe, args, notenListe);

		ausgabe.close();
	}

	/**
	 * liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Beurteilungen
	 * in eine verkettete Liste ein.<br>
	 * Jede Eingabezeile muss einen Fachnamen und eine Beurteilung enthalten.
	 * <p>
	 * Fachnamen m&uuml;ssen laut {@link aufgabe6.Faecher#istZulaessig} erlaubt
	 * sein.
	 * </p>
	 * <p>
	 * Bei unbenoteten F&auml;chern muss die Beurteilung <tt>BE</tt> f&uuml;r
	 * bestanden oder <tt>NB</tt> f&uuml;r nicht bestanden lauten.
	 * </p>
	 * <p>
	 * Bei benoteten F&auml;chern muss die Note laut
	 * {@link aufgabe4.HtwgNoten#istZulaessig} erlaubt sein.
	 * </p>
	 * 
	 * @param eingabe
	 *            die Quelle, aus der gelesen wird
	 * @return die Liste mit den eingelesenen Fachnoten
	 * @throws IOException
	 *             bei Einleseproblemen
	 */
	public static FachNotenListe einlesen(final BufferedReader eingabe)
			throws IOException {

		FachNotenListe notenListe = new FachNotenListe();
		String zeile;

		while ((zeile = eingabe.readLine()) != null) {

			zeile = zeile.trim();
			if (zeile.length() == 0) {
				continue; // Leerzeile
			}

			try {
				String[] woerter = zeile.split("\\s+");
				if (woerter.length < 2) {
					throw new IllegalArgumentException("unvollstaendige Zeile "
							+ zeile);
				}

				String note = woerter[woerter.length - 1];
				String fach = zeile.substring(0, zeile.lastIndexOf(note));

				FachNote f;
				if (note.equals("BE")) {
					f = new UnbenoteteLeistung(fach.trim(), true);
				} else if (note.equals("NB")) {
					f = new UnbenoteteLeistung(fach.trim(), false);
				} else {
					f = new BenoteteLeistung(fach.trim(), note);
				}

				notenListe.einfuegen(f);

			} catch (IllegalArgumentException x) {
				System.err.printf("Falscheingabe ignoriert: %s%n",
						x.getMessage());
				continue;
			}
		}

		return notenListe;
	}

	/**
	 * schreibt einen Notenspiegel im HTML-Format.
	 * 
	 * @param ausgabe
	 *            das Ziel, in das geschreiben wird
	 * @param name
	 *            Vorname(n) und Nachname
	 * @param notenListe
	 *            die Fachnoten
	 */
	public static void ausgeben(final PrintWriter ausgabe, final String[] name,
			final FachNotenListe notenListe) {

		/*
		 *  (1) hier die Methodenimplementierung ergaenzen (zum HTML-Format
		 * siehe die Datei beispiel.html) (schreiben mit ausgabe.println(...)
		 * und ausgabe.printf(...)) (verwenden Sie eine for-each-Schleife zum
		 * Ablaufen der Liste)
		 */
		// String s = "<table width='100%'><tr> <th align='left'>Fach:</th><th align='left'>Art:</th><th align='left'>Note:</th></tr>";

		System.out.printf("<html><head><title>Notenspiegel</title></head><body><h1>Notenspiegel</h1><hr><p><b>Student:</b><br>Aiham Abusaleh</p>");
		System.out.printf("<table><tr><th>Fach:</th><th>Art:</th><th>Note:</th></tr>");
        		//System.out.println("Body"+ HTML.Tag.TABLE);





		for (FachNote f : notenListe) {
           System.out.println(" <tr><td> " + ausgabe.printf(f.getFach())
					+ " </td><td> " + ausgabe.printf(f.getNote())
					+ " </td><td> " + ausgabe.printf(f.getNoteInWorten())
					+ " </td></tr> ");

			
		}
        System.out.printf("</table><hr>L = Leistungsnachweis, S = Schein</body></html>");	

	}
}

