package miscellaneous;

public class LongestPalindromicSequence {
public static void main(String[] args) {
	//String str = "MADAM";
	//String str = "ABCCBUA";
	String str = "ABCYRCFBTUA";
	int maxCount = 1;
	String maxCountSequence = new StringBuilder().append(str.charAt(0)).toString();
	for(int i=0 ; i < str.length() ; i++) {
		char currentChar = str.charAt(i);
		StringBuilder sb = new StringBuilder();
		sb.append(currentChar);
		for(int j=i+1 ; j < str.length() ; j++) {
			char nextChar = str.charAt(j);
			sb.append(nextChar);
			String currentStr =sb.toString();
			String palindromicString = PalindromeUtils.createPalindromeString(currentStr);
			if(palindromicString.equalsIgnoreCase(currentStr) && currentStr.length() > maxCount) {
				maxCount = currentStr.length();
				maxCountSequence=currentStr;
			}
		}
	}
	System.out.println(maxCount);
	System.out.println(maxCountSequence);
}
}
