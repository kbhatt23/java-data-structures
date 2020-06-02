package selflearning.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.FindProperty;
import selflearning.ds.binarytree.traversal.genericqueue.QueueUsingArrays;

public class BinaryTree {

	private BinaryTreeNode root;

	public void insert(int value) {
		BinaryTreeNode newNode = new BinaryTreeNode(value, null, null);
		if (root == null) {
			// no data present at all
			root = newNode;
		} else {
			QueueUsingArrays queue = new QueueUsingArrays(18);
			queue.enQueue(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode queueTop = queue.peekQueue();
				if (queueTop.getLeft() == null) {
					queueTop.setLeft(newNode);
					return;
				}
				if (queueTop.getRight() == null) {
					queueTop.setRight(newNode);
					return;
				}
				queue.enQueue(queueTop.getLeft());
				queue.enQueue(queueTop.getRight());
				// so that next elemtn is picked up
				queue.deQueue();
			}
		}
	}

	public void traverseLevelOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode queueHead = queue.peekQueue();
			if (queueHead.getLeft() != null) {
				queue.enQueue(queueHead.getLeft());
			}
			if (queueHead.getRight() != null) {
				queue.enQueue(queueHead.getRight());
			}
			System.out.println("Node found with value " + queue.deQueue().getValue());
		}
	}

	public void traversePreOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traversePreOrderRecursively(root);
	}

	private void traversePreOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println("Node found with value " + node.getValue());
		traversePreOrderRecursively(node.getLeft());
		traversePreOrderRecursively(node.getRight());

	}

	public void traverseInOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traverseInOrderRecursively(root);
	}

	private void traverseInOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traverseInOrderRecursively(node.getLeft());
		System.out.println("Node found with value " + node.getValue());
		traverseInOrderRecursively(node.getRight());

	}

	public void traversePostOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traversePostOrderRecursively(root);
	}

	private void traversePostOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traversePostOrderRecursively(node.getLeft());
		traversePostOrderRecursively(node.getRight());
		System.out.println("Node found with value " + node.getValue());
	}

	public BinaryTreeNode searchItem(int value) {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode headQueue = queue.peekQueue();
			if (headQueue.getValue() == value) {
				// first found node is returned and others are ignored
				return headQueue;
			}
			if (headQueue.getLeft() != null) {
				queue.enQueue(headQueue.getLeft());
			}
			if (headQueue.getRight() != null) {
				queue.enQueue(headQueue.getRight());
			}
			queue.deQueue();
		}
		throw new RuntimeException("Value " + value + " not present in tree");
	}

	public void deleteNode(int value) {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		if (value == root.getValue() && root.getLeft() == null && root.getRight() == null) {
			//as only one tiem is present lets save loop
			root = null;
		}else {
			//more than one item present
			List<BinaryTreeNode> populateDeepestNodeData = populateDeepestNodeData();
			BinaryTreeNode deepestNode = populateDeepestNodeData.get(populateDeepestNodeData.size()-1);
			BinaryTreeNode secondDeepest = populateDeepestNodeData.get(populateDeepestNodeData.size()-2);
			BinaryTreeNode actualNodetoDelete = searchItem(value);
			actualNodetoDelete.setValue(deepestNode.getValue());
			if(secondDeepest.getLeft()==deepestNode) {
				secondDeepest.setLeft(null);
			}else if(secondDeepest.getRight() == deepestNode) {
				secondDeepest.setRight(null);
			}
		}
	}
	
	private List<BinaryTreeNode> populateDeepestNodeData() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		BinaryTreeNode deepestNode = null;
		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		List<BinaryTreeNode> items = new ArrayList<BinaryTreeNode>();
		while (!queue.isEmpty()) {
			BinaryTreeNode queueHead = queue.peekQueue();
			if (queueHead.getLeft() != null) {
				queue.enQueue(queueHead.getLeft());
			}
			if (queueHead.getRight() != null) {
				queue.enQueue(queueHead.getRight());
			}
			deepestNode=queue.deQueue();
			items.add(deepestNode);

		}
		return items;
	}

}
