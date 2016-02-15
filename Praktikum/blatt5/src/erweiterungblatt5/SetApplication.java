package erweiterungblatt5;

import java.util.Iterator;

public class SetApplication {

	
	  public static void main(String[] args) {
		  
		  ArraySet<Integer> arrayset1 = new ArraySet<>();
		  ArraySet<Integer> arrayset2 = new ArraySet<>();		  
		  arrayset1.add(6);
		  arrayset1.add(8);
		  arrayset1.add(4);
		  arrayset1.add(2);
		  arrayset1.add(0);
		  arrayset1.add(2);
		  arrayset1.add(9);
//		  SortedSet<String> set=new TreeSet<String>();
//		  List<Integer> list=new ArrayList<>(arrayset1);
		  Iterator<Integer> it1 = arrayset1.iterator();
		  while(it1.hasNext()) {
			  System.out.println("arrayset1 : " + it1.next());
		  }
		  System.out.println("*********************************************+");
		  System.out.println();
		  System.out.println(arrayset1.contains(0)); // true
		  System.out.println(arrayset1.contains(10)); // false
		  
		  for (int i = 0; i <= 30; i++) { 
			  arrayset2.add(i*2);
		  }

		  System.out.println(arrayset1.containsAll(arrayset2)); // false
		  System.out.println(arrayset2.containsAll(arrayset1)); // false
		
		  arrayset2.addAll(arrayset1); 


	
			
	   //   arrayset2.clear(); // {}
	      Iterator<Integer> it2 = arrayset2.iterator();
		  while(it2.hasNext()) {
			  System.out.println("arrayset2 : " + it2.next());
		  }
		  System.out.println("*********************************************+");
		  System.out.println();
		// ***********************ITERATOR*******************
			 
			 
	      /*-----------------------------------------------------------------------------------*/
		  LinkedListSet<String> listset1 = new LinkedListSet<>();
		  LinkedListSet<String> listset2 = new LinkedListSet<>();

		  listset1.add("6");
		  listset1.add("8");
		  listset1.add("4");
		  listset1.add("2");
		  listset1.add("0");
		  listset1.add("2");
		  listset1.add("9");
		  Iterator<String> it3 = listset1.iterator();
		  while(it3.hasNext()) {
			  System.out.println("listset1 : " + it3.next());
		  }
		  System.out.println("*********************************************+");
		  System.out.println();
		  listset2.add("2");
		  listset2.add("9");
		  listset2.add("3");
		  System.out.println(listset1.containsAll(listset2)); // false
		  System.out.println(listset2.containsAll(listset1)); // false
		  listset2.addAll(listset1); 
	   

	  //    listset1.clear(); // 
	  
	     
		  Iterator<String> it4 = listset2.iterator();
		  while(it4.hasNext()) {
			  System.out.println("listset2 : " + it4.next());
		  }
		  System.out.println("*********************************************+");
		  System.out.println();
// **************************************************************************
// **************************************************************************
		 
		
	      
	      LinkedListSet<Number> numberlist1 = new LinkedListSet<>();
		  LinkedListSet<Number> numberlist2 = new LinkedListSet<>();
		  numberlist1.add(1.5);
		  numberlist1.add(3);
		  
		  Iterator<Number> it5 = numberlist1.iterator();
		  while(it5.hasNext()) {
			  System.out.println("numberlist1 : " + it5.next());
		  }
		  System.out.println("*********************************************+");
		  System.out.println();
		  
		  numberlist2.add(7.9);
		  numberlist2.add(9);
		  numberlist2.add(3);
		  numberlist1.addAll(numberlist2);



		

		
		  Iterator<Number> it6 = numberlist2.iterator();
		  while(it6.hasNext()) {
			  System.out.println("numberlist2 : " + it6.next());
		  }
	  }

}