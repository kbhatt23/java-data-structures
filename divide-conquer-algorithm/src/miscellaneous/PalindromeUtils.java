package miscellaneous;

public class PalindromeUtils {
public static void main(String[] args) {
	String str = "abcdefgh";
	String createPalindromeString = createPalindromeString(str);
	System.out.println("plaindromme of string "+str+ " : "+createPalindromeString);
}
public static String createPalindromeString(String str) {
	StringBuilder palindromeStr = new StringBuilder();
	for(int i = str.length()-1 ; i>=0 ; i--) {
		palindromeStr.append(str.charAt(i));
	}
	return palindromeStr.toString();
}

}
