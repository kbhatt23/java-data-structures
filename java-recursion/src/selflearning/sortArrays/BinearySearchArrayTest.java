package selflearning.sortArrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
class BinearySearchArrayTest {
	@Test
	void test() {
		int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		Arrays.sort(arr);
		for(int i= 0 ; i < arr.length ; i++) {
			int indexFound = BinearySearchRestest1.binarySerach(arr, arr[i], 0, arr.length-1);
			assertEquals(i, indexFound);
		}
	}

}
