package blatt6;

import java.awt.Color;
import java.util.Random;

public class Baum 
{
	private final static double beta = Math.toRadians(30);
	private final static double obergrenze = 250.0;
	private final static double untergrenze = 150.0;
	private final static double start = Math.toRadians(0);
	private final static double end = Math.toRadians(30);

	public static void drawVariante1(double x, double y, double winkel0, double w, int n) 
	{
			if(w < 35)
			{
				StdDraw.setPenColor(Color.GREEN);			
			} else {
				StdDraw.setPenColor(Color.BLACK);			
			}
			
			double c = w * Math.cos(winkel0);
			double s = w * Math.sin(winkel0);
			// A-B
			StdDraw.line(x, y, x + c, y + s);
			// B-C
			StdDraw.line(x + c, y + s, x + c - s, y + s + c);
			// C-D
			StdDraw.line(x + c - s, y + s + c, x - s, y + c);
			// A-D
			StdDraw.line(x, y, x - s, y + c);
			// C-E
			double v = w * Math.sin(beta);
			double u = w * Math.cos(beta);
			
			double ex = x-s+u*Math.cos(beta+winkel0);	// C-E
			double ey = y+c+u*Math.sin(beta+winkel0);
			
			if (n > 0)
			{
				StdDraw.line(x+c-s, y+s+c,ex ,ey);
				// E-D
				StdDraw.line(ex ,ey,x-s,y+c);
				
				drawVariante1(x-s, y+c, winkel0 + beta, u, n-1);
				drawVariante1(ex, ey, beta + winkel0 - Math.PI /2,  v, n-1);
			}
	}

	
	public static void drawVariante2(double x, double y, double winkel0, double w, int n)
	{
		double rand = new Random().nextDouble();
		double h = untergrenze + (rand * (obergrenze - untergrenze));
		double beta1 =  start + (rand * (end - start));
	
		if(w < 35)
		{
			StdDraw.setPenColor(Color.GREEN);			
		} else {
			StdDraw.setPenColor(Color.BLACK);			
		}
		// A-B
		double xb =x + w * Math.cos(winkel0);
		double yb = y + w * Math.sin(winkel0);
		StdDraw.line(x, y, xb,  yb);
		// B-C
		double xc = xb - h * Math.sin(winkel0) ;
		double yc = yb + h * Math.cos(winkel0);
		StdDraw.line(xb,yb, xc,yc);
		// A-D
		double xd = x - h * Math.sin(winkel0) ;
		double yd = y + h * Math.cos(winkel0);
		StdDraw.line(x, y, xd, yd);
		// D-C
		StdDraw.line(xd, yd , xc, yc);
		
		double v = w * Math.sin(beta1);
		double u = w * Math.cos(beta1);
		double xe = xd + u * Math.cos(beta1+winkel0);
		double ye = yd + u * Math.sin(beta1+winkel0);
		
		if (n > 0)
		{
			// E-C
			StdDraw.line(xe,ye,xc, yc);
			// D-E
			StdDraw.line(xd,yd, xe, ye );
			drawVariante2(xd, yd, winkel0 + beta1,  u, n-1);
			drawVariante2(xe, ye, beta1 + winkel0 - Math.PI /2,  v, n-1);
		}
	}
	
	public static void main(String[] args) 
	{	
		// set the scale of the coordinate system
		StdDraw.setXscale(0, 1500);
		StdDraw.show(0);
		StdDraw.setYscale(0, 1500);
		StdDraw.show(0);

		drawVariante1(700, 500, 0, 150, 3);
		StdDraw.show(0);
		
		// Zufallzahlen Variante 2
//		StdDraw.setXscale(0, 1500);
//		StdDraw.show(0);
//		StdDraw.setYscale(0, 1500);
//		StdDraw.show(0);
//
//		drawVariante2(700, 500, 0, 150, 5);
//		StdDraw.show(0);
	}
}
