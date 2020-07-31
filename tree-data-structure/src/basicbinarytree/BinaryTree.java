package basicbinarytree;
//assuming integer only for simplicity

import java.util.LinkedList;
import java.util.Queue;

import common.BinaryTreeNode;

//this is basic binary tree
//a tree whihc will have 2 child nodes at most and values are random unlike binary search tree
public class BinaryTree {

	private BinaryTreeNode root;

	public void insert(int value) {
		BinaryTreeNode node = new BinaryTreeNode(value, null, null);
		if (root == null) {
			root = node;
		} else {
			// could have used our own created queue class but for practise using linkedList
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode topNode = queue.peek();
				if (topNode.getLeft() == null) {
					topNode.setLeft(node);
					return;
				}
				if (topNode.getRight() == null) {
					topNode.setRight(node);
					return;
				}
				// will come here only if both left and right are not null
				queue.offer(topNode.getLeft());
				queue.offer(topNode.getRight());
				// removing the already found node so that its childs can be tested
				queue.poll();
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
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			 BinaryTreeNode topNode = queue.peek();
			 if(topNode.getValue() == value) {
				 return topNode;
			 }
			 if(topNode.getLeft() != null) {
				 queue.offer(topNode.getLeft());
			 }
			 if(topNode.getRight() != null) {
				 queue.offer(topNode.getRight());
			 }
			 //removing the already found node so that its childs can be tested
			 queue.poll();
		}
		return null;
	}
}
