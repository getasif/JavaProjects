/**
 * Uses queue to compute permutations of a string without recursion. 
 * Reads from command line input.
 * Author: Akshay
 */ 
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Permute {
	/**
	 * Computes all the permutations of a string without recursion. 
	 * @param s the string to permute
	 */
	public static ArrayList<String> permutations(String s) {
		Queue <String> q = new LinkedList <String>();
		ArrayList <String> list = new ArrayList <String>();
		// Add "|" + str to the queue.
		q.add("|" + s);
		// While the queue is not empty: 
		while (!q.isEmpty()) {
			String t = "";
			// Remove the element at the front:
			String firstElement = q.poll();
			// String before the |
			String [] s2 = firstElement.split("\\|");
			String head = s2[0];
			try {			
				// String after the | to the end:
				t = s2[1];
			} 
			// If | if at the end, add head to the arraylist. 
			catch (Exception ex) {
				list.add(head);
			}
			for (int i = 0; i < t.length(); i++) {
				String perm = head + t.charAt(i) + "|" + t.replace(t.charAt(i) + "", "");
				q.add(perm);
			}
		}			
		return list;
	}
}
