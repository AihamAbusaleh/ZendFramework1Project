package blatt9;

import java.util.Random;
import java.util.Scanner;

public class SortAnimation {
	private static int daten[];
	private static int sortMethod = 1;
	private static boolean sorted = false;
	private static int size = 0;
	
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("[1] InsertionSort");
    	System.out.println("[2] QuickSort");
    	System.out.println("[3] 3-Median-QuickSort");
        System.out.print("Welches Sortierverfahren? ");
        sortMethod = input.nextInt();
        
        System.out.print("Anzahl der Daten: ");
        size = input.nextInt();
        
        System.out.print("Daten sortiert? [j/n] ");
        if(input.next().equals("j"))
        	sorted = true;
        
        daten = new int[size];
        for(int i = 0; i < size; i++) {
        	daten[i] = i + 1;
        }
        
        if (!sorted)
        	shuffle();
        
        
        // start animation
        ArrayDraw.init(size, size);
        ArrayDraw.draw(daten,StdDraw.BLUE);
        
        //ArrayDraw.showTime();
        if (sortMethod == 1)
        	Sort.insertionSort(daten);
        else if (sortMethod == 2)
        	Sort.quickSort(daten);
        else if (sortMethod == 3)
        	Sort.quickSort3Median(daten);	
        
    }
    
    
    private static void shuffle() {
    	Random rng = new Random();
    	for(int i = 0; i < size; i++) { // size mal wiederholen
    		int j = (int)(rng.nextDouble() * (size - 1)); 
    		int k = (int)(rng.nextDouble() * (size - 1));
    		int tmp = daten[j];
    		daten[j] = daten[k];
    		daten[k] = tmp;
    	}
    }
}