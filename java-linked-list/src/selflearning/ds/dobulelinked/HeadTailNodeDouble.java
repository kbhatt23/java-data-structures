package selflearning.ds.dobulelinked;

import selflearning.ds.RootType;

public class HeadTailNodeDouble {
	private LinkedListNodeDouble node;
	private RootType type;

	public RootType getType() {
		return type;
	}

	public void setType(RootType type) {
		this.type = type;
	}

	public HeadTailNodeDouble(LinkedListNodeDouble node, RootType type) {
		this.node = node;
		this.type = type;
	}

	public LinkedListNodeDouble getNode() {
		return node;
	}

	public void setNode(LinkedListNodeDouble node) {
		this.node = node;
	}

}

