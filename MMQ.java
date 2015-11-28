import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 */

/**
 * @author martinellimi
 * @version 27 Nov 2015
 * @description MMQ.java Class description 
 */
public final class MMQ {
	
	public static void main(String[] args) {
		Order order = new Order();
	    	for(int i = 0; i <= 8; i++) {
	    		for(int j = i+1; j <= 9; j++) {
	    			for(int k = j+1; k <=10; k++) {
	    				for(int m = k+1; m <=11; m++) {
	    					System.out.println("*****************************INICIO*****************************");
	    					order.order(MMQ.createArray(i, j, k, m));
	    				}
	    			}
	    		}
    	}
	}
	
	public static final void printArrayBiDimensional(final double arrayBiDimensional[][]) {
        System.out.println("");
        
        for (int i = 0; i < arrayBiDimensional.length; i++) {
            for (int j = 0; j < arrayBiDimensional[i].length; j++) {
                System.out.print("[" + formatDouble(arrayBiDimensional[i][j]) + "]" + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
	
	public static final String formatDouble(double value) {
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        return formatter.format(value);
    }
	
	public static final double[][] createArray(int n, int i, int j, int k) {
		double[] arrayEnergia = new double[]{11, 2, 4, 6, 18, 4, 1, 15, 21, 6, 20, 36};
    	double[] arrayCarboidrato = new double[]{0, 2, 5, 9, 25, 6, 1, 20, 22, 11, 33, 0};
    	double[] arrayProteina = new double[]{36, 4, 6, 3, 13, 1, 1, 11, 20, 2, 0, 1};
    	double[] arrayFibras = new double[]{0, 0, 34, 6, 8, 7, 5, 9, 205, 6, 0, 0};
    	double[] arraySodio = new double[]{0.0524, 0.0715, 0.0018, 0.0012, 0, 0.0021, 0.001, 0.6477, 0.0011, 0, 0, 0.5787};
    	
    	double arrayBiDimensional[][] = new double[5][4];
    	
    	arrayBiDimensional[0] = new double[]{arrayEnergia[n], arrayEnergia[i], arrayEnergia[j], arrayEnergia[k]};
    	arrayBiDimensional[1] = new double[]{arrayCarboidrato[n], arrayCarboidrato[i], arrayCarboidrato[j], arrayCarboidrato[k]};
    	arrayBiDimensional[2] = new double[]{arrayProteina[n], arrayProteina[i], arrayProteina[j], arrayProteina[k]};
    	arrayBiDimensional[3] = new double[]{arrayFibras[n], arrayFibras[i], arrayFibras[j], arrayFibras[k]};
    	arrayBiDimensional[4] = new double[]{arraySodio[n], arraySodio[i], arraySodio[j], arraySodio[k]};
    	
    	System.out.println("Matriz");
    	
    	printArrayBiDimensional(arrayBiDimensional);
    	
    	double arrayBiDimensionalT[][] = new double[4][5];
    	
    	arrayBiDimensionalT[0] = new double[]{arrayEnergia[n], arrayCarboidrato[n], arrayProteina[n], arrayFibras[n], arraySodio[n]};
    	arrayBiDimensionalT[1] = new double[]{arrayEnergia[i], arrayCarboidrato[i], arrayProteina[i], arrayFibras[i], arraySodio[i]};
    	arrayBiDimensionalT[2] = new double[]{arrayEnergia[j], arrayCarboidrato[j], arrayProteina[j], arrayFibras[j], arraySodio[j]};
    	arrayBiDimensionalT[3] = new double[]{arrayEnergia[k], arrayCarboidrato[k], arrayProteina[k], arrayFibras[k], arraySodio[k]};
    	
    	System.out.println("Matriz Transposta");
    	
    	printArrayBiDimensional(arrayBiDimensionalT);
    	
    	double arrayResult[][] = new double[5][1];
    	arrayResult[0] = new double[]{100};
    	arrayResult[1] = new double[]{100};
    	arrayResult[2] = new double[]{100};
    	arrayResult[3] = new double[]{100};
    	arrayResult[4] = new double[]{2};
    	
    	double matriz[][] = new double[4][4];
    	
    	double result[][];
    	
    	Multiplicacao_Matrizes m = new Multiplicacao_Matrizes();
    	matriz = m.multiplicaMatriz(arrayBiDimensionalT, arrayBiDimensional);
    	result = m.multiplicaMatriz(arrayBiDimensionalT, arrayResult);
    	
    	System.out.println();
    	System.out.println("Matriz");
    	printArrayBiDimensional(matriz);
    	System.out.println("Matriz Result");
    	printArrayBiDimensional(result);
    	
    	double matriz_sistema[][] = new double[4][5];
    	
    	for(int a = 0; a < matriz.length; a++) {
    		for(int b = 0; b < matriz[a].length; b++) {
    			matriz_sistema[a][b] = matriz[a][b];
    			matriz_sistema[a][4] = result[a][0];
    		}
    	}
    	
    	
    	System.out.println("Matriz SISTEMA");
    	printArrayBiDimensional(matriz_sistema);
    	
    	return matriz_sistema;
	} 
   
}
