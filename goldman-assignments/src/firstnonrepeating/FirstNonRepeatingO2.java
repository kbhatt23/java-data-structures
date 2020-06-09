package firstnonrepeating;

import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatingO2 {
public static void main(String[] args) {
	String input = "aplaep";
	char firstNonRepeating = findFirstNonRepeatingCharachter(input);
	System.out.println(firstNonRepeating);
}

private static char findFirstNonRepeatingCharachter(String input) {
	Set<Character> processedCharacters = new HashSet<Character>();
	for(int i=0; i < input.length() ; i++) {
		char currentCharachter = input.charAt(i);
		if(processedCharacters.contains(currentCharachter)) {
			continue;
		}
		boolean nonRepeating = true;
		for(int j=i+1 ; j<input.length() ; j++) {
			char nextCharachter = input.charAt(j);
			if(nextCharachter== currentCharachter) {
				nonRepeating = false;
				processedCharacters.add(currentCharachter);
				break;
			}
		}
		if(nonRepeating) {
			return currentCharachter;
		}
	}
	System.out.println("No character present");
	return 'c';
}
}
