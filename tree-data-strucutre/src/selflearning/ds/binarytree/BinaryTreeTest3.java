package selflearning.ds.binarytree;

public class BinaryTreeTest3 {
public static void main(String[] args) {
	BinaryTree tree = new BinaryTree();
	tree.insert(10);
	tree.insert(11);
	tree.insert(12);
	tree.insert(13);
		/*
		 * tree.insert(12); tree.insert(13); tree.insert(14); tree.insert(15);
		 * tree.insert(16); tree.insert(17); tree.insert(18); tree.insert(19);
		 */
	//root node deletion
	tree.deleteNode(10);
	tree.traverseInOrder();
	//tree.traversePostOrder();
}

}
