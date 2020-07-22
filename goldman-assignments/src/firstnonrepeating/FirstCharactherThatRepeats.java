package firstnonrepeating;

import java.util.HashSet;
import java.util.Set;

public class FirstCharactherThatRepeats {
	public static void main(String[] args) {
		String str = "abcdefbd";
		// should return b
		System.out.println(calculateUsingBruteForce(str));
		System.out.println(calculateUsingSmartness(str));
	}
	//O(n2) time complexity
	private static char calculateUsingBruteForce(String str) {

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			for (int j = i + 1; j < str.length(); j++) {
				char nextchar = str.charAt(j);
				if (nextchar == currentChar) {
					return currentChar;
				}
			}
		}
		// default
		return 'c';
	}
	//O(N) time conmplexity
	private static char calculateUsingSmartness(String str) {
		Set<Character> memory = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if(memory.contains(currentChar)) {
				return currentChar;
			}else {
				memory.add(currentChar);
			}
		}
		// default
		return 'c';
	}
}
