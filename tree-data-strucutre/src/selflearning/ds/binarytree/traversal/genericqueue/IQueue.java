package selflearning.ds.binarytree.traversal.genericqueue;

public interface IQueue<T> {

	int size();

	boolean hasCapacity();

	boolean isFull();

	boolean isEmpty();

	T deQueue();

	T peekQueue();

	void enQueue(T value);
	
	void deleteQueue();
}
