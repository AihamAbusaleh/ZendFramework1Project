package blatt1;


public class Ellipse implements Shape {
	
	public final static double PI = Math.PI; 
	private double  width;
	private double  heigh ;
	private Point   p;

	public Ellipse( Point p) {
		 this.p = p;
	}

	public Ellipse(double h, double b) {
		this.width = h;
		this.heigh = b;
	}


	public void setCenter(Point p) {
			this.p = p;
	}

	public Point getCenter() {
		return p ;
	}

	public void setWidt(double x) {
			this.width = x;
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(double y) {
		this.heigh=y;
	}

	public double getHeigh() {
		return heigh;
	}
	
//http://www.ulivollmer.de/Rechnen/Geometrie_Flaechen_Ellipse.php
	public double getArea() {
		return PI*width*heigh/4; //Große und kleine Halbachsen Breite bzw. Länge  
	}

//	@Override
//	public String toString() {
//		return "Ellipse [getCenter()=" + getCenter() + ", getWidth()="
//				+ getWidth() + ", getHeigh()=" + getHeigh() + ", getArea()="
//				+ getArea() + "]";
//	}
//	
	@Override
	public String toString() {
		return "       "
				+ "Ellipse ::   Center : "  + getCenter() +  "|  Breite = "
				+ getWidth() + " |  Höhe = " + getHeigh()  +  " |  Flächeninhalt = "
				+ getArea() + "";
	}
	

}
