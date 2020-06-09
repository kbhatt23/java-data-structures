package tupleofsize;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class AllTuplesUniqueOfSize {
public static void main(String[] args) {
	String input = "abcdefghijk";
	int size=3;
	findAllTuples(input,size)
		.ifPresent(e -> {
			e.forEach(System.out::println);
		});
	;
	
}

private static Optional<Set<String>> findAllTuples(String input, int size) {
	//no need of uniquenens 
	if(input == null || input.length() == 0) {
		System.out.println("can not process null/empty string");
		return Optional.ofNullable(null);
	}
	Set<String> result = new LinkedHashSet<String>();
	for(int i=0; i < input.length() - size; i= i+size) {
			result.add(input.substring(i, i+size));
	}
	System.out.println("result to return "+result);
	return Optional.ofNullable(result);
}
}
