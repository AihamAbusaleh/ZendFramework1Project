import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BraceUtitlity {

    public static void printBrackets(String fn) throws FileNotFoundException, IOException {
        LineNumberReader in = new LineNumberReader(
                              new FileReader(fn));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            System.out.print("Klammern: ");
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        System.out.print(c + ", ");
                        break;
                    case ')':
                    case '}':
                    case ']':
                        System.out.print(c + ", ");
                        break;
                }
            }
            System.out.println();
        }
    }

    public static void checkBrackets(String fn) throws FileNotFoundException, IOException {
        LineNumberReader in = new LineNumberReader(
                    new FileReader(fn));
        Deque<Character> stack = new LinkedList<Character>(); // JDK 1.2 Collections

		// ...
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        printBrackets(args[0]);
    }

}
