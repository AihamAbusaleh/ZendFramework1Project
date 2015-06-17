package blatt2;

public class SetApplication {

	
	  public static void main(String[] args) {
	        Set s1 = new ArraySet();
	        Set s2 = new ArraySet();
	        Set s3 = new ArraySet();
	        LinkedListSet liste = new LinkedListSet();
	 
// AUFGABENBLATT 3 	        
//	        liste.contains(11);

	        liste.add(9);
	        liste.add(9);
	        System.out.println(liste); 

	        liste.add(2);
	        liste.add(4);
	        liste.add(0);
	        System.out.println(liste); 

	        liste.add(13);
	        liste.add(5);
	        liste.add(5);
	        System.out.println(liste); 
	        System.out.println(liste.contains(11)); 
	        System.out.println(liste.contains(0)); 
	        System.out.println(liste.contains(4)); 
	        liste.remove(0);
	        System.out.println(liste); 
	        liste.remove(7);
	        liste.remove(5);
	        System.out.println(liste); 
	        System.out.println(liste.get(1)); // im index 1 steht die 4 
	  //// System.out.println(liste.get(9)); // Exception da index also 9 > size=5


//  AUFGABENBLATT 2 fängt hier an !
	        s1.add(1);
	        s1.add(5);
	        s1.add(8);
	        s1.add(0);
	        s1.add(5);
	        System.out.println(s1); // {1, 5, 8, 0}; andere Reihenfolge ist auch OK.
	        System.out.println(s1.contains(0));
	        System.out.println(s1.contains(7));


	        for (int i = 1; i <= 50; i++)
	            s2.add(2*i);
	        System.out.println(s2); // {2, 4, 6, ..., 100}

	        s3.add(4);
	        s3.add(8);
	        System.out.println(s3); 

	        // Teilmengenbeziehung pruefen:
			System.out.println(s1.containsAll(s2));  // false
	        System.out.println(s1.contains(0));	     // true	        
	        System.out.println(s2.containsAll(s3));  // true
			System.out.println(s2.contains(0));     // false
	        System.out.println(s2.containsAll(s2));  // true

	        Set s4 = new ArraySet();
	        for (int i = 1; i <= 40; i++)
	            s4.add(5*i);
	        System.out.println(s4); // {5, 10, 15, ..., 200}
			s4.remove(200);
			System.out.println(s4); // {5, 10, 15, ..., 195}

	        // Vereinigung:
	        s2.addAll(s4);
	        System.out.println(s2); // {2, 4, 5, 6, ..., 100, 105, ..., 195}

	        // Differenzmenge:
	        s2.removeAll(s4); 
			System.out.println(s2); // {2, 4, 6, 8, 12, ..., 98}
			System.out.println(s4); // {5, 10, 15, ..., 195}
			
			// Leere Menge:
			s2.clear();
			System.out.println(s2); // { }
	    }
   

}