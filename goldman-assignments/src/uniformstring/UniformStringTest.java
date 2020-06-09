package uniformstring;

public class UniformStringTest {

	public static void main(String[] args) {

		String inputString = "abbbcaaaad";

		if(inputString == null || inputString.length() == 0) {
			System.out.println("string is empty hence can not process");
			return;
		}
		int largestCharStart = 0;
		int largestCharEnd = 1;
		char[] charString = inputString.toCharArray();
		char longestChar = charString[0];
		int sequenceCount = 0;
		System.out.println("initial max character sequence " + inputString.substring(largestCharStart, largestCharEnd));
		for (int i = 0; i < charString.length; i++) {
			char curentChar = charString[i];
			int currentMaxSequence = 0;
			for (int j = i + 1; j < charString.length; j++) {
				char nextChar = charString[j];
				if (nextChar == curentChar) {
					currentMaxSequence++;
				} else {
					break;
				}
			}
			if (currentMaxSequence > sequenceCount) {
				sequenceCount = currentMaxSequence;
				longestChar = curentChar;
				largestCharStart = i;
				largestCharEnd = currentMaxSequence + 2;
			}

		}
		System.out.println("final index start "+largestCharStart + " and end "+largestCharEnd);
		System.out.println("final max character sequence " + inputString.substring(largestCharStart, largestCharEnd));
		System.out.println("real charccter with max " + longestChar);
	}

}
