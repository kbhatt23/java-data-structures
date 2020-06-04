package selflearning.hashing.usinglinearprobing;

import java.util.Arrays;

import selflearning.hashing.utility.StringHashingUtility;

public class HashTableUsingProbing<T> {
//using probing we keep on search for indexing before and after in case of collision
	// we can grow items in case of full items
	// in case collision happens and all indexes are filled we can grow array

	Object[] dataStore;

	public HashTableUsingProbing(int size) {
		dataStore = new Object[size];
	}

	public void insert(T data) {
		int index = calculateHash(data);

		if (dataStore[index] == null) {
			System.out.println("no collision pushing data " + data + " to index " + index);
			dataStore[index] = data;
		} else {
			// using linear probing for collision
			for (int i = index + 1; i < dataStore.length; i++) {
				if (dataStore[i] == null) {
					System.out.println("collision occurred hence pushing data " + data + " to index " + i);
					dataStore[i] = data;
					return;
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (dataStore[i] == null) {
					System.out.println("collision occurred hence pushing data " + data + " to index " + i);
					dataStore[i] = data;
					return;
				}
			}

			// case when all the array is full
			// this is not needed in linked list approach
			
			int currentLength = dataStore.length;
			Object[] newDataStore = new Object[currentLength * 2];
			System.out.println("array size is not capable, hence creating new array with size "+newDataStore.length);
			for (int i = 0; i < currentLength; i++) {
				newDataStore[i] = dataStore[i];
			}
			newDataStore[currentLength] = data;
			dataStore = newDataStore;
		}

	}

	public int calculateHash(T data) {
		int hashCode = StringHashingUtility.asciiHashingForString(data.toString(), dataStore.length);
		int indexToFill = hashCode % dataStore.length;
		return indexToFill;
	}

	public T search(T data) {
		int index = calculateHash(data);
		if (dataStore[index] != null) {
			if (dataStore[index].equals(data)) {
				System.out.println("no collision while searching at index " + index + " data found " + data);
				return (T) dataStore[index];
			}
		} else {
			// using linear probing for collision
			for (int i = index + 1; i < dataStore.length; i++) {
				if (dataStore[i] != null && dataStore[i].equals(data)) {
					System.out.println("collision occurred but data found at index " + i);
					return (T) dataStore[i];
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (dataStore[i] == null && dataStore[i].equals(data)) {
					System.out.println("collision occurred but data found at index " + i);
					return (T) dataStore[i];
				}
			}
		}
		System.out.println("No item found");
		return null;
	}
	public void delete(T data) {
		int index = calculateHash(data);
		if (dataStore[index] != null) {
			if (dataStore[index].equals(data)) {
				System.out.println("no collision while deleting at index " + index + " data found " + data);
				dataStore[index] = null;
			}
		} else {
			// using linear probing for collision
			for (int i = index + 1; i < dataStore.length; i++) {
				if (dataStore[i] != null && dataStore[i].equals(data)) {
					System.out.println("collision occurred while deleting at index " + i);
					dataStore[i] = null;
				}
			}
			for (int i = index - 1; i >= 0; i--) {
				if (dataStore[i] == null && dataStore[i].equals(data)) {
					System.out.println("collision occurred while deleting at index " + i);
					dataStore[i] = null;
				}
			}
		}
		System.out.println("No item found");
	}
	public void printAll() {
		Arrays.stream(dataStore).forEach(System.out::println);
	}
}
