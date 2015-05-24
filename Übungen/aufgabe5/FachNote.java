package aufgabe5;

public class FachNote {

	public final FachNote naechste;
	public final String fach; 
	public final String note;

	public FachNote(FachNote naechste, String fach, String note) {
        this.naechste = naechste;
        this.fach = fach;
        this.note = note;
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
                    if ((a == 4 || a == 5) && (b > 0)) {
                        System.out.println("Unzulaessige Note " + note
                                           + " wird ignoriert!");
                    } else {

               
                        gueltigeNote = true;
                    }
                }
            } else {
                System.out.println("Unzulaessige Note " + note
                                   + " wird ignoriert!");
            }
        } catch (java.lang.StringIndexOutOfBoundsException x) {
            System.out.println("Unzulaessige Note " + note
                               + " wird ignoriert!");
	}catch (java.lang.IllegalArgumentException x) {
            System.out.println("Unzulaessige Note " + note + " wird ignoriert!");
    }
        

    }

}
