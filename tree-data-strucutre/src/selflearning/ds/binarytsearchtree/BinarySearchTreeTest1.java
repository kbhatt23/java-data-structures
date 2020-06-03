package selflearning.ds.binarytsearchtree;

public class BinarySearchTreeTest1 {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(6);
		tree.insert(7);
		tree.insert(3);
		tree.insert(9);
		tree.insert(4);
		tree.insert(11);
		tree.insert(2);
		tree.insert(8);
		
		tree.traverseInOrder();
	}
}
