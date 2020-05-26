package selflearning.ds;
//assuming int value only
public class LinkedListNode {

	public LinkedListNode(int value, LinkedListNode next) {
		this.value = value;
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	private int value;
	private LinkedListNode next;
}
