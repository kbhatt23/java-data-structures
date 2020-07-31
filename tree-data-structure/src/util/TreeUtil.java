package util;

import basicbinarytree.BinaryTree;
import binarysearchtree.BinarySearchTree;

public class TreeUtil {

	public static BinaryTree createAndInsertBinaryTree() {
		BinaryTree tree = new BinaryTree();
		tree.insert(1);
		tree.insert(7);
		tree.insert(8);
		tree.insert(13);
		tree.insert(15);
		tree.insert(17);
		tree.insert(19);
		tree.insert(20);
		return tree;
	}
	public static BinarySearchTree createAndInsertBinarySearchTree() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(33);
		tree.insert(23);
		tree.insert(66);
		tree.insert(19);
		tree.insert(17);
		tree.insert(27);
		tree.insert(30);
		tree.insert(29);
		return tree;
	}
}
