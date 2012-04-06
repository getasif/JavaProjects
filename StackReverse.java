/**
 * Reverses the words of a sentence using a stack. 
 * @author Akshay
 */
import java.util.Scanner;
import java.util.Stack;
public class StackReverse {
	public static void main (String [] args) {
		Stack<String> words = new Stack<String>();
		Scanner in = new Scanner(System.in);
		int j= 0;
		while (in.hasNext()) {
			String[] input = in.next().split(" ");
			int i;
			for (i = 0; i <= input.length - 1 ; i++) {
				words.push(input[i]);
			}
		}
		while(!words.empty()) {
			String result = words.pop();
			char ch;
			if (j == 0) {
				 ch = Character.toUpperCase(result.charAt(0));
				 result = result.replace(result.charAt(0), ch);
			}
			result = result.replace(".", "");
			// If the last word popped is in uppercase, lowercase it.
			if (words.size() == 0) {
				if (Character.isUpperCase(result.charAt(0)))
					Character.toLowerCase(result.charAt(0));
				System.out.print(result + ".");
			}
			else 
				System.out.print(result + " ");
			j++;
		}
	}
}
