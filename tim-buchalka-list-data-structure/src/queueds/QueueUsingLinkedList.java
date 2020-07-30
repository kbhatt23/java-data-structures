package queueds;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingLinkedList<T> implements IQueue<T> {
	private Deque<T> storage = new LinkedList<T>();
	@Override
	public int size() {
		return storage.size();
	}

	//linked list never full
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}

	@Override
	public T deQueue() {
		return storage.poll();
	}

	@Override
	public T peekQueue() {
		return storage.peek();
	}

	@Override
	public void enQueue(T value) {

		storage.offer(value);
	}

	@Override
	public void deleteQueue() {
		storage.clear();
	}

}
