package selflearning.arrayoperations;

public class DeletingTwoDArrayItem {

	public static void main(String[] args) {
		int numberToDelete = 9;
		int[][] twodArray =populateArray();
		String message1 = "printing arrays before deleting";
		printArray(twodArray, message1);
		int[] index = findItemIndexes(twodArray, numberToDelete);
		if(index[0] == -1 || index[1] == -1) {
			throw new RuntimeException("Number not present ");
		}

		deleteItemFromArray(twodArray, index);
		String message2 = "printing arrays after deleting";
		printArray(twodArray, message2);
	}

	private static void printArray(int[][] twodArray, String message) {
		System.out.println(message);
		for(int i = 0 ; i <twodArray.length; i++) {
			System.out.println("pring arrays at index "+i);
			for(int j=0; j < twodArray[i].length ; j++) {
				System.out.println(twodArray[i][j]);
			}
		}
	}

	private static void deleteItemFromArray(int[][] twodArray, int[] index) {
		int row = index[0];
		int column = index[1];
		int[] arrayToManipulate = twodArray[row];
		int[] newArray = new int[arrayToManipulate.length-1];
		for(int i=0;i<newArray.length;i++) {
			if(i < column)
			{
				newArray[i] = arrayToManipulate[i];
			}else {
				newArray[i] = arrayToManipulate[i+1];
			}
		}
		//modifuing array in main array
		twodArray[row] = newArray;
	}

	private static int[][] populateArray() {
		int[][] twodArray = new int[3][4];
		int value = 1;
		for(int i = 0 ; i <twodArray.length ; i++) {
			for(int j =0; j < twodArray[i].length ; j++) {
				twodArray[i][j] = value;
				value++;
			}
		}
		return twodArray;
	}

	private static int[] findItemIndexes(int[][] twodArray, int numberToDelete) {
		int[] index = { -1, -1 };
		outer: for (int i = 0; i < twodArray.length; i++) {
			int[] innerArray = twodArray[i];
			for (int j = 0; j < innerArray.length; j++) {
				if (twodArray[i][j] == numberToDelete) {
					index[0] = i;
					index[1] = j;
					break outer;
				}
			}
		}
		return index;
	}
}
