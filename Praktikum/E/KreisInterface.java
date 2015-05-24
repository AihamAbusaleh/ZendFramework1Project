package kreis;


/**
 * Interface Kreis.
 *
 * @author Oliver Bittel
 */
public interface KreisInterface {
    /**
     * Veraendert Kreisgroesse um Faktor f.
     * @param f Vergroesserungs-Faktor
     */
    void resize(final double f);

    /**
     * Verschiebt Kreis.
     * @param x Verschiebungsanteil in x-Richtung.
     * @param y Verschiebungsanteil in y-Richtung.
     */
    void move(final double x, final double y);

    /**
     * Kreisflaeche berechnen.
     * @return Kreisflaeche.
     */
    double getFlaeche();
}
