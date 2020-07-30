package queueds;

public interface IQueue<T> {

	int size();

	// no need as we will grow the array
	// boolean hasCapacity();

	//will be used to identify if we need to grow the array
	boolean isFull();

	boolean isEmpty();

	T deQueue();

	T peekQueue();

	void enQueue(T value);

	void deleteQueue();
}
