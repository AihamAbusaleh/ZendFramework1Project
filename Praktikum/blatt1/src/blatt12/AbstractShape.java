package blatt12;

import blatt1.Point;
import blatt1.Shape;

public abstract class  AbstractShape implements Shape {
	
	private double  width ;
	private double height ;
	private Point p ;
	public final static double PI = Math.PI; 

	
	
	public AbstractShape(Point p) {
		setCenter(p);

	}
	public AbstractShape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public abstract  double getArea();
	
	public void  setCenter(Point p) {
		this.p = new Point(p);
	}
	public Point getCenter() {
		return p;
	}

	public void setWidt(double x) {
		this.width = x;
	}
	public double getWidth() {
		return width;
	}
	public void setHeight(double y) {
		this.height=y;
	}
	public double getHeigh() {
		return height;
	}



}
