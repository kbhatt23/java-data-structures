package queueds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueChallenge {

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
    	Deque<Character> stack = new LinkedList<Character>();
    	Deque<Character> queue = new LinkedList<Character>();
    	for(char c : string.toLowerCase().toCharArray()) {
    		if(c >= 'a' && c <= 'z') {
    			//a-z characters allow only, removing space, punctionation etc
    			stack.push(c);
    			queue.offer(c);
    		}
    	}
    	//StringBuilder sbNornal = new StringBuilder();
    	//while(!queue.isEmpty()) {
    	//	sbNornal.append(queue.poll());
    	//}
    	//StringBuilder sbReverse = new StringBuilder();
    	//while(!stack.isEmpty()) {
    		//sbReverse.append(stack.pop());
    	//}
    	//implemeting in better way -> stack and queue size will be same
    	boolean isPalindrome= true;
    	for(int i=0 ; i< queue.size();i++) {
    		if(!queue.poll().equals(stack.pop())) {
    			System.out.println("lets break it");
    			isPalindrome = false;
    			break;
    		}
    	}
        return isPalindrome;
    }
}
