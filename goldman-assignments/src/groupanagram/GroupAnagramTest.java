package groupanagram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagramTest {

	public static void main(String[] args) {
		String input = "cat a12 dog tac act sat tas god dog ast odg ogd";
		String output = groupAnagram(input);
		System.out.println("output is " + output);
	}

	private static String groupAnagram(String input) {
		if (input == null || input.length() == 0) {
			System.out.println("can not process null or empty string");
			return null;
		}
		String[] words = input.split(" ");
		List<String> anagramList = new ArrayList<>();
		List<Integer> processStringsIndex = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String currentWord = words[i];
			if (processStringsIndex.contains(i)) {
				continue;
			}
			anagramList.add(currentWord);
			for (int j = i + 1; j < words.length; j++) {
				String nextWord = words[j];
				if (currentWord.equals(reverseAString(nextWord))) {
					anagramList.add(nextWord);
					processStringsIndex.add(j);
				}
			}
		}

		return anagramList.stream().collect(Collectors.joining(" "));
	}

	private static String reverseAString(String string) {

		StringBuilder sb = new StringBuilder();

		for (int i = string.length() - 1; i >= 0; i--) {
			sb.append(string.charAt(i));
		}
		return sb.toString();
	}

}
