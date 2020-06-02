package selflearning.ds.binarytree.traversal;

public class BinaryTreeAuto2Test {

	public static void main(String[] args) {
		BinaryTreeInOrder tree = new BinaryTreeInOrder();
		tree.createFullTree();
		tree.traversePreOrder();

		System.out.println("second traversal starts");
		tree.createFullTree1();
		tree.traversePreOrder();
	}
}
