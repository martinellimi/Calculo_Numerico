import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class Main {
    
    public static final void main(final String[] args) {
      Order order = new Order();
      int interaction = 0;
  	  boolean stop = false;
    	for(int i = 0; i <= 8; i++) {
    		for(int j = i+1; j <= 9; j++) {
    			for(int k = j+1; k <=10; k++) {
    				for(int m = k+1; m <=11; m++) {
    					stop = order.order(Main.createArrayBiDimensional(i, j, k, m));
    		        	interaction++;
    				}
    			}
    		}
  	  } 
    	System.out.println("INTERACTION: " + interaction);
    	System.out.println("FINISH: ");
    }
    
    public static final double[][] createArrayBiDimensional(int i, int j, int k, int m) {
    
    	double[] arrayEnergia = new double[]{11, 2, 4, 6, 18, 4, 1, 15, 21, 6, 20, 36};
    	double[] arrayCarboidrato = new double[]{0, 2, 5, 9, 25, 6, 1, 20, 22, 11, 33, 0};
    	double[] arrayProteina = new double[]{36, 4, 6, 3, 13, 1, 1, 11, 20, 2, 0, 1};
    	double[] arrayFibras = new double[]{0, 0, 34, 6, 8, 7, 5, 9, 205, 6, 0, 0};
    	
    	double arrayBiDimensional[][] = new double[4][5];
    	
    	arrayBiDimensional[0] = new double[]{arrayEnergia[i], arrayEnergia[j], arrayEnergia[k], arrayEnergia[m], 100};
    	arrayBiDimensional[1] = new double[]{arrayCarboidrato[i], arrayCarboidrato[j], arrayCarboidrato[k], arrayCarboidrato[m], 100};
    	arrayBiDimensional[2] = new double[]{arrayProteina[i], arrayProteina[j], arrayProteina[k], arrayProteina[m], 100};
    	arrayBiDimensional[3] = new double[]{arrayFibras[i], arrayFibras[j], arrayFibras[k], arrayFibras[m], 100};
      
      return arrayBiDimensional;
    }
    
    public static final void printArrayBiDimensional(final double arrayBiDimensional[][]) {
        System.out.println();
         
        int linesNumber = arrayBiDimensional.length;
        int columnsNumber = arrayBiDimensional[0].length;
        
        System.out.println();
        System.out.println();
        
        for (int i = 0; i < arrayBiDimensional.length; i++) {
            for (int j = 0; j < arrayBiDimensional[i].length; j++) {
                System.out.print("[" + formatDouble(arrayBiDimensional[i][j]) + "]" + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public static final void printArray(final double array[]) {
        System.out.println();
        int linesNumber = array.length;
        System.out.println();
        System.out.println();
        
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + formatDouble(array[i]) + "]" + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static final String formatDouble(double value) {
        NumberFormat formatter = new DecimalFormat("#0.0000000");
        return formatter.format(value);
    }
   
}
