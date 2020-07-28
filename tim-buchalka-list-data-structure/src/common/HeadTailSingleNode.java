package common;


public class HeadTailSingleNode<T> {
	private RootType type;
	private SingleLinkedListNode<T> node;
	public HeadTailSingleNode(RootType type, SingleLinkedListNode<T> node) {
		this.type = type;
		this.node = node;
	}
	public RootType getType() {
		return type;
	}
	public void setType(RootType type) {
		this.type = type;
	}
	public SingleLinkedListNode<T> getNode() {
		return node;
	}
	public void setNode(SingleLinkedListNode<T> node) {
		this.node = node;
	}
}
