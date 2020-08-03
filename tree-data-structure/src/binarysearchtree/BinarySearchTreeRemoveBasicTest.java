package binarysearchtree;

public class BinarySearchTreeRemoveBasicTest {
public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	tree.insert(23);
	tree.insert(14);
	tree.insert(15);
	tree.insert(12);
	tree.insert(28);
	tree.insert(32);
	tree.remove(32);
	tree.traverseInOrder();
}

}
