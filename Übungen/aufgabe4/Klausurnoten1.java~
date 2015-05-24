package aufgabe4;

import java.util.Locale;
import java.util.Scanner;
/**
 * @author Abusaleh
 * @version 27.04.2015
 */
public final class Klausurnoten {
    public Klausurnoten() { }
    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Locale.setDefault(Locale.GERMANY);
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            HtwgNoten meineNote = new HtwgNoten();
            if(meineNote.istZulaessig(note)) {
                meineNote.bessere(1.7, 3.0);
                meineNote.schlechtere(1.7, 3.0);
                String	l = note.replace(',', '.');
                double n = Double.parseDouble(l);
                meineNote.istBestanden(n);
                meineNote.doubleNote(note);          

            }
        }
    }
}
