package runlengthencoding;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RunLengthEncoding {
	public static void main(String[] args) {
		// shud return charachter then number of times this is presetn in string
		String input = "aabbbacccbabbc";
		String output = processRunLengthEncoding(input);
		System.out.println(output);
	}

	private static String processRunLengthEncoding(String input) {
		Map<Character, Integer> charLengthMap = new HashMap<Character, Integer>();
		for(int i=0 ; i<input.length() ; i++) {
			char charachter  = input.charAt(i);
			if(charLengthMap.containsKey(charachter)) {
				charLengthMap.put(charachter, charLengthMap.get(charachter)+1);
			}else {
				charLengthMap.put(charachter, 1);
			}
		}
		return charLengthMap.entrySet()
					.stream()
					.map(entry -> {
						StringBuilder sb = new StringBuilder();
						sb.append(entry.getKey()).append(entry.getValue());
						return sb.toString();
					})
					.collect(Collectors.joining())
					;
	}
}
