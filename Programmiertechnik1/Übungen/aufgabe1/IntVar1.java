// IntVar.java

package aufgabe1;

import java.util.Scanner;
//import java.util.*;
// mport static java.lang.System.out;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Abusaleh.
 *@version IntVar.
*/
public final class IntVar1 {
    private IntVar1() { }

    private static final Scanner EINGABE = new Scanner(System.in);
    private static final Scanner OP = new Scanner(System.in);
    /**
     * main ist der Startpunkt des Programms.
     * @param args private static final wird nicht verwendet.
    */
    public static void main(final String[] args) {
        /* to-do: Konstanten min und max definieren */
        final int max = Integer.MAX_VALUE;
        final int min = Integer.MIN_VALUE;
        /* to-do: Eingabeaufforderung ausgeben */
        System.out.println("Bitte geben Sie die 1.Zahl ein : ");
        if (!EINGABE.hasNextInt()) {
            System.out.println("Eingabe ist ungueltig");
        }
        int zahl1 = EINGABE.nextInt();
        System.out.println("Bitte geben Sie die 2.Zahl ein : ");
        if (!EINGABE.hasNextInt()) {
            System.out.println("Eingabe ist ungueltig");
        }
        int zahl2 = EINGABE.nextInt();
        /* to-do: zwei ganze Zahlen einlesen */
        System.out.printf("Die eingegebenen Integer Zahlen : %d und %d %n",
            zahl1, zahl2);
        /* to-do: die beiden Zahlen dezimal, okatal und hexadezimal ausgeben */
        System.out.printf(" Zahlen in Dezimal %d und  %d %n", zahl1, zahl2);
        System.out.printf(" Zahlen in Oktal %o und  %o %n", zahl1, zahl2);
        System.out.printf(" Zahlen in Hexa %x und  %x %n", zahl1, zahl2);
        /* to-do: alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.println("Add " + (zahl1 + zahl2));
        System.out.println("Sub " + (zahl1 - zahl2));
        System.out.println("Mult " + (zahl1 * zahl2));
        System.out.println("Div " + (zahl1 / zahl2));
        if (zahl1 == zahl2) {
            System.out.println("Zahlen sind gleich");
        }
        if (zahl1 != zahl2) {
            System.out.println("Zahlen sind ungleich");
        }
        if (zahl1 < zahl2) {
            System.out.println("Zahl1 kleiner zahl2");
        }
        if (zahl1 > zahl2) {
            System.out.println("Zahl1 größer zahl2");
        }
    }
}
