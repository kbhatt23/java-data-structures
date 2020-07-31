package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreeInOrderTest {
public static void main(String[] args) {
	BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
	tree.traverseLevelOrder();
}
}
