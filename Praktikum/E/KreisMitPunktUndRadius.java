package kreis;

/**
 * Klasse zum Arbeiten mit Kreisen in der Ebene.
 *
 * @author Oliver Bittel
 */
public class KreisMitPunktUndRadius implements KreisInterface {

    /**
     * Konstante pi.
     */
    private final static double pi = 3.14;
    /**
     * x-Koord. des Mittelpunkts.
     */
    private double mx = 0;
    /**
     * y-Koord. des Mittelpunkts.
     */
    private double my = 0;
    /**
     * Radius.
     */
    private double radius = 1;

    /**
     * DEfault Konstruktor.
     */
    public KreisMitPunktUndRadius() { }

    /**
     * Kreiskonstruktor mit Parameter.
     * @param x x-Komponente des Mittelpunkts.
     * @param y y-Komponente des Mittelpunkts.
     * @param r Radius.
     */
    public KreisMitPunktUndRadius(final double x,
            final double y, final double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Radius darf "
                    + "nicht negativ sein");
        }
        mx = x;
        my = y;
        radius = r;
        checkInvariante();
    }

    /**
     * Veraendert Kreisgroesse um Faktor f.
     * @param f Vergroesserungs-Faktor
     */
    public final void resize(final double f)  {
        if (f < 0) {
            throw new IllegalArgumentException("Skalierungsfaktor "
                    + "darf nicht negativ sein");
        }
        radius *= f;
        checkInvariante();
    }

    /**
     * Verschiebt Kreis.
     * @param x Verschiebungsanteil in x-Richtung.
     * @param y Verschiebungsanteil in y-Richtung.
     */
    public final void move(final double x, final double y) {
        mx += x;
        my += y;
        //radius += y;
        checkInvariante();
    }

    /**
     * Kreisflaeche berechnen.
     * @return Kreisflaeche.
     */
    public final double getFlaeche() {
        return pi * radius * radius;
    }

    private void checkInvariante() {
        assert radius >= 0 : "Invarinte verletzt: Radius muss >= 0 sein";
    }

}
