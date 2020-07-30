package stackds;

import java.util.Iterator;
import java.util.LinkedList;

public class StackUsingJDK<T> implements IStack<T> {
	//lets use Linked LIst -> double linked list having list and Deque both implementations
	//this is suggested as stacke extends vector and menthods are synchronized and hence we shud use deque implementation
	//eg: ArrayDeque same like linked list but it uses array and implement deque -> O(n) in case of push
	
	private LinkedList<T> storage = new LinkedList<>();
	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}

	@Override
	public boolean isFull() {
		//never full
		return false;
	}

	@Override
	public void push(T value) {
		storage.push(value);
	}

	@Override
	public T pop() {
		return storage.pop();
	}

	@Override
	public T peek() {
		return storage.peek();
	}

	@Override
	public void deleteStack() {
		storage = null;
	}
	
	public void printAllItems() {
		Iterator<T> iterator = storage.iterator();
		while(iterator != null && iterator.hasNext()) {
			System.out.println("popping out item "+iterator.next());
		}
	}

}
