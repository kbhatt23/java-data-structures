package miscellaneous;

public class LongestCommonSubsequence {
public static void main(String[] args) {
	//String str1 = "elephant";
	String str1 = "houdini";
	String str2 = "hdupti";
	//should be lesser one so that less to iterate as if one is not there 
	int sizeToITerate = (str1.length() < str2.length()) ? str1.length():str2.length();
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<sizeToITerate ; i++ ) {
		char str1Char = str1.charAt(i);
		char str2Char = str2.charAt(i);
		if(str1Char == str2Char) {
			sb.append(str1Char);
		}else {
			if(str2.length()>i+1&& str1Char == str2.charAt(i+1)) {
				sb.append(str1Char);
			}
			else if(str1.length()>i+1 && str2Char == str1.charAt(i+1)) {
				sb.append(str2Char);
			}
		}
	}
	System.out.println(sb.toString());
}
}
