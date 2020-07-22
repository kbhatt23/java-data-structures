package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class CharacterWithHighestCommonSequenceInTwoString {

	public static void main(String[] args) {
		String s1 = "aabbbcdeffghbbbb";
		String s2 = "acdeffbbbb";
		//we need to find all consecutive sequenced character in any one string
		
		//assumption
			List<String> populateConsequetiveStirngs = populateConsequetiveStirngs(s1);	
			String bestSequence = populateConsequetiveStirngs.stream().filter(s -> s2.contains(s)).
									max((str1,str2) -> Integer.valueOf(str1.length()).compareTo(Integer.valueOf(str2.length())))
									.orElseThrow(RuntimeException::new)
									;
					
			System.out.println(bestSequence);
	}

	public static List<String> populateConsequetiveStirngs(String s1) {
		List<String> consecutiveCharSequences = new ArrayList<String>();
		List<Integer> indicesToSkip = new ArrayList<Integer>();
		for(int i=0 ; i<s1.length();i++) {
			if(indicesToSkip.contains(i)) {
				continue;
			}
			char currentChar = s1.charAt(i);
			StringBuilder currentSequnce = new StringBuilder();
			for(int j=i+1 ; j<s1.length();j++) {
				char nextChar = s1.charAt(j);
				if(nextChar == currentChar) {
					indicesToSkip.add(j);
					if(currentSequnce.length() == 0) {
						currentSequnce.append(currentChar);
					}
					currentSequnce.append(nextChar);
				}else {
					break;
				}
			}
			if(currentSequnce.length() > 1) {
				consecutiveCharSequences.add(currentSequnce.toString());
			}
		}
		return consecutiveCharSequences;
	}

}
