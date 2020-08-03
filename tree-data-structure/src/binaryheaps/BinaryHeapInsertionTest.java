package binaryheaps;

public class BinaryHeapInsertionTest {

	public static void main(String[] args) {
		BinaryHeap heap = new BinaryHeap(7);
		heap.insert(23);
		heap.insert(33);
		heap.insert(24);
		heap.insert(19);
		heap.insert(6);
		heap.insert(15);
		heap.insert(66);
		heap.printAll();
		heap.delete(24);
		System.out.println("after delete");
		heap.printAll();
	}

}
