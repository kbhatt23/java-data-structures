package stackds;

public class StackChallenge {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
    	StackUsingLinkedList<Character> stack = new StackUsingLinkedList<Character>();
    	StringBuilder sbNormal = new StringBuilder();
    	for(char c : string.toLowerCase().toCharArray()) {
    		if(c >='a' && c <='z') {
    			sbNormal.append(c);
    			//stackon iteration give in reverse order
    			stack.push(c);
    		}
    	}
    	StringBuilder sbReverse = new StringBuilder();
    	while(!stack.isEmpty()) {
    		sbReverse.append(stack.pop());
    	}
    	
    	return sbReverse.toString().equals(sbNormal.toString());
    }
}
