package binaryheaps;

public class BinaryHeap {
	private int index;
	private int[] storage;

	public BinaryHeap(int capacity) {
		storage = new int[capacity];
	}

	public boolean isFull() {
		return index == storage.length;
	}

	public void insert(int value) {
		if (isFull()) {
			throw new RuntimeException("Heap is already full");
		}
		storage[index] = value;
		heapifyFromBottomToTop(index);
		index++;

	}

	private void heapifyFromBottomToTop(int indexToHeapify) {
		// no need to heapify for 1st element
		// not using recursion and henc it will never be negative here
		// if we were using recursion to the same method then we needed ot check for
		// negatoive case as well
		if (indexToHeapify == 0) {
			return;
		}
		while (indexToHeapify > 0) {
			int parentIndex = findParentIndex(indexToHeapify);
			if (storage[parentIndex] < storage[indexToHeapify]) {
				int parentValue = storage[parentIndex];
				storage[parentIndex] = storage[indexToHeapify];
				storage[indexToHeapify] = parentValue;
				indexToHeapify = parentIndex;
			} else {
				break;
			}
		}
	}

	public int searchIndex(int value) {
		for (int i = 0; i < index; i++) {
			if (storage[i] == value) {
				return i;
			}
		}
		throw new RuntimeException("Value " + value + " not found");
	}

	public void delete(int value) {
		if(isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		int indexFound = searchIndex(value);
		int parentIndex = findParentIndex(indexFound);
		// just putting the right most element
		storage[indexFound] = storage[index - 1];
		if (indexFound == 0) {
			// root can not heapify above
			heapifyBelow(indexFound, index - 1);

		} else {
			if (storage[parentIndex] > storage[indexFound]) {
				heapifyBelow(indexFound, index - 1);
			} else {
				heapifyFromBottomToTop(indexFound);
			}
		}

		index--;
	}

	public void deleteByIndex(int indexToDelete) {
		if(isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		int indexFound = indexToDelete;
		int parentIndex = findParentIndex(indexFound);
		// just putting the right most element
		storage[indexFound] = storage[index - 1];
		if (indexFound == 0) {
			// root can not heapify above
			heapifyBelow(indexFound, index - 1);

		} else {
			if (storage[parentIndex] > storage[indexFound]) {
				heapifyBelow(indexFound, index - 1);
			} else {
				heapifyFromBottomToTop(indexFound);
			}
		}

		index--;
	}
	//mostly in heap we care about peeking and remvoing root only
	public void deleteRoot() {
		deleteByIndex(0);
	}

	private void heapifyBelow(int indexToHeapify, int endIndex) {
		while (indexToHeapify <= endIndex) {
			int leftChildIndex = findChildIndex(indexToHeapify, true);
			int rightChildIndex = findChildIndex(indexToHeapify, false);
			int indexToSwap;
			// if one itme present then only left item can be present
			if (leftChildIndex <= endIndex) {
				if (rightChildIndex > endIndex) {
					// only left item is present and complete tree prohibiut only single right child
					// with no left child
					indexToSwap = leftChildIndex;
				} else {
					indexToSwap = storage[leftChildIndex] > storage[rightChildIndex] ? leftChildIndex : rightChildIndex;
				}
				if (storage[indexToHeapify] < storage[indexToSwap]) {
					int temp = storage[indexToHeapify];
					storage[indexToHeapify] = storage[indexToSwap];
					storage[indexToSwap] = temp;
				} else {
					break;
				}
				indexToHeapify = indexToSwap;
			} else {
				break;
			}
		}

	}

	private int findParentIndex(int indexToHeapify) {
		return (indexToHeapify - 1) / 2;
	}

	private int findChildIndex(int indexToHeapify, boolean isLeft) {
		return (2 * indexToHeapify) + (isLeft ? 1 : 2);
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void printAll() {
		for (int i = 0; i < index; i++) {
			System.out.print(storage[i]);
			System.out.print(",");
		}
	}
	
	public int size() {
		return index;
	}

}
