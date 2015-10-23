import java.util.Comparator;

public class ComparatorArrayBiDimensional implements Comparator<double[]> {
    private int indexToCompare;
    
    public ComparatorArrayBiDimensional(final int index) {
        indexToCompare = index;
    }

    @Override
    public int compare(double[] element1, double[] element2) {
        return this.compare(element1, element2, this.indexToCompare);
    }
    
    public int compare(double[] element1, double element2[], int index) {
        if (element1.length == index)
            return 0;

        if (element1[index] == element2[index])
            return compare(element1, element2, index + 1); // Vai ordenando pelo proximo
            //return element1[index]; pega o primeiro elemento igual
        
        return (int) (Math.abs(element2[index]) - (Math.abs(element1[index])));
    }
}
