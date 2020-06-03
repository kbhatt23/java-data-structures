package selflearning.ds.binarytsearchtree;

import java.util.Set;
import java.util.TreeSet;

public class SetOOBBinarySearchTreeImpl {
public static void main(String[] args) {
	Set<Integer> set = new TreeSet<Integer>();
	set.add(11);
	set.add(1);
	set.add(13);
	set.add(16);
	set.add(6);
	set.add(23);
	set.add(33);
	set.add(26);
	set.add(9);
set.stream().forEach(System.out::println);	
	
}
}
