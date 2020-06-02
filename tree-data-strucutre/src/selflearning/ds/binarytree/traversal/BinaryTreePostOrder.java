package selflearning.ds.binarytree.traversal;

import selflearning.ds.binarytree.BinaryTreeNode;

public class BinaryTreePostOrder {

	private BinaryTreeNode root;

	// simulating the whole tree creation
	// so that we can focus on traversal logic
	public void createFullTree() {
		BinaryTreeNode rootLeft9 = new BinaryTreeNode(66, null, null);
		BinaryTreeNode riitRight9 = new BinaryTreeNode(26, null, null);
		BinaryTreeNode rootLeft91 = new BinaryTreeNode(99, null, null);
		BinaryTreeNode right1 = new BinaryTreeNode(28, null, null);

		BinaryTreeNode rootLeft1 = new BinaryTreeNode(13, rootLeft9, null);

		BinaryTreeNode rootLeft = new BinaryTreeNode(4, rootLeft1, riitRight9);
		BinaryTreeNode rootRight = new BinaryTreeNode(6, rootLeft91, right1);
		root = new BinaryTreeNode(99, rootLeft, rootRight);
	}

	public void createFullTree1() {
		BinaryTreeNode rootLeft9 = new BinaryTreeNode(222, null, null);
		BinaryTreeNode riitRight9 = new BinaryTreeNode(15, null, null);
		BinaryTreeNode rootLeft91 = new BinaryTreeNode(250, null, null);
		BinaryTreeNode right1 = new BinaryTreeNode(35, null, null);

		BinaryTreeNode rootLeft1 = new BinaryTreeNode(50, rootLeft9, null);

		BinaryTreeNode rootLeft = new BinaryTreeNode(100, rootLeft1, riitRight9);
		BinaryTreeNode rootRight = new BinaryTreeNode(3, rootLeft91, right1);
		root = new BinaryTreeNode(20, rootLeft, rootRight);
	}

	public void traversePreOrder() {
		traverseRecursively(root);
	}

	private void traverseRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		
		traverseRecursively(node.getLeft());
		traverseRecursively(node.getRight());
		System.out.println("found node value " + node.getValue());
		
	}
}
