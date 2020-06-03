package selflearning.ds.binarytsearchtree;

import selflearning.ds.binarytree.BinaryTreeNode;

public class BinarySearchTreeTest2 {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(6);
		tree.insert(7);
		tree.insert(3);
		tree.insert(9);
		tree.insert(4);
		tree.insert(11);
		tree.insert(2);
		tree.insert(8);

		BinaryTreeNode searchNode = tree.searchNode(8);
		if(searchNode == null) {
			System.out.println("no item found");
		}else {
			System.out.println("item found "+searchNode.getValue());
		}
	}
}
