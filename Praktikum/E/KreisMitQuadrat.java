package kreis;

/**
 * Klasse zum Arbeiten mit Kreisen in der Ebene.
 *
 * @author Oliver Bittel
 */
public class KreisMitQuadrat implements KreisInterface {

    /**
     * Konstante pi.
     */
    private final double pi = 3.14;
    /**
     * x-Koord. des LUP.
     */
    private double lupX = 0;
    /**
     * y-Koord. des LUP.
     */
    private double lupY = 0;
    /**
     * Radius.
     */
    private double len = 1;

    /**
     * Default Konstruktor.
     */
    public KreisMitQuadrat() { }

    /**
     * Kreiskonstruktor mit Parameter.
     * @param x x-Komponente des lup.
     * @param y y-Komponente des lup.
     * @param a Seteinlaenge des umfassenden Rechtecks.
     */
    public KreisMitQuadrat(final double x,
            final double y, final double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Seitenlaenge "
                + "darf nicht negativ sein");
        }
        lupX = x;
        lupY = y;
        len = a;
        assert invariante() : invarianteVerletzt;
    }

    /**
     * Veraendert Kreisgroesse um Faktor f.
     * @param f Vergroesserungs-Faktor
     */
    public final void resize(final double f) {
        // Das Werfen von RunTimeExceptions muss NICHT deklariert werden;
        // das Java-Tutorial empfiehlt das Werfen von RuntimeExceptions 
        // wenn z.B. eine Methode mit falschen Parametern aufgerufen wird.
        // download.oracle.com/javase/tutorial/essential/exceptions/runtime.html
        if (f < 0) {
            throw new IllegalArgumentException("Skalierungsfaktor darf "
                + "nicht negativ sein");
        }
        len *= f;
        assert invariante() : invarianteVerletzt;
    }

    /**
     * Verschiebt Kreis.
     * @param x Verschiebungsanteil in x-Richtung.
     * @param y Verschiebungsanteil in y-Richtung.
     */
    public final void move(final double x, final double y) {
        lupX += x;
        lupY += y;
        assert invariante() : invarianteVerletzt;
    }

    /**
     * Kreisflaeche berechnen.
     * @return Kreisflaeche.
     */
    public final double getFlaeche() {
        return pi * len * len  / 4;
    }

    // Objekt-Invariante:
    private final static String invarianteVerletzt =
        "Invariante verletzt: Laenge muss >= 0 sein";
    private boolean invariante() {
        return len >= 0;
    }

    @Override
    public boolean equals(Object o) {
        KreisMitQuadrat k = (KreisMitQuadrat) o;
        return (this.len == k.len &&
               this.lupX == k.lupX &&
               this.lupY == k.lupY);
    }


}

