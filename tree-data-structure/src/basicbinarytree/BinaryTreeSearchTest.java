package basicbinarytree;

import util.TreeUtil;

public class BinaryTreeSearchTest {
public static void main(String[] args) {
	BinaryTree tree = TreeUtil.createAndInsertBinaryTree();
	int numberToSearch = 13;
	System.out.println("Searching number "+numberToSearch + " in tree "+tree.search(numberToSearch));
}
}
