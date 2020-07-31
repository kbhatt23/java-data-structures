package basicbinarytree;

import util.TreeUtil;

public class BinaryTreePostOrderTest {
public static void main(String[] args) {
	BinaryTree tree = TreeUtil.createAndInsertBinaryTree();
	tree.traversePostOrder();
}
}
