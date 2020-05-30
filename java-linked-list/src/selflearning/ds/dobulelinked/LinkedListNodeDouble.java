package selflearning.ds.dobulelinked;

public class LinkedListNodeDouble {

	private int value;
	private LinkedListNodeDouble next;
	private LinkedListNodeDouble previous;

	public LinkedListNodeDouble(int value, LinkedListNodeDouble next, LinkedListNodeDouble previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedListNodeDouble getNext() {
		return next;
	}

	public void setNext(LinkedListNodeDouble next) {
		this.next = next;
	}

	public LinkedListNodeDouble getPrevious() {
		return previous;
	}

	public void setPrevious(LinkedListNodeDouble previous) {
		this.previous = previous;
	}
}
