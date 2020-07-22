package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class StringHighestSequenceChar {
public static void main(String[] args) {
	String str ="aaabbccccdefff";
	//String str ="abcdef";
	List calclulateUsingDoubleLoop = calclulateUsingDoubleLoop(str);
	System.out.println("highest sequene char is "+calclulateUsingDoubleLoop.get(0) + " with count "+calclulateUsingDoubleLoop.get(1));
}

private static List  calclulateUsingDoubleLoop(String str) {
	List items = new ArrayList();
	//assumption
		int highestSequenceSize = 1;
		char highestSequenceChar = str.charAt(0);
		
		for(int i=0 ; i<str.length();i++) {
			char currentChar = str.charAt(i);
			int consecutiveCount = 1;
			for(int j=i+1 ; j<str.length();j++) {
				int nextChar = str.charAt(j);
				if(nextChar == currentChar) {
					consecutiveCount++;
				}else {
					break;
				}
			}
			if(consecutiveCount > highestSequenceSize) {
				highestSequenceSize = consecutiveCount;
				highestSequenceChar=currentChar;
			}
		}	
		items.add(highestSequenceChar);
		items.add(highestSequenceSize);
		return items;
}
}
