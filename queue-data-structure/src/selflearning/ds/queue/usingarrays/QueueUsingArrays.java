package selflearning.ds.queue.usingarrays;

import selflearning.ds.queue.IQueue;

public class QueueUsingArrays implements IQueue {

	private int[] storage;

	private int queueEnd = 0;

	// user defined size
	public QueueUsingArrays(int size) {
		if (size < 1) {
			throw new RuntimeException("queue should have atleast one size");
		}
		storage = new int[size];
	}

	@Override
	public int size() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		return storage.length;
	}

	@Override
	public boolean hasCapacity() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		return !isFull();
	}

	@Override
	public boolean isFull() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		return queueEnd == storage.length;
	}

	@Override
	public boolean isEmpty() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		return queueEnd == 0;
	}

	@Override
	public int deQueue() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		int value = storage[0];
		if (size() > 1) {
			for (int i = 0; i < queueEnd-1; i++) {
				storage[i] = storage[i + 1];
			}
		}
		queueEnd--;
		return value;
	}

	@Override
	public int peekQueue() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		return storage[0];
	}

	@Override
	public void enQueue(int value) {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		if (isFull())
			throw new RuntimeException("Queue is full");
		storage[queueEnd] = value;
		queueEnd++;

	}

	@Override
	public void deleteQueue() {
		if (storage == null)
			throw new RuntimeException("Queue is deleted");
		storage = null;
	}
}
