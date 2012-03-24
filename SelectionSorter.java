import java.util.Comparator;
public class SelectionSorter {
    private Object[] a;
    private Comparator<Object> comparator;
    /**
     * Constructs a SelectionSorter Object
     * @param anArray an array of objects
     */
    public SelectionSorter(Object[] a, Comparator<Object> comparator) {
        this.a = a;
        this.comparator = comparator;
    }  
    /**
     * Sorts the object array.
     */
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            int minPos = minimumPosition(i);
            swap(minPos, i);
        }
    } 
    /**
     * Finds the minimum position in the array
     * @param from the index to start. 
     * @return the minimum position
     */
    private int minimumPosition(int from) {
        int minPos = from;
        for (int i = from + 1; i < a.length; i++) {
            if(comparator.compare(a[i], a[from]) < 0) minPos = i;
        }
        return minPos;
    }                 
    /**
     * Swaps position of the indexes with each other. 
     * @param i an index to be swapped.
     * @param j an index to be swapped.
     */
    public void swap(int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}