package selflearning.ds.binarytree.traversal;

public class BinaryTreeAuto1Test {

	public static void main(String[] args) {
		BinaryTreePreOrder tree = new BinaryTreePreOrder();
		tree.createFullTree();
		tree.traversePreOrder();

		System.out.println("second traversal starts");
		tree.createFullTree1();
		tree.traversePreOrder();
	}
}
