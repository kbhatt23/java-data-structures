package stackds;

public interface IStack<T> {

	int size();

	boolean isEmpty();

	boolean isFull();

	void push(T value);

	T pop();

	T peek();
	//removing it as will be creating resizable array
	//in linked list its always has capacity
	//boolean hasCapacity();

	void deleteStack();

}
