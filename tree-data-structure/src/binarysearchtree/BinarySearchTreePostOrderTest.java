package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreePostOrderTest {
public static void main(String[] args) {
	BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
	tree.traversePostOrder();
}
}
