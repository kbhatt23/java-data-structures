package selfllearning.ds.stack.usinglinkedlist.headonly;

public class HeadTailNode {

	private SingleLinkedListNode node;
	private RootType type;

	public HeadTailNode(SingleLinkedListNode node, RootType type) {
		this.node = node;
		this.type = type;
	}

	public SingleLinkedListNode getNode() {
		return node;
	}

	public void setNode(SingleLinkedListNode node) {
		this.node = node;
	}

	public RootType getType() {
		return type;
	}

	public void setType(RootType type) {
		this.type = type;
	}
}
