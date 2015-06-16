package aufgabe4;

/**
 *@author Abusaleh
 *@version 18.05.15
 */
public final class HtwgNoten {
    /**
    * HtwgNoten Konstruktur.
    */
    private HtwgNoten() { }

     /**
     * BESTE ist die Klassenvariable für beste Note.
     */
    public static final double BESTE = 1.0;
     /**
     * SCHLESTESTE ist die Klassenvariable für schlechtere Note.
     */
    public static final double SCHLESTESTE = 5.0;

    /**
     * istZulaessig prüft ob Note zulässig ist.
     * @param note eingelesene Note.
     * @return ist zulässig oder nicht
     */

    public static boolean istZulaessig(final String note) {

        double c = 0;
        boolean gueltigeNote = false;

        try {
            boolean  first = Character.isDigit(note.charAt(0));
            boolean  last  = Character.isDigit(note.charAt(2));
            char     mitte = note.charAt(1);
            int a = Character.getNumericValue(note.charAt(0));
            int b = Character.getNumericValue(note.charAt(2));

            if (note.length() == 3 && (mitte == '.' || mitte == ',')
                    && (first && last)) {
                if (a > 0 && a < 6) {
                    if (b == 0 || b == 3 || b == 7) {
                        if ((a == 4 || a == 5) && (b > 0)) {
                            return false;
                        } else {
                            gueltigeNote = true;
                        }
                    } else {
                        return false;

                    }
                }
            } else {
                return false;

            }
        } catch (java.lang.StringIndexOutOfBoundsException x) {
            return false;

        }

        return gueltigeNote;

    }

    /**
    * doubleNote wandelt String Note in Double Note um.
    * @param note eingelesene Note.
    * @return n ist die umgewandlte Note
    */

    public static double doubleNote(final String note) {
        Double n = 0.0;
        String mynote = note.replace(',', '.');
        try {
            if (istZulaessig(mynote)) {
                n = Double.parseDouble(mynote);
            }

        } catch (java.lang.IllegalArgumentException x) {
            System.out.println("Unzulaessige Note "
                               + note + " wird ignoriert!");
        }
        return n;
    }

    /**
    * istBestanden prüft ob bestanden oder nicht.
    * @param bestanden .
    * @return ob bestanden oder nicht
    */

    public static boolean istBestanden(final double bestanden) {
        String str = String.valueOf(bestanden);
        if (istZulaessig(str)) {
            if (bestanden == SCHLESTESTE) {
                return false;
            }
        }
        return true;
    }

    /**
    * bessere gibt bessere  Note zurück.
    * @param n ist die erste note .
    * @param  m ist die zweite note .
    * @return bessere note  züruck
    */

    public static double bessere(final double n, final double m) {
        if (n < m) {
            return n;
        }
        return m;

    }
    /**
    * schlechtere gibt schlechtere  Note zurück.
    * @param  n ist die erste note .
    * @param m ist die zweite note .
    * @return schlechtere note  züruck
    */

    public static double schlechtere(final double n, final double m) {
        if (n > m) {
            return n;
        }
        return m;

    }
}
