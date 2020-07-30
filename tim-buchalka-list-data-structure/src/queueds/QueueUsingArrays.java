package queueds;

public class QueueUsingArrays<T> implements IQueue<T> {
	private int tailIndex;
	private Object[] storage;
	public QueueUsingArrays(int initialCapactiy){
		storage = new Object[initialCapactiy];
	}
	
	public QueueUsingArrays(){
		//making it 3 just for testing purpose
		storage = new Object[3];
	}
	@Override
	public int size() {
		return tailIndex;
	}

	@Override
	public boolean isFull() {
		return tailIndex == storage.length;
	}

	@Override
	public boolean isEmpty() {
		return tailIndex == 0;
	}

	@Override
	public T deQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		T value = (T) storage[0];
		//shift cells to the left
		for(int i=1; i < storage.length ; i++) {
			storage[i-1] = storage[i];
		}
		tailIndex--;
		return value;
	}

	@Override
	public T peekQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return (T)storage[0];
	}

	@Override
	public void enQueue(T value) {
		if(isFull()) {
			grow();
		}
		storage[tailIndex++] = value;
	}
	
	private void grow() {
		System.out.println("growing exising array");
		// lets move to 10 later on
		Object[] newArray = new Object[storage.length + 2];
		for (int i = 0; i < storage.length; i++) {
			newArray[i] = storage[i];
		}
		storage = newArray;
	}

	@Override
	public void deleteQueue() {
		// TODO Auto-generated method stub
		
	}

}
