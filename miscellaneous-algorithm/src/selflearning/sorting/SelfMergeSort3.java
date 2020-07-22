package selflearning.sorting;

public class SelfMergeSort3 {

	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		mergeSortRecursively(numbers, 0, numbers.length-1);
		EmployeeUtils.printNumbers(numbers);
		
	}
	
	private static void mergeSortRecursively(int[] numbers, int start,int end) {
		if(end > start) {
			int mid = (start+end)/2;
			mergeSortRecursively(numbers, start, mid);
			mergeSortRecursively(numbers, mid+1, end);
			merge(numbers,start,mid,end);
		}
	}

	private static void merge(int[] numbers, int start, int mid, int end) {
		int sizeFirst = mid-start+1;
		int sizeSecond = end-mid;
		int[] firstArray = new int[sizeFirst];
		int[] secondArray = new int[sizeSecond];
		for(int i=0; i<sizeFirst ; ++i) {
			firstArray[i] = numbers[i+start];
		}
		for(int j=0; j<sizeSecond ; ++j) {
			secondArray[j] = numbers[mid+1+j];
		}
		
		int i=0;int j=0;
		int k = start;
		while(i < sizeFirst &&  j < sizeSecond) {
			if(firstArray[i] <= secondArray[j]) {
				numbers[k] = firstArray[i];
				i++;k++;
			}else {
				numbers[k] = secondArray[j];
				k++;j++;
			}
		}
		while(i < sizeFirst) {
			numbers[k] = firstArray[i];
			i++;k++;
		}
		while(j < sizeSecond) {
			numbers[k] = secondArray[j];
			j++;k++;
		}
	}

}
