package selflearning.arrayoperations;

public class PalindromeIDentification {
	public static void main(String[] args) {
		String text = "ABCDEGEDCBA";
		boolean isPalindrome = checkIfPalindrome(text);
		System.out.println("Is " + text + " palindrome: " + isPalindrome);
	}

	public static boolean checkIfPalindrome(String text) {
		char[] fowrardChars = text.toCharArray();
		char[] reverseChars = new char[fowrardChars.length];
		int k = 0;
		for (int i = reverseChars.length - 1; i >= 0; i--) {
			reverseChars[k] = fowrardChars[i];
			k++;
		}
		String reverseText = String.valueOf(reverseChars);

		StringBuilder sb = new StringBuilder();
		for (char ch : reverseChars) {
			sb.append(ch);
		}
		// below is own logic
		reverseText = sb.toString();
		return reverseText.equals(text);
	}
}
