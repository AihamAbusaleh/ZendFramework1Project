package blatt4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BraceUtitlity {

    public static void printBrackets(String fn) throws FileNotFoundException, IOException {
        LineNumberReader in = new LineNumberReader(new FileReader(fn));
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
        in.close();
    }

    public static void checkBrackets(String fn) throws FileNotFoundException, IOException {
        LineNumberReader in = new LineNumberReader(new FileReader(fn));
        Deque<Character> stack = new LinkedList<Character>(); // JDK 1.2 Collections
        
        String line;
        while ((line = in.readLine()) != null) {
        	System.out.println(line);
        	
        	for (int i = 0; i < line.length(); i++) {
        		char letter = line.charAt(i);
    		    if(letter == '{' || letter == '(' || letter == '[' ) {
            	    stack.push(letter);
    		    }
    		
    		    if(letter == '}' || letter == ')' || letter == ']' ) {
    			      if(stack.isEmpty()) { // es kam keine offene Klammer vor , also nix gepusht 
    			    	  System.out.println("********Oeffnende Klammer fehlt "); // für alle oder 3 if Bedingungen jeweils (für jede Klammerart)!
    			    	  in.close();
    			    	  return ;
    			      }
    			      char klammerImStack = stack.peek(); // prüfe die Klammer im Stack
    			      if((letter == '}' && klammerImStack == '{') || 
    			    		  (letter == ')' && klammerImStack == '(' )|| 
    			    		  		(letter == ']' && klammerImStack == '[') ) {
    			    	  	stack.pop(); // hole die obere Klammer vom Stack
    			      }else {// wenn die Klammer mit einander nicht passen
    			    	  	System.out.println("***********Klammerpaar nicht passend ");
    			    	 	in.close();
    			    	  	return;
    		  	      }	
    			      
    		    }  

        	 }   

         }

         if(!stack.isEmpty()) { // nach whie schleife, checke ob Stack leer
	  		System.out.println("*******Stack ist NICHT leer  ") ;
         }else {
     	  	System.out.println("*********** Alles passt wunderbar ! ");
         }	
         in.close();

    }


    public static void main(String[] args) throws FileNotFoundException, IOException {

    	// printBrackets(args[0]);

    	checkBrackets(args[0]);
    }

}
