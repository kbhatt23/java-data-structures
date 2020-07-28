package common;


public class HeadTailDoubleNode<T> {
	private RootType type;
	private DoubleLinkedListNode<T> node;
	public HeadTailDoubleNode(RootType type, DoubleLinkedListNode<T> node) {
		this.type = type;
		this.node = node;
	}
	public RootType getType() {
		return type;
	}
	public void setType(RootType type) {
		this.type = type;
	}
	public DoubleLinkedListNode<T> getNode() {
		return node;
	}
	public void setNode(DoubleLinkedListNode<T> node) {
		this.node = node;
	}
}
