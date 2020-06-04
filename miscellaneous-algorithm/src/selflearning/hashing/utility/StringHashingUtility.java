package selflearning.hashing.utility;


public class StringHashingUtility {
	public static void main(String[] args) {
		System.out.println(asciiHashingForString("jai shree radhe", 16));
	}

	public static int asciiHashingForString(String str, int arrySize) {
		if(str == null || "".equals(str)) {
			throw new RuntimeException("key can not be empty");
		}
		char[] chars = str.toCharArray();
		int sum = 0;
		for(char c: chars) {
			sum+=c;
		}
		return sum%arrySize;
		
	}
}
