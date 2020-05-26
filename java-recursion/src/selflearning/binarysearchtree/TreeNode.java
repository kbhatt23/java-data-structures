package selflearning.binarysearchtree;

//could have made generic using generics
public class TreeNode {

	private int value;
	// set less node
	private TreeNode leftNode;
	// set greater node
	private TreeNode rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

}
