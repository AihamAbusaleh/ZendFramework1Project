// Eistieg.java

package einstieg;

import java.util.Scanner;
import static java.lang.System.out;

/**
* Einstieg ist ein kleines Java Programm.
* @author Aiham
* @version 21.03.15
*/
public final class Einstieg {
    private Einstieg() { }
    private static final Scanner EINGABE = new Scanner(System.in);
    /**
    * Die Klassenmethode main ist der Startpunkt des Programms.
    * main verwendet die Methoden print und printf zum A usgeben von Text
    * sowie die Methoden next und nextInt zum Einlesen v on Text
    * und einer ganzen Zahl.
    * @param args wird nicht verwendet
    */
    public static void main(final String[] args) {
        out.print("vorname: ");
        String vorname = EINGABE.next();
        out.print("Anzahl bisher geschriebener Java-Programm: ");
        int anzahl = EINGABE.nextInt();
        out.printf("%s's %d. Java-Programm funktioniert!%n",
                   vorname, anzahl + 1);
    }
}