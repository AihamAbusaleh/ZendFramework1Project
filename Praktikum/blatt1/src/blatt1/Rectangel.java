package blatt1;


public class Rectangel implements Shape{
	
	private double  width ;
	private double  height ;
	private Point p;

	
	public Rectangel(Point p) {
		this.p = p;
	}

	
	public Rectangel(double x, double y) {
		this.width = x;
		this.height = y;
	}


	public void setCenter(Point x) {
		this.p = x;
		
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

	public double getArea() {
		return width*height;
	}


//	@Override
//	public String toString() {
//		return "Rectangel ::  getCenter()= " + getCenter() +  " , getWidth()= "
//				+ getWidth() +  " , getHeigh()= " + getHeigh() +  " , getArea()= "
//				+ getArea() + "";
//	}
	@Override
	public String toString() {
		return "           "
				+ "Rectangel ::   Center : "  + getCenter() +  "|  Breite = "
				+ getWidth() + " |  Höhe = " + getHeigh()  +  " |  Flächeninhalt = "
				+ getArea() + "";
	}
	
	
}
