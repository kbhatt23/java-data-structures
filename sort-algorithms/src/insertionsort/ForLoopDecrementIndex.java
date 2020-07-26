package insertionsort;

public class ForLoopDecrementIndex {
public static void main(String[] args) {
	int startIndex =1;
	for(; startIndex < 4 ; startIndex++) {
		if(startIndex == 2) {
			break;
		}
	}
	System.out.println(startIndex);
}
}
