package blatt9;

import java.awt.Color;

public class ArrayDraw {

	private ArrayDraw() {
	}

	public static void init(final int b, final int h) {
		StdDraw.setCanvasSize(b, h);
		StdDraw.clear(Color.WHITE);
		// StdDraw.filledRectangle(0.5, 0.5, 1, 1);
		// StdDraw.setPenColor(Color.WHITE);

	}

	public static void draw(final int[] a, Color c) {
		for (int i = 0; i < a.length; i++) {

		}
		StdDraw.show(10);
	}

	public static void draw(final int[] a, int i, Color c) {

		StdDraw.show(10);

	}

	public static void showTime() {
		System.out.println("Time since start : " + System.nanoTime());

	}

}
