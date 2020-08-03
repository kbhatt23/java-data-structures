package binarysearchtree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
		while (!queue.isEmpty()) {
			BinaryTreeNode topNode = queue.peek();
			System.out.println("traversin node with value " + topNode.getValue());
			if (topNode.getLeft() != null) {
				queue.offer(topNode.getLeft());
			}
			if (topNode.getRight() != null) {
				queue.offer(topNode.getRight());
			}
			// removing the already found node so that its childs can be tested
			queue.poll();
		}

	}

	public void traverseInOrder() {
		handleEmptyTree();
		traverseInOrderRecursively(root);
	}

	private void traverseInOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traverseInOrderRecursively(node.getLeft());
		System.out.println("traversin node with value " + node.getValue());
		traverseInOrderRecursively(node.getRight());

	}

	public void traversePreOrder() {
		handleEmptyTree();
		traversePreOrderRecursively(root);
	}

	private void traversePreOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println("traversin node with value " + node.getValue());
		traversePreOrderRecursively(node.getLeft());
		traversePreOrderRecursively(node.getRight());

	}

	public void traversePostOrder() {
		handleEmptyTree();
		traversePostOrderRecursively(root);
	}

	private void traversePostOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traversePostOrderRecursively(node.getLeft());
		traversePostOrderRecursively(node.getRight());
		System.out.println("traversin node with value " + node.getValue());

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
		if (node == null) {
			return null;
		}
		if (node.getValue() == value) {
			return node;
		}
		if (value > node.getValue()) {
			return searchItemRecursively(value, node.getRight());
		}
		if (value < node.getValue()) {
			return searchItemRecursively(value, node.getLeft());
		}
		return null;
	}

	public int findMin() {
		handleEmptyTree();
		BinaryTreeNode node = root;
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getValue();
	}

	public int findMax() {
		handleEmptyTree();
		BinaryTreeNode node = root;
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node.getValue();
	}
	
	private BinaryTreeNode findMinNode(BinaryTreeNode  node) {
		handleEmptyTree();
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	private BinaryTreeNode findMaxNode(BinaryTreeNode  node) {
		handleEmptyTree();
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}

	public void remove(int value) {
		handleEmptyTree();
		if (value == root.getValue()) {
			// need to remove at the root
			//first check if child is only one
			if(root.getLeft() != null && root.getRight()==null) {
				root = root.getLeft();
			}
			else if(root.getLeft() == null && root.getRight()!=null) {
				root = root.getRight();
			}else if(root.getLeft() == null && root.getRight()==null) {
				//then check if child is empty
				root=null;
			}else {
				//root have two child
				BinaryTreeNode nodeToMerge = root.getRight();
				BinaryTreeNode nodeToReplace = root.getLeft();
				BinaryTreeNode nodeToInsert = nodeToReplace;
				while(nodeToInsert.getRight() != null) {
					nodeToInsert = nodeToInsert.getRight();
				}
				nodeToInsert.setRight(nodeToMerge);
				root = nodeToReplace;
			}
		} else {
			List<BinaryTreeNode> currentAndPreviousNodes = searchNodeAndPreviousNode(value);
			if(currentAndPreviousNodes == null) {
				throw new RuntimeException("Node not found with value "+value);
			}
			BinaryTreeNode currentNode = currentAndPreviousNodes.get(0);
			BinaryTreeNode parentNode = currentAndPreviousNodes.get(1);
			//condition when there is only one child
			if(currentNode.getLeft() != null && currentNode.getRight() == null) {
				updateParentNode(currentNode, parentNode, currentNode.getLeft());
			}else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
				updateParentNode(currentNode, parentNode, currentNode.getRight());
			}else if(currentNode.getLeft() == null && currentNode.getRight() == null) {
				//no child node -> leaf node
				updateParentNode(currentNode, parentNode, null);
			}
			else {
				//when there are two childern of node
				if(currentNode.getValue() < parentNode.getValue()) {
					BinaryTreeNode nodeToReplace = currentNode.getLeft();
					BinaryTreeNode nodeToMerge = currentNode.getRight();
					BinaryTreeNode nodeToInsert = nodeToReplace;
					while(nodeToInsert.getRight() != null) {
						nodeToInsert = nodeToInsert.getRight();
					}
					nodeToInsert.setRight(nodeToMerge);
					parentNode.setLeft(nodeToReplace);
				}
				else if(currentNode.getValue() > parentNode.getValue()) {
					BinaryTreeNode nodeToReplace = currentNode.getRight();
					BinaryTreeNode nodeToMerge = currentNode.getLeft();
					BinaryTreeNode nodeToInsert = nodeToReplace;
					while(nodeToInsert.getLeft() != null) {
						nodeToInsert = nodeToInsert.getLeft();
					}
					nodeToInsert.setLeft(nodeToMerge);
					parentNode.setRight(nodeToReplace);
					
				}
			}
		}
	}
	
	public void removeBalanced(int value) {
		handleEmptyTree();
		if (value == root.getValue()) {
			// need to remove at the root
			//first check if child is only one
			if(root.getLeft() != null && root.getRight()==null) {
				root = root.getLeft();
			}
			else if(root.getLeft() == null && root.getRight()!=null) {
				root = root.getRight();
			}else if(root.getLeft() == null && root.getRight()==null) {
				//then check if child is empty
				root=null;
			}else {
				//root have two child
				BinaryTreeNode nodeToMerge = root.getRight();
				BinaryTreeNode nodeToReplace = root.getLeft();
				BinaryTreeNode nodeToInsert = nodeToReplace;
				while(nodeToInsert.getRight() != null) {
					nodeToInsert = nodeToInsert.getRight();
				}
				nodeToInsert.setRight(nodeToMerge);
				root = nodeToReplace;
			}
		} else {
			List<BinaryTreeNode> currentAndPreviousNodes = searchNodeAndPreviousNode(value);
			if(currentAndPreviousNodes == null) {
				throw new RuntimeException("Node not found with value "+value);
			}
			BinaryTreeNode currentNode = currentAndPreviousNodes.get(0);
			BinaryTreeNode parentNode = currentAndPreviousNodes.get(1);
			//condition when there is only one child
			if(currentNode.getLeft() != null && currentNode.getRight() == null) {
				updateParentNode(currentNode, parentNode, currentNode.getLeft());
			}else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
				updateParentNode(currentNode, parentNode, currentNode.getRight());
			}else if(currentNode.getLeft() == null && currentNode.getRight() == null) {
				//no child node -> leaf node
				updateParentNode(currentNode, parentNode, null);
			}
			else {
				//when there are two childern of node
				if(currentNode.getValue() < parentNode.getValue()) {
					BinaryTreeNode nodeToReplace = currentNode.getLeft();
					BinaryTreeNode replacerNode = findMaxNode(nodeToReplace);
					BinaryTreeNode replacerPreviousNode = searchNodeAndPreviousNode(replacerNode.getValue()).get(1);
					if(replacerPreviousNode.getValue() > replacerNode.getValue()) {
						replacerPreviousNode.setLeft(replacerNode.getLeft());
					}else {
						replacerPreviousNode.setRight(replacerNode.getLeft());
					}
					currentNode.setValue(replacerNode.getValue());
				}
				else if(currentNode.getValue() > parentNode.getValue()) {
					BinaryTreeNode nodeToReplace = currentNode.getRight();
					BinaryTreeNode replacerNode = findMinNode(nodeToReplace);
					BinaryTreeNode replacerPreviousNode = searchNodeAndPreviousNode(replacerNode.getValue()).get(1);
					if(replacerPreviousNode.getValue() > replacerNode.getValue()) {
						replacerPreviousNode.setLeft(replacerNode.getRight());
					}else {
						replacerPreviousNode.setRight(replacerNode.getRight());
					}
					currentNode.setValue(replacerNode.getValue());
				}
			}
		}
	}

	private void updateParentNode(BinaryTreeNode currentNode, BinaryTreeNode parentNode, BinaryTreeNode newNode) {
		if(currentNode.getValue() < parentNode.getValue()) {
			parentNode.setLeft(newNode);
		}else {
			parentNode.setRight(newNode);
		}
	}

	public List<BinaryTreeNode> searchNodeAndPreviousNode(int value) {
		handleEmptyTree();
		return searchItemsRecursively(value, root, null);
	}

	private List<BinaryTreeNode> searchItemsRecursively(int value, BinaryTreeNode currentNode,
			BinaryTreeNode previousNode) {
		if (currentNode == null) {
			return null;
		}
		if (currentNode.getValue() == value) {
			return Arrays.asList(currentNode, previousNode);
		}
		if (value > currentNode.getValue()) {
			return searchItemsRecursively(value, currentNode.getRight(), currentNode);
		}
		if (value < currentNode.getValue()) {
			return searchItemsRecursively(value, currentNode.getLeft(), currentNode);
		}
		return null;
	}
}
