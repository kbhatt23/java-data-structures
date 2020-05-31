package selflearning.ds.queue.usingLinkedlist;

public class HeadTailNode {

	private DoubleLinkedListNode node;
	private RootType type;

	public HeadTailNode(DoubleLinkedListNode node, RootType type) {
		this.node = node;
		this.type = type;
	}

	public DoubleLinkedListNode getNode() {
		return node;
	}

	public void setNode(DoubleLinkedListNode node) {
		this.node = node;
	}

	public RootType getType() {
		return type;
	}

	public void setType(RootType type) {
		this.type = type;
	}
}
