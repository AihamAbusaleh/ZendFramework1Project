// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author : Abusaleh
 * @version : 13.04.15
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        /*  (1) hier ein Feld von Zaehlern definieren */
        int[] zaehler = {0, 0, 0, 0, 0, 0};
     //-------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            int number = EINGABE.nextInt();
            /*  (2) hier Anweisungen fuer das
             Pruefen und Zaehlen der Eingabe schreiben */
            final int max = 6;
            if (number < 1 || number > max) {
                System.out.println("Falsche Eingabe wird ignoriert: " + number);
            } else {
                ++zaehler[number - 1];
            }
        }
        /* for (int i=0; i<zaehler.length; i++) {
              System.out.println("Index des Arrays = " + i);
              System.out.println("Wert unter dem oberen Index = " + zaehler[i]);
           }
       */
        //---------------------------------------------- Histogramm ausgeben
        /*  (3) hier Anweisungen fuer die Histogrammausgabe schreiben */
        final int mod = 5;
        for (int i = 0; i < zaehler.length; ++i) {
            for (int j = 0; j < zaehler[i]; ++j) {
                if (((j + 1) % mod) == 0) {
                    System.out.print("$");
                } else {
                    System.out.print(i + 1);
                }
            }
            if (zaehler[i] != 0) {
                System.out.printf(" (%d)%n", zaehler[i]);
            }
        }
    }
}
