package selflearning.ds.binarytree.traversal;

public class BinaryTreeAuto3Test {

	public static void main(String[] args) {
		BinaryTreePostOrder tree = new BinaryTreePostOrder();
		tree.createFullTree();
		tree.traversePreOrder();

		System.out.println("second traversal starts");
		tree.createFullTree1();
		tree.traversePreOrder();
	}
}
