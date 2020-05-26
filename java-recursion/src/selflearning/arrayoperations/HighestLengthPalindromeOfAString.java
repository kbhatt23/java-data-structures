package selflearning.arrayoperations;

public class HighestLengthPalindromeOfAString {

	public static void main(String[] args) {
		String text = "BANANA";
		String highestSubStringPalindrome = findHigehstLengthPalindrome(text);
		System.out.println(highestSubStringPalindrome);
	}

	private static String findHigehstLengthPalindrome(String text) {
		// fake value is 'a'
		String highestStr = "a";
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			// we need two for loop here
			for (int j = i + 1; j < characters.length; j++) {
				String textToCheck = text.substring(i, j + 1);
				if (PalindromeIDentification.checkIfPalindrome(textToCheck)) {
					System.out.println("found palindrome " + textToCheck);
					if (textToCheck.length() > highestStr.length()) {
						highestStr = textToCheck;
					}
				}
			}
		}
		return highestStr;
	}
}
