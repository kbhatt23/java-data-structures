package common;

public class SingleLinkedListNode<T> {

	private T value;
	private SingleLinkedListNode<T> next;

	public SingleLinkedListNode(T value, SingleLinkedListNode<T> next) {
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SingleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode<T> next) {
		this.next = next;
	}
}
