package basicbinarytree;

import util.TreeUtil;

public class BinaryTreeInOrderTest {
public static void main(String[] args) {
	BinaryTree tree = TreeUtil.createAndInsertBinaryTree();
	tree.traverseInOrder();
}
}
