package kreis;

/**
 * Testprogramm fuer Kreisklassen.
 *
 * @author Oliver Bittel
 */

public final class KreisAnwendung {

    /**
     * Privater Konstruktor, da rein statische Klasse.
     */
    private KreisAnwendung() { }

    /**
     * @param args wird nicht benutzt.
     */
    public static void main(final String[] args) {
        KreisInterface k1 = new KreisMitPunktUndRadius();
        k1.resize(2);
        k1.move(-3, -3);
        KreisInterface k2 = new KreisMitQuadrat(2, 3, 3);
        System.out.println(k1.getFlaeche());
        k2.move(1, 1);
        System.out.println(k2.getFlaeche());
    }

}
