import java.util.logging.Logger;
public class ThreeSorter {
	private int[] a;

	public ThreeSorter(int[] anArray) {
		a = anArray;
	}
	/**
	 * Sorts the array with the elements in an ascending order. 
	 */
	public void sort() {
		for (int i = 0; i < a.length; i++) {
			int minPos = minimumPosition(i);
			swap(minPos, i);
		}
	}
	/**
	 * Returns the minimum index of an array
	 * @param from the index to start searching from
	 * @return the minimum position
	 */
	private int minimumPosition(int from) {
		int minPos = from;
		for (int i = from + 1; i < a.length; i++) 
			if(a[i] < a[minPos]) minPos = i;
		return minPos;
	}    
	/**
	 * Sorts the three elements a[start], a[start + 1], a[start + 2].
	 * If start > a.length - 3, sorts the one or two remaining elements.
	 */
	public void sortThree(int start) {
			if (a[start] > a[start+1])
				swap(start, start + 1);
			if(a[start + 1] > a[start +2])
				swap(start + 1, start + 2);		
			if(a[start] > a[start+2])
				swap(start, start + 2);
	}
	/**
	 * Checks whether the array managed by this sorter is sorted.
	 *  @return true if the array is sorted
	 */
	public boolean isSorted() {
		int i;
		boolean isSorted = true;
		for (i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i+1]) {
				isSorted = false;
			}
		}
		return isSorted;
	}
	/**
	 * Swaps two entries of the array.
	 * @param i the first position to swap
	 * @param j the second position to swap
	 */
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
