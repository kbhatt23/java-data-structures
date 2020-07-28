package common;

public class DoubleLinkedListNode<T> {
	private T value;
	private DoubleLinkedListNode<T> next;
	private DoubleLinkedListNode<T> previous;
	public DoubleLinkedListNode(T value, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public DoubleLinkedListNode<T> getNext() {
		return next;
	}
	public void setNext(DoubleLinkedListNode<T> next) {
		this.next = next;
	}
	public DoubleLinkedListNode<T> getPrevious() {
		return previous;
	}
	public void setPrevious(DoubleLinkedListNode<T> previous) {
		this.previous = previous;
	}
}
