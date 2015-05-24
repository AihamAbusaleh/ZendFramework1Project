package blatt12;

import blatt1.Point;

public class Ellipse extends AbstractShape {
		

	public Ellipse(Point p) {
		super(p);
	}
	public Ellipse(double width, double height) {
	super(width,height);
	}
	@Override
	public double getArea() {
		return PI*(getWidth()*getHeigh())/4;
	}

	@Override
	public String toString() {
		return "       "
				+ "Ellipse  ::   Center : "  + getCenter() +  "|  Breite = "
				+ getWidth() + " |  Höhe = " + getHeigh()  +  " |  Flächeninhalt = "
				+ getArea() + "";
	}

	

}
