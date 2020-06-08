package selflearning.sorting;

public class TestMergeArrays {
public static void main(String[] args) {
	int leftArray[] ={7,12,15,19,28};
	int rightArray[] ={10,11,13,21,25,32,37};
	int[] merged = new int[leftArray.length + rightArray.length];
	int i = 0, j = 0, k = 0;
	for (; k < merged.length; k++) {
		if(i == leftArray.length  && j == rightArray.length) {
			break;
		}
		else if (i == leftArray.length) {
			// left is full
			// just copy right values
			merged[k] = rightArray[j];
			j++;

		} else if (j == rightArray.length) {
			// right is full
			merged[k] = leftArray[i];
			i++;
		} else {
			if (leftArray[i] < rightArray[j]) {
				merged[k] = leftArray[i];
				i++;

			} else {
				merged[k] = rightArray[j];
				j++;
			}
		}
	}
	EmployeeUtils.printNumbers(merged);
}
}
