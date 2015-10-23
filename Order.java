import java.util.Arrays;

public class Order {
    
    private static final int INDEX_TO_COMPARE = 0;
    
    public boolean order(final double arrayBiDimensional[][]) {
    	boolean stop = false;
    	double arrayBiDimensionalOriginal[][] = this.cloneArrayBiDimensional(arrayBiDimensional);
    	
    	double arrayBiDimensionalModified01[][] = this.cloneArrayBiDimensional(arrayBiDimensional);
        
        double arrayBiDimensionalModified02[][] = new double[arrayBiDimensionalModified01.length][arrayBiDimensionalModified01[0].length];
        
        ComparatorArrayBiDimensional comparatorArrayBiDimensional = new ComparatorArrayBiDimensional(Order.INDEX_TO_COMPARE);
        
        for (int count = 0; count < arrayBiDimensional.length; count++) {

            Arrays.sort(arrayBiDimensionalModified01, comparatorArrayBiDimensional);
            arrayBiDimensionalModified02 = copyLinesFromArray((count + 1), arrayBiDimensionalModified01);
            
            double m;
            
            for (int i = 0; i < arrayBiDimensionalModified01.length - 1; i++) {
                m = this.calculateM(arrayBiDimensionalModified01[count][count], arrayBiDimensionalModified01[i+1][count]);
                
                for (int j = 0; j < arrayBiDimensionalModified02[i].length; j++) {
                	if(j < count || i < count) {
                		arrayBiDimensionalModified02[i+1][j] = arrayBiDimensionalModified01[i+1][j];
                	} else {
                		arrayBiDimensionalModified02[i+1][j] = arrayBiDimensionalModified01[count][j] * m + arrayBiDimensionalModified01[i+1][j];
                	}
                }
                
            }
            
            arrayBiDimensionalModified01 = this.cloneArrayBiDimensional(arrayBiDimensionalModified02);
            
        }
	        
	        double[] result = calculateRestul(arrayBiDimensionalModified02);
	       
	        stop = validateResult(result, arrayBiDimensionalOriginal, arrayBiDimensionalModified02);
	    return stop;
	        
    }
    
    public double[][] cloneArrayBiDimensional(final double arrayBiDimensional[][]) {
        double cloneArrayBiDimensional[][] = (arrayBiDimensional).clone();
        
        return cloneArrayBiDimensional;
    }
    
    public double[][] copyLinesFromArray(final int numberOfLinesToCopy, final double arrayBiDimensional[][]) {
        double[][] arrayBiDimensionalCopy = new double[arrayBiDimensional.length][arrayBiDimensional[0].length];
        
        for (int i = 0; i < numberOfLinesToCopy; i++) {
            for (int j = 0; j < arrayBiDimensional[i].length; j++) {
                arrayBiDimensionalCopy[i][j] = arrayBiDimensional[i][j];
            }
        }
        
        return arrayBiDimensionalCopy;
    }
    
    public double calculateM(final double pivot, final double iterationNumber) {
        double m = -iterationNumber / pivot;
        
        return m;
    }
    
    public double[] calculateRestul(final double arrayBiDimensional[][]) {
    	double[] vetorSolucao = new double[arrayBiDimensional.length];
    	
    	int numEquacoes = arrayBiDimensional.length-1;
    	int i = arrayBiDimensional.length-1;
    	
		while ( i >= 0)
		{
			if (i == numEquacoes)
				vetorSolucao[i]= arrayBiDimensional[i][arrayBiDimensional[0].length-1]/arrayBiDimensional[i][i];
			else {
				double temp = 0;

				for (int j = i+1; j <= numEquacoes; j++)
					temp += arrayBiDimensional[i][j] * vetorSolucao[j];
				temp = ( arrayBiDimensional[i][arrayBiDimensional[0].length-1]-temp);
				temp /= arrayBiDimensional[i][i];
				vetorSolucao[i] = temp;
			}
			i--;
		}
    	return vetorSolucao;
    }
    
    public boolean validateResult(final double array[], final double arrayBiDimensionalOriginal[][], final double arrayBiDimensional[][]) {
    	boolean result = false;
    	int positive = 0;
        for (int i = 0; i < array.length; i++) {
        	Double original = array[i];
        	if (array[i] == Math.abs(original))
        	{
        	    //must be positive
        		positive++;
        	}
        }
        if(positive == (array.length)) {
        	System.out.println("**************Sistema***********************");
            Main.printArrayBiDimensional(arrayBiDimensionalOriginal);
            System.out.println("**************Sistema***********************");
            System.out.println();
        	
        	System.out.println("**************Escalonado***********************");
            Main.printArrayBiDimensional(arrayBiDimensional);
            System.out.println("**************Escalonado***********************");
            System.out.println();
            
            System.out.println("**************RESULT*************************");
	        Main.printArray(array);
	        System.out.println("**************RESULT*************************");
	        System.out.println();
            
        	result = true;
        }
        return result;
    }
}
