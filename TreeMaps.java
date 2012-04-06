/**
 * Finds two words with the same hash code.
 * Reads input from the command line.
 * @author Akshay 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
public class TreeMaps {
	public static void main(String [] args) {
		Map <Integer, TreeSet<String>> map = new HashMap <Integer, TreeSet<String>>();
		Scanner in = new Scanner(System.in);
		String input;
		while (in.hasNext()) {
			TreeSet<String> tree = new TreeSet<String>();
			input = in.next();
			if (!map.containsKey(input.hashCode())) {
				tree.add(input);
				map.put(input.hashCode(), tree);
			}
			else {
				map.get(input.hashCode()).add(input);
			}
		}
		for (Integer key : map.keySet()) {
			TreeSet<String> value = map.get(key);
			if (value.size() > 1)
				System.out.println(key + ": " + value.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
		}
	}
}
