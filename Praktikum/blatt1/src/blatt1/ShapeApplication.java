package blatt1;


public class ShapeApplication {
	
	public static void main(String [ ] args){
		
		Point p  = 	new	Point(1,2);
	
		
		Shape s1 =	new   Ellipse(p); // Ellipse implementiert Shape 
		s1.setHeight(3);
		s1.setWidt(4);
		
		Shape s2 =	new   Rectangel(p);
		s2.setHeight(5);
		s2.setWidt(6);
		
	//	totalArea();	// staische Methode aufrufen
		System.out.println(s1 + " " + s2);
		p.setY(8);
		p.setX(10);	 // s1 und s2 sollten unveraendert bleiben: Point hat nix mit Ergebnis zu tun !
		System.out.println(s1 + " " + s2);
//		
//		Rectangel[] r = new Rectangel[5];
//		Ellipse[] e = new Ellipse[4];
//	
//		System.out.println("Summe der Rechteckflaechen: " + totalArea(r));
//		System.out.println("Summe der Kreisflaechen: " + totalArea(e));
	}
	static double totalArea(Shape[] a) {
			double sum= 0;
			for (Shape shape : a) {	
				sum += shape.getArea();
			}
			return sum;		
	}
}