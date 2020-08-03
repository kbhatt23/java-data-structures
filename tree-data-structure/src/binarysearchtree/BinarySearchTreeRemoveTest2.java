package binarysearchtree;

public class BinarySearchTreeRemoveTest2 {
public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	tree.insert(28);
	tree.insert(24);
	tree.insert(32);
	tree.insert(20);
	tree.insert(26);
	tree.insert(30);
	tree.insert(34);
	tree.insert(19);
	tree.insert(23);
	tree.insert(27);
	tree.insert(31);
	tree.insert(21);
	tree.insert(33);
	tree.removeBalanced(24);
	tree.traverseInOrder();

}
}
