package miscellaneous;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CharachterWithMostOccurrence {
	public static void main(String[] args) {
		String str = "sitaramisbesta";
		Map<Character, Integer> charcount = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (charcount.containsKey(currentChar)) {
				charcount.put(currentChar, charcount.get(currentChar) + 1);
			} else {
				charcount.put(currentChar, 1);
			}
		}
		System.out.println(charcount);
		Map<Character, Integer> sortedMap = charcount.entrySet().stream()
						.sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
						.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
		System.out.println(sortedMap);
		int maxCountVal =sortedMap.entrySet().stream().min((e1,e2) -> e2.getValue().compareTo(e1.getValue())).get().getValue();
		System.out.println(maxCountVal);
		List<Character> collect = sortedMap.entrySet().stream().filter(e -> e.getValue()==maxCountVal).
				map(Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(collect);
	}

}
