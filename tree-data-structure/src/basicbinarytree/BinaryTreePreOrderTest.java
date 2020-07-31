package basicbinarytree;

import util.TreeUtil;

public class BinaryTreePreOrderTest {
public static void main(String[] args) {
	BinaryTree tree = TreeUtil.createAndInsertBinaryTree();
	tree.traversePreOrder();
}
}
