// O. Bittel
// 13.4.2011

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class FileBrowser {

    public static void main(String[] args) {
        File dir = new File("/Users/oliverbittel/NetBeansProjects");

        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                System.out.println("Verzeichnis: " + f.getParent() + "/" + f.getName());
            else
                System.out.println("Datei: " + f.getParent() + "/" + f.getName());
        }
        
        // Ihr Code: ....
    }

    public static void dirPrint(File file) {
     	// Ihr Code: ....
    }

    public static void dirSearch(File file, String extension, List<String> l) {
    	// Ihr Code: ....
    }

}
