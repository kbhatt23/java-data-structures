package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreeSearchTest {
	public static void main(String[] args) {
		BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
		int valueToSearch =33;
			System.out.println("Node found "+ " for value "+valueToSearch+ ": "+tree.search(valueToSearch)) ;
	}
}
