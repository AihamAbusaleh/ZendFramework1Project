package blatt12;

import blatt1.Point;


public class Rectangel extends AbstractShape{

	
	public Rectangel(Point p) {
		super(p);
	}
	public Rectangel(double width, double height) {
	super(width,height);
	}

	@Override
	public double getArea() {
		return getHeigh()*getWidth();
	}
	@Override
	public String toString() {
		return "           "
				+ "Rectangel ::   Center : "  + getCenter() +  "|  Breite = "
				+ getWidth() + " |  Höhe = " + getHeigh()  +  " |  Flächeninhalt = "
				+ getArea() + "";
	}

	
	
}
