package selfllearning.ds.stack;

//common interfce that has to be impletmented by array or linkedlist imlplementation both
//assuming int values only
public interface Istack {

	int size();

	boolean isEmpty();

	boolean isFull();

	void push(int value);

	int pop();

	int peek();
	
	boolean hasCapacity();
	
	void deleteStack();

}
