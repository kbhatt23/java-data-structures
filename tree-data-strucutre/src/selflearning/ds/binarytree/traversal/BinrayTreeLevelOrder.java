package selflearning.ds.binarytree.traversal;

import java.util.ArrayList;
import java.util.List;

import selflearning.ds.binarytree.BinaryTreeNode;
import selflearning.ds.binarytree.traversal.genericqueue.QueueUsingArrays;

public class BinrayTreeLevelOrder {

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

	public void traverseLevelOrder() {
		if(root == null) {
			throw new RuntimeException("Tree is empty");
		}
		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode queueTop = queue.peekQueue();
			if (queueTop.getLeft() != null) {
				queue.enQueue(queueTop.getLeft());
			}
			if (queueTop.getRight() != null) {
				queue.enQueue(queueTop.getRight());
			}
			BinaryTreeNode queuePrint = queue.deQueue();
			System.out.println("node found " + queuePrint.getValue());
		}
	}

	public BinaryTreeNode searchLevelOrder(int value) {
		if (root == null) {
			throw new RuntimeException("No data present in tree");
		}

		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode queueTop = queue.peekQueue();
			if (queueTop.getLeft() != null) {
				queue.enQueue(queueTop.getLeft());
			}
			if (queueTop.getRight() != null) {
				queue.enQueue(queueTop.getRight());
			}
			BinaryTreeNode deQueue = queue.deQueue();
			if (deQueue.getValue() == value) {
				return deQueue;
			}
		}
		System.out.println("Value " + value + " not present in tree");
		return null;

	}

	public void insert(int value) {
		if (root == null) {
			root = new BinaryTreeNode(value, null, null);
		} else {
			QueueUsingArrays queue = new QueueUsingArrays(18);
			queue.enQueue(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode queueTop = queue.peekQueue();
				if (queueTop.getLeft() == null) {
					// insertion
					queueTop.setLeft(new BinaryTreeNode(value, null, null));
					return;
				}
				if (queueTop.getRight() == null) {
					queueTop.setRight(new BinaryTreeNode(value, null, null));
					return;
				}
				queue.enQueue(queueTop.getLeft());
				queue.enQueue(queueTop.getRight());
				queue.deQueue();
			}
		}
	}

	public void traversePostOrder() {
		traversePostRecursively(root);
	}

	private void traversePostRecursively(BinaryTreeNode node) {
		if (node == null) {
			System.out.println("no item present");
			return;
		}

		traversePostRecursively(node.getLeft());
		traversePostRecursively(node.getRight());
		System.out.println("found node value " + node.getValue());

	}

	public void traversePreOrder() {
		traversePreRecursively(root);
	}

	private void traversePreRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println("found node value " + node.getValue());
		traversePreRecursively(node.getLeft());
		traversePreRecursively(node.getRight());

	}

	public void traverseInOrder() {
		traverseInRecursively(root);
	}

	private void traverseInRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		traverseInRecursively(node.getLeft());
		System.out.println("found node value " + node.getValue());
		traverseInRecursively(node.getRight());

	}
	
	public void deleteNode(int value) {
		if(root == null) {
			throw new RuntimeException("Tree is empty");
		}
		if(root.getValue() == value && root.getLeft() == null && root.getRight() == null) {
			//only one item is present and that is root
			root = null;
		}else {
			List<BinaryTreeNode> deepestNodeData =findDeepestNodeData();
			BinaryTreeNode deepestNode=deepestNodeData.get(deepestNodeData.size()-1);
			BinaryTreeNode searchLevelOrder = searchLevelOrder(value);
			//copy data of deepest node
			searchLevelOrder.setValue(deepestNode.getValue());
			BinaryTreeNode secondDeepestNode=deepestNodeData.get(deepestNodeData.size()-2);
			if(secondDeepestNode.getLeft() == deepestNode) {
				secondDeepestNode.setLeft(null);
			}else if(secondDeepestNode.getRight() == deepestNode) {
				secondDeepestNode.setRight(null);
			}
		}
		
	}

	public List<BinaryTreeNode> findDeepestNodeData(){
		List<BinaryTreeNode> levelTraversalData  = new ArrayList<BinaryTreeNode>();
		QueueUsingArrays queue = new QueueUsingArrays(18);
		queue.enQueue(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode headNode = queue.peekQueue();
			if(headNode.getLeft()!= null) {
				queue.enQueue(headNode.getLeft());
			}
			if(headNode.getRight()!= null) {
				queue.enQueue(headNode.getLeft());
			}
			levelTraversalData.add(queue.deQueue());
		}
		return levelTraversalData;
	}

}
