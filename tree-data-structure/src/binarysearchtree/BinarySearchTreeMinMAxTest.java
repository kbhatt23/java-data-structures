package binarysearchtree;

import util.TreeUtil;

public class BinarySearchTreeMinMAxTest {
public static void main(String[] args) {
	BinarySearchTree tree = TreeUtil.createAndInsertBinarySearchTree();
	System.out.println("min value is "+tree.findMin()+ " and max value is "+tree.findMax());
	System.out.println("printing all nodes in in order");
	tree.traverseInOrder();
}
}
