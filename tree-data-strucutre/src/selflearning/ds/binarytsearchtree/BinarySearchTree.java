package selflearning.ds.binarytsearchtree;

import selflearning.ds.binarytree.BinaryTreeNode;

public class BinarySearchTree {

	private BinaryTreeNode root;

	// insert
	public void insert(int value) {
		if (root == null) {
			// first time insertion
			root = new BinaryTreeNode(value, null, null);
		} else {
			insertNodeRecursively(value, root);
		}
	}

	private void insertNodeRecursively(int value, BinaryTreeNode node) {
		if (value <= node.getValue()) {
			// no node exist on left
			if (node.getLeft() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(value, null, null);
				node.setLeft(newNode);
			} else {
				insertNodeRecursively(value, node.getLeft());
			}
		} else {
			// greater than case
			if (node.getRight() == null) {
				BinaryTreeNode newNode = new BinaryTreeNode(value, null, null);
				node.setRight(newNode);
			} else {
				insertNodeRecursively(value, node.getRight());
			}
		}

	}

	public void traverseInOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traerseInOrderRecursively(root);
	}

	private void traerseInOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traerseInOrderRecursively(node.getLeft());
		System.out.println("node value found " + node.getValue());
		traerseInOrderRecursively(node.getRight());
	}

	public BinaryTreeNode searchNode(int value) {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		return searchNodeRecursively(root, value);
	}

	private BinaryTreeNode searchNodeRecursively(BinaryTreeNode node, int value) {
		if (node.getValue() == value) {
			return node;
		}
		if (value <= node.getValue()) {
			if (node.getLeft() == null) {
				return null;
			} else {
				return searchNodeRecursively(node.getLeft(), value);
			}
		} else if (value > node.getValue()) {
			if (node.getRight() == null) {
				return null;
			} else {
				return searchNodeRecursively(node.getRight(), value);
			}
		}
		return null;
	}

	public void deleteTree() {
		root = null;
	}
}
