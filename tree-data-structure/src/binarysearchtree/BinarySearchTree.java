package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import common.BinaryTreeNode;

public class BinarySearchTree {
	private BinaryTreeNode root;

	public void insert(int value) {
		BinaryTreeNode node = new BinaryTreeNode(value, null, null);
		if (root == null) {
			root = node;
		} else {
			insertNodeRecursively(root, node);
		}
	}

	private void insertNodeRecursively(BinaryTreeNode parentNode, BinaryTreeNode valueNode) {
		if (valueNode.getValue() < parentNode.getValue()) {
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(valueNode);
			} else {
				insertNodeRecursively(parentNode.getLeft(), valueNode);
			}
		} else if (valueNode.getValue() > parentNode.getValue()) {
			if (parentNode.getRight() == null) {
				parentNode.setRight(valueNode);
			} else {
				insertNodeRecursively(parentNode.getRight(), valueNode);
			}
		}
	}
	
	public void traverseLevelOrder() {
		handleEmptyTree();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			 BinaryTreeNode topNode = queue.peek();
			 System.out.println("traversin node with value "+topNode.getValue());
			 if(topNode.getLeft() != null) {
				 queue.offer(topNode.getLeft());
			 }
			 if(topNode.getRight() != null) {
				 queue.offer(topNode.getRight());
			 }
			 //removing the already found node so that its childs can be tested
			 queue.poll();
		}

	}
	
	public void traverseInOrder() {
		handleEmptyTree();
		traverseInOrderRecursively(root);
	}

	private void traverseInOrderRecursively(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		traverseInOrderRecursively(node.getLeft());
		System.out.println("traversin node with value "+node.getValue());
		traverseInOrderRecursively(node.getRight());
		
	}
	
	public void traversePreOrder() {
		handleEmptyTree();
		traversePreOrderRecursively(root);
	}

	private void traversePreOrderRecursively(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		System.out.println("traversin node with value "+node.getValue());
		traversePreOrderRecursively(node.getLeft());
		traversePreOrderRecursively(node.getRight());
		
	}
	
	public void traversePostOrder() {
		handleEmptyTree();
		traversePostOrderRecursively(root);
	}

	private void traversePostOrderRecursively(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		traversePostOrderRecursively(node.getLeft());
		traversePostOrderRecursively(node.getRight());
		System.out.println("traversin node with value "+node.getValue());
		
	}

	private void handleEmptyTree() {
		if (root == null) {
			throw new RuntimeException("Tree is empty");
		}
	}
	
	public BinaryTreeNode search(int value) {
		handleEmptyTree();
		return searchItemRecursively(value, root);
	}

	private BinaryTreeNode searchItemRecursively(int value, BinaryTreeNode node) {
		if(node == null) {
			return null;
		}
		if(node.getValue() == value) {
			return node;
		}
		if(value > node.getValue()) {
			return searchItemRecursively(value, node.getRight());
		}
		if(value < node.getValue()) {
			return searchItemRecursively(value, node.getLeft());
		}
		return null;
	}
	
	public int findMin() {
		handleEmptyTree();
		BinaryTreeNode node = root;
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getValue();
	}
	
	public int findMax() {
		handleEmptyTree();
		BinaryTreeNode node = root;
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node.getValue();
	}
}
