package selfllearning.ds.stack.usinglinkedlist.headonly;

public class SingleLinkedListNode {
	
	private int value;
	private SingleLinkedListNode next;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public SingleLinkedListNode getNext() {
		return next;
	}
	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}
	public SingleLinkedListNode(int value, SingleLinkedListNode next) {
		super();
		this.value = value;
		this.next = next;
	}
}
