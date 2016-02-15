package blatt12;

import blatt12.Ellipse;
import blatt1.Point;
import blatt12.Rectangel;
import blatt1.Shape;


public class ShapeApplication {
	
	public static void main(String [ ] args){
		
		Point 	 p = 		new	Point(1,2);
		Shape s1 =	new    Ellipse(p);
		s1.setHeight(3);
		s1.setWidt(4);
		Shape s2 =	new   	Rectangel(p);
		s2.setHeight(3);
		s2.setWidt(4);
		System.out.println(s1 + ""
				+ "\n " + s2);
	
		p.setX(10);						 // s1 und s2 sollten unveraendert bleiben:
		// s2.setCenter(p);
		
		System.out.println(s1 + "\n " + s2);
		
		
		Shape[] r = new Shape[2];
		r[0] =  s2;
		r[1] = s2;
		Shape[] e = new Shape[4];
		e[0] = s1;
		e[1] = s1;
		e[2] = s1;
		e[3] = s1;
	
		System.out.println("Summe der Rechteckflächen: " + totalArea(r));
		System.out.println("Summe der Ellipsenflächen: " + totalArea(e));


	}
	static double totalArea(Shape[ ] a) {
			double sum= 0;
			for (Shape shape : a) {
				
				sum += shape.getArea();
				

			}
			return sum;		

			}
		
		
	
}