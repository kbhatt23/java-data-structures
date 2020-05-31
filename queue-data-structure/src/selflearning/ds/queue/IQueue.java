package selflearning.ds.queue;

public interface IQueue {

	int size();

	boolean hasCapacity();

	boolean isFull();

	boolean isEmpty();

	int deQueue();

	int peekQueue();

	void enQueue(int value);
	
	void deleteQueue();
}
