package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreePreOrderTest {
public static void main(String[] args) {
	BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
	tree.traversePreOrder();
}
}
