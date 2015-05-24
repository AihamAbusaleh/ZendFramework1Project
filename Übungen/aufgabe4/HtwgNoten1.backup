package aufgabe4;


public final class HtwgNoten {
    public HtwgNoten () { }
    public double BESTE = 5.0;
    public double SCHLECHTESTE = 1.0;
    int counter = 0;
    int durchfall = 0;
    int sum = 0;
    int a = 0;
    int b = 0;
    int schlechteNote = 10;
    int  besteNote     = 50;
    public boolean istZulaessig (String note) {
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
                            System.out.println("Unzulaessige Note " + note
                                               + " wird ignoriert!");
                            break;
                        }
                        c  = (a * 10) + b;
                        counter++;
                        gueltigeNote = true;
                        break;
                    default:
                        System.out.println("Unzulaessige Note " + note
                                           + " wird ignoriert!");
                        break;
                    }
                } else {
                    System.out.println("Unzulaessige Note " + note
                                       + " wird ignoriert!");
                }
            } else {
                System.out.println("Unzulaessige Note " + note
                                   + " wird ignoriert!");
            }

        } catch (java.lang.StringIndexOutOfBoundsException x) {
            System.out.println("Unzulaessige Note " + note
                               + " wird ignoriert!");
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
                System.out.printf("Anzahl beruecksichtigter Noten: %d%n", counter);
        }


        return false;
    }

    public double doubleNote (String note) {
        Double n = 0.0;
        note = note.replace(',', '.');
        try {
            if(istZulaessig(note)) {
                n = Double.parseDouble(note);
            }

        } catch (java.lang.IllegalArgumentException x) {
            System.out.println("Unzulaessige Note " + note + " wird ignoriert!");
        }
        return n;
    }

    public boolean istBestanden (double bestanden) {
        String str = String.valueOf(bestanden);
        if(istZulaessig(str)) {
            if(bestanden <= 4.0) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public double bessere (double n, double m) {
        if(n < m) {
            return n;
        }
        return m;

    }

    public double schlechtere (double n, double m) {
        if(n > m) {
            return n;
        }
        return m;

    }
}
