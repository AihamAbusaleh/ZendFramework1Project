package blatt1;


public class Point {
		
		private double x ;
		private double y ;
		
		public Point() {
			this(0,0);    // was wäre wenn hier nix stehen würde 
		}
		
		public Point(Point p) {
			this(p.x, p.y);
		}

		public Point(double  x, double  y) {
			this.x = x;
			this.y = y;
		}

		public void setX(double x){
			this.x = x;
		}
		
		public double getX(){
			return x;
			
		}
		
		public void setY(double y){
			this.y=y;
			
		}
		
		public double getY(){
			return y;
			
		}

		public String toString() {
			return " x = " + getX() + " y = " + getY();
		}
		
	
		
}
