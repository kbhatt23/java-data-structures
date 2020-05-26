package selflearning.binarysearchtree;

public class BalancedTree {

	TreeNode rootNode;

	// minimum requirement is root node
	public BalancedTree(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	// as of now implemented to one level only
	// insertion also needs recursion
	public void addItem(int value) {
		insertNode(value, rootNode);
	}

	private void insertNode(int value, TreeNode currentNode) {
		if (value > currentNode.getValue()) {
			if (currentNode.getRightNode() != null) {
				insertNode(value, currentNode.getRightNode());
			} else {
				TreeNode node = new TreeNode();
				node.setValue(value);
				currentNode.setRightNode(node);
			}

		} else if (value < currentNode.getValue()) {
			if (currentNode.getLeftNode() != null) {
				insertNode(value, currentNode.getLeftNode());
			} else {
				TreeNode node = new TreeNode();
				node.setValue(value);
				currentNode.setLeftNode(node);
			}

		} else {
			throw new RuntimeException("node not supported");
		}
	}

	private TreeNode findNodeRecursively(int value, TreeNode currentNode) {
		if (currentNode.getValue() == value) {
			return currentNode;
		}
		if (value > currentNode.getValue()) {
			return findNodeRecursively(value, currentNode.getRightNode());
		} else {
			return findNodeRecursively(value, currentNode.getLeftNode());
		}
	}

	public TreeNode findNode(int value) {
		return findNodeRecursively(value, rootNode);
	}
}
