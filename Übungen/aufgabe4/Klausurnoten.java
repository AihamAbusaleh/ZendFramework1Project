package aufgabe4;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Abusaleh
 * @version 27.04.2015
 */
public final class Klausurnoten {
    private Klausurnoten() { }
    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Locale.setDefault(Locale.GERMANY);
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        double beste = HtwgNoten.SCHLESTESTE;
        double schlechteste = HtwgNoten.BESTE;
        double tmp = 0.0;
        int counter = 0;
        double summe = 0.0;
        int durchfall = 0;
        double durchfallquote = 0;



        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            if (HtwgNoten.istZulaessig(note)) {

                tmp = HtwgNoten.doubleNote(note);

                counter++;
                summe = summe + tmp;

                beste = HtwgNoten.bessere(beste, tmp);
                schlechteste = HtwgNoten.schlechtere(schlechteste, tmp);

                if (!HtwgNoten.istBestanden(tmp)) {
                    durchfall++;
                }
            } else {
                System.out.println("Unzulaessige Note "
                    + note + " wird ignoriert!");
            }
        }
        System.out.printf("%nAnzahl beruecksichtigter Noten: %d%n", counter);

        if (counter != 0) {

            System.out.printf("Beste Note: %.1f " , beste);
            System.out.printf("%nSchlechteste Note: %.1f" , schlechteste);
            double durchschnitt = (double) summe / counter;
            System.out.printf("%nDurchschnitt: %.1f " , durchschnitt);
            durchfallquote =  (durchfall * 100.0 / counter);
            System.out.printf("%nDurchfallquote: %.1f%% ",
                              (durchfallquote));
            System.out.println();
        }

    }
}
