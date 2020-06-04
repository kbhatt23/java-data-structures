package selflearning.hashing.usinglinkedlist;

public class HashTableNode {
	//assuming string as value
	private String value;
	private HashTableNode next;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public HashTableNode getNext() {
		return next;
	}
	public void setNext(HashTableNode next) {
		this.next = next;
	}
	public HashTableNode(String value, HashTableNode next) {
		super();
		this.value = value;
		this.next = next;
	}
}
