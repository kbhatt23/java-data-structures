package pangramdetector;

public class PangramDetectorTest {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
	String sentence = "jai shree ram";
	
	String missingChars = pangramDetector(sentence,ALPHABET);
	System.out.println("mising string "+missingChars);
		
	}
	private static String pangramDetector(String sentence, String alphabets) {
		StringBuilder sb = new StringBuilder();
		for(char charachter : alphabets.toCharArray()) {
			boolean isCharFound = false;
			for(char charSentence :sentence.toCharArray()) {
				if(charSentence == charachter) {
					isCharFound = true;
					break;
				}
			}
			if(!isCharFound) {
				sb.append(charachter);
			}
		}
		
		return sb.toString();
	}

}
