package dictionary;

import java.util.HashSet;
import java.util.Set;

public class DictionaryTest {
	private static final Set<String> DICTIONARY ;
	static {
		DICTIONARY = new HashSet<String>();
		DICTIONARY.add("to");DICTIONARY.add("toe");
		DICTIONARY.add("torotoise");DICTIONARY.add("toes");
		DICTIONARY.add("toss");DICTIONARY.add("token");
	}
	public static void main(String[] args) {
		String inputCharachters = "toe";
		String bestWord = null;
		for(String word :DICTIONARY) {
			boolean hasAllCharachters = true;
			for(char charachter : inputCharachters.toCharArray()) {
				if(word.indexOf(charachter) == -1) {
					hasAllCharachters = false;
					break;
				}
			}
			if(hasAllCharachters) {
				if(bestWord == null) {
					bestWord = word;
				}else {
					if(bestWord.length() < word.length()) {
						bestWord = word;
					}
				}
			}
		}
		System.out.println("bestWord "+bestWord);
	}

}
