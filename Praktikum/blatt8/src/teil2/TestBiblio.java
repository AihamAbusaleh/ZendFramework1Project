package teil2;

public class TestBiblio {

	public static void main(String[] args) {
//		Benutzer user1 = new Benutzer("ICH");
//		user1.ausleihen(new Buch("EINFÜHRUNG IN COMPUTERGRAFIK 2015"));
//		System.out.println( user1.getMybooks().get(0).getName() + " wurde jetzt ausgeliehen von : "
//				+ user1.getName());
//		Buch buch = new Buch("PROGRAMMIER 2");
//		user1.ausleihen(buch);
//		System.out.println(buch.getName() + " wurde jetzt ausgeliehen von : "
//				+ user1.getName());
//		user1.zurueckgeben(buch);
//		// buch.userentfernen();
//		// System.out.println(user1.getName());
//		System.out.println("Das ausgeliehene Buch :" + buch.getName()
//				+ " wurde eben von " + user1.getName() + " zurückgegeben");

		
		Buch b1 = new Buch("B1");
		Buch b2 = new Buch("B2");
		Buch b3 = new Buch("B3");
		
		Benutzer u1 = new Benutzer("U1");
		Benutzer u2 = new Benutzer("U2");
		
		u1.ausleihen(b1);
		u1.ausleihen(b2);
		u2.ausleihen(b3);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(u1);
		System.out.println(u2);
		
		System.out.println("--------11111---------");

		
		b2.setUser(u2);
		//u2.ausleihen(b2);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(u1);
		System.out.println(u2);
		System.out.println("----------2222222-------------");

		b2.userentfernen();
		b2.setUser(u2); 
	
		
		System.out.println("--3333333333---");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(u1);
		System.out.println(u2);
		
		
		
		
		
	}

}
