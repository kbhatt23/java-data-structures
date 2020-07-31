package basicbinarytree;

import util.TreeUtil;

public class BinaryTreeLevelOrderTest {
public static void main(String[] args) {
	BinaryTree tree = TreeUtil.createAndInsertBinaryTree();
	tree.traverseInOrder();
}
}
