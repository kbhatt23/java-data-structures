package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreeTest {
public static void main(String[] args) {
	BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
	tree.traverseInOrder();
}
}
