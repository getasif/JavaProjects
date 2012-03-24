/**
 * Tests the SelectionSorter program.
 */
import java.util.*;

public class SelectionSorterTester {
	private static int counter = 0;
	/**
	 * Testes the Selection Sorter
	 */
	public static void main(String[] args) {
		/**
		 * Inner class CountingComparator
		 */
		class CountingComparator implements Comparator<Object> {
			/**
			 * Compares to object with each other.
			 * @param o1 the first object to be compared
			 * @param o2 the second object to be compared
			 */
			public int compare(Object o1, Object o2) {
				++counter;
				int obj1 = (Integer) o1;
				int obj2 = (Integer) o2;
				return obj1 - obj2;
			}
			/**
			 * Gets the counter value.
			 * @return the counter
			 */
			public int getCount() { return counter; }
		}
		CountingComparator comp = new CountingComparator();
		Integer[] a = {11, 9, 17, 5, 12};
		SelectionSorter test = new SelectionSorter(a, comp);
		test.sort();
		//System.out.printf(Arrays.toString(a) + "\n");
		System.out.println(comp.getCount());
		System.out.println("Expected: 10");
	}
}
