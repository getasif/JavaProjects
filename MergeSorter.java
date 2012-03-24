/**
 * This class sorts an array, using the merge sort 
 * algorithm nonrecursively.
 */
public class MergeSorter {
	private int[] a;
	/**
	 *  Constructs a merge sorter.
	 *  @param anArray the array to sort
	 */
	public MergeSorter(int[] anArray) {
		a = anArray;
	}
	/**
	 *  Sorts the array managed by this merge sorter.
	 */  
	public void sort() { 
		int size = 1;
		int from = 0;
		int to = a.length - 1;       
		if (a.length <= 1) return;
		while (size < to - from)
		{ 
			for (int i = from; i <= to; i = i + (size * 2))
			{  
				merge(i, i + size - 1, (i + (size * 2)) - 1);
			}
			size = 2 * size;
		}
	}
	/**
	 * Merges the array
	 * @param from the index to start from
	 * @param mid the middle element
 	 * @param to the index to end to
	 */
	public void merge(int from, int mid, int to) {       
		System.out.println("Merging " + from + "..." + mid 
				+ " and " + (mid + 1) + "..." + to);		
		int first[];
		int second[];
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		first = new int[mid - from + 1];
		second = new int[to - mid + 2];
		
		// Copy the first half elements in a[] into first[]
		for (int i = from, k = 0; i <= mid; i++, k++)
			first[k] = a[i];
		// Copy the elements in second half of a[] into second[]
		for (int i = mid + 1, k = 0; i <= to; i++, k++) 
			second[k] = a[i];		
		while (iFirst < first.length && iSecond < second.length) {
			if(first[iFirst] < second[iSecond]) {
				a[j] = first[iFirst];
				iFirst++;
			}
			else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		/* Copy remaining entries to the first half */ 
		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++; j++;
		}
		/* Copy remaining entries to the second half */ 
		while (iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++; j++;
		}
	}    
}