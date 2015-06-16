// Notenspiegel.java

package aufgabe5;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Notenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Noten
 * in eine verkettete Liste ein und gibt dann einen Notenspiegel aus.
 *
 * @author : Abusaleh
 * @version : 24.05.15
 */
public final class Notenspiegel1 {
    private Notenspiegel() {
    }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     *
     * @param args
     *            wird nicht verwendet.
     */
    public static void main(final String[] args) {
        FachNote listenAnfang = null; // leere Liste

        // --------------------------------------------- Notenspiegel einlesen
        System.err.println("Fach und Note eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            try {

                String fach = EINGABE.next();
                String note = EINGABE.next();

                FachNote l = new FachNote(listenAnfang, fach, note);
                listenAnfang = l;

            } catch (IllegalArgumentException x) {
                System.err.printf("Eingabefehler: %s%n", x.getMessage());
                continue;
            } catch (NoSuchElementException x) {
                System.err.println("Fach ohne Note ignoriert!");
                break;
            }
        }
        System.out.println("\nNOTENSPIEGEL: ");
        for (FachNote p = listenAnfang; p != null; p = p.naechste) {
            System.out.printf("\n |%-25s| |%s|", p.fach, p.note);
        }

    } // main

}

