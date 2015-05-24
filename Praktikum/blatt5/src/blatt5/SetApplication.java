package blatt5;

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
		  System.out.println(arrayset1); // {0,2,4,6,8,9}
		  System.out.println(arrayset1.contains(0)); // true
		  System.out.println(arrayset1.contains(10)); // false
		  
		  for (int i = 0; i <= 30; i++) { 
			  arrayset2.add(i*2);
		  }
		  System.out.println(arrayset2); // {0, 2, 4 ..., 60}
		  System.out.println(arrayset1.containsAll(arrayset2)); // 
		  System.out.println(arrayset2.containsAll(arrayset1)); // 
		  arrayset2.remove(60); 
		  System.out.println(arrayset2); // {0, 2, 4 ..., 58}
		
		  arrayset2.addAll(arrayset1); 
	      System.out.println(arrayset2); // {0,2,4,6,8,9,10,12....58}

	      arrayset2.removeAll(arrayset1); 
	      System.out.println(arrayset1); // // {0,2,4,6,8,9}
	      System.out.println(arrayset2); // {10,12....58} 
			
	      arrayset1.clear(); // {}
	      System.out.println(arrayset1); // {} 
// ******************************************************************************
// ******************************************************************************
		  System.out.println("*********************************************+");
		  System.out.println();
	      
		  LinkedListSet<String> listset1 = new LinkedListSet<String>();
		  LinkedListSet<String> listset2 = new LinkedListSet<String>();

		  listset1.add("6");
		  listset1.add("8");
		  listset1.add("4");
		  listset1.add("2");
		  listset1.add("0");
		  listset1.add("2");
		  listset1.add("9");
		  System.out.println(listset1); // {0,2,4,6,8,9}
		  System.out.println(listset1.contains("0")); // true
		 System.out.println(listset1.contains("10")); // false
		  System.out.println();
		  
//		  String s = "a,b,c,d,e,f,g,h,e,j,0,2,4,6,8,9";
//		  for (int i = 0; i < s.length(); i++) {
//			  char c = s.charAt(i);
//
//		  }
	//	  listset2.add(s);
		  listset2.add("2");
		  listset2.add("9");
		//  listset2.add("3");
		  System.out.println(listset2); //
		  System.out.println(listset1.containsAll(listset2)); // true
		  System.out.println(listset2.containsAll(listset1)); // false
		  listset2.remove("9"); 
		  System.out.println(listset2); // 
		
		  listset2.addAll(listset1); 
	      System.out.println(listset2); // 

	      listset2.removeAll(listset1); 
	      System.out.println(listset1); // 
	      System.out.println(listset2); //  
			
	      listset1.clear(); // 
	      System.out.println(listset1); //  
// **************************************************************************
// **************************************************************************
		  System.out.println("*********************************************+");

		  System.out.println();
	      
	      ArraySet<Number> numberlist1 = new ArraySet<>();
		  ArraySet<Number> numberlist2 = new ArraySet<>();
		  numberlist1.add(1.5);
		  numberlist1.add(3);
		  System.out.println(numberlist1); 
		  numberlist2.add(7.9);
		  numberlist2.add(9);
		  numberlist2.add(3);
		  System.out.println(numberlist1.containsAll(numberlist2)); // false
		  numberlist1.addAll(numberlist2);
		  System.out.println(numberlist1); 
	      numberlist1.removeAll(numberlist1); 
		  System.out.println(numberlist1);


		  System.out.println();
		  
		  
		  
	  }

}