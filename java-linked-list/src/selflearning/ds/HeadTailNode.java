package selflearning.ds;

public class HeadTailNode {
	private LinkedListNode node;
	private RootType type;

	public RootType getType() {
		return type;
	}

	public void setType(RootType type) {
		this.type = type;
	}

	public HeadTailNode(LinkedListNode node, RootType type) {
		this.node = node;
		this.type = type;
	}

	public LinkedListNode getNode() {
		return node;
	}

	public void setNode(LinkedListNode node) {
		this.node = node;
	}

}

