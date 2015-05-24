// Klausurnoten.java

package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * Klausurnoten erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Noten im Format
 * <tt>Ganze,Zehntel</tt> oder <tt>Ganze.Zehntel</tt>,
 * wobei <tt>Ganze</tt> und <tt>Zehntel</tt> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten  (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
* ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
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
        int counter = 0;
        int durchfall = 0;
        int sum = 0;
        int a = 0;
        int b = 0;
        int schlechteNote = 10;
        int  besteNote     = 50;
        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            int c = 0;
            boolean gueltigeNote = false;
            try {
                boolean  first = Character.isDigit(note.charAt(0));
                boolean  last  = Character.isDigit(note.charAt(2));
                char     mitte = note.charAt(1);
                a = Character.getNumericValue(note.charAt(0));
                b = Character.getNumericValue(note.charAt(2));

                if (note.length() == 3 && (mitte == '.' || mitte == ',')
                    && (first && last)) {
                    if (a > 0 && a < 6) {
                        switch (note.charAt(2)) {
                        case '0':
                            c  = (a * 10) + b;
                            counter++;
                            gueltigeNote = true;
                            break;
                        case '3':
                        case '7':
                            if (note.charAt(0) == '4'
                                || note.charAt(0) == '5') {
                                System.out.println("Note " + note
                                    + " wird wegen Nachkommastelle "
                                    + note.charAt(2) + " ignoriert!");
                                break;
                            }
                            c  = (a * 10) + b;
                            counter++;
                            gueltigeNote = true;
                            break;
                        default:
                            System.out.println("Note " + note
                                + " wird wegen Nachkommastelle "
                                + note.charAt(2) + " ignoriert!");
                            break;
                        }
                    } else {
                        System.out.println("Note " + note
                            + " wird wegen Vorkommastelle "
                            + note.charAt(0) + " ignoriert!");
                    }
                } else {
                    System.out.println("Note " + note
                        + " wird wegen Formatfehler ignoriert!");
                }
            } catch (java.lang.StringIndexOutOfBoundsException x) {
                System.out.println("Note " + note
                    + " wird wegen Formatfehler ignoriert!");
            }
            if (gueltigeNote) {
                if (c < besteNote && counter > 0) {
                    besteNote =  c;
                }
                if (c > schlechteNote) {
                    schlechteNote =  c;
                }
                if (c == 50) {
                    durchfall++;
                }
                sum += c;
            }

        }

        System.out.println();
        System.out.printf("Anzahl beruecksichtigter Noten: %d%n", counter);
        double beste = besteNote / 10.0;
        double schlechteste = schlechteNote / 10.0;
        double durchfallquote = 0;
        if (counter != 0) {
            System.out.printf("Beste Note: %.1f " , beste);
            System.out.printf("%nSchlechteste Note: %.1f" , schlechteste);
            double durchschnitt = (double) sum / counter;
            System.out.printf("%nDurchschnitt: %.1f " , durchschnitt / 10);
            durchfallquote =  (durchfall * 100.0 / counter);
            System.out.printf("%nDurchfallquote: %.1f%% ",
                              (durchfallquote));
            System.out.println();
        }
    }
}