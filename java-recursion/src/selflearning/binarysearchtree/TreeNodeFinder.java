package selflearning.binarysearchtree;

public class TreeNodeFinder {
public static void main(String[] args) {
	//one level inserter only
	TreeNode rootNode = new TreeNode();
	rootNode.setValue(7);
	BalancedTree tree = new BalancedTree(rootNode);
	tree.addItem(5);
	tree.addItem(11);
	tree.addItem(6);
	tree.addItem(9);
	tree.addItem(3);
	tree.addItem(10);
	tree.addItem(20);
	
	System.out.println(tree.findNode(10));
}
}
