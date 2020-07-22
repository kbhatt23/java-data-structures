package firstnonrepeating;

public class FirstSequentialCharachter {

	public static void main(String[] args) {
		String str = "abcddeeef";
		//String str = "abcddeeef";
		//result shud be d
		char c = calculateUsingComplexLoop(str);
		System.out.println(c);
	}

	private static char calculateUsingComplexLoop(String str) {
		for(int i=0; i < str.length()-1 ; i++) {
			//no need as for loop conditionis updated now
			/*
			 * if(i == str.length()-1) { //last iteration break; }
			 */
			char currentChar = str.charAt(i);
			char nextChar = str.charAt(i+1);
			if(nextChar == currentChar) {
				return currentChar;
			}
		}
		//not found
		return 'c';
	}

}
