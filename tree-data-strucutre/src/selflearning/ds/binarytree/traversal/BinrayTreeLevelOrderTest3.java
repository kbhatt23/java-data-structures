package selflearning.ds.binarytree.traversal;

import selflearning.ds.binarytree.BinaryTreeNode;

public class BinrayTreeLevelOrderTest3 {
public static void main(String[] args) {
	BinrayTreeLevelOrder leveOrder = new BinrayTreeLevelOrder();
	
	leveOrder.insert(10);
	leveOrder.insert(11);
	leveOrder.insert(12);
	leveOrder.insert(13);
	leveOrder.insert(14);
	leveOrder.insert(15);
	leveOrder.insert(16);
	leveOrder.insert(17);
	leveOrder.insert(18);
	leveOrder.traverseLevelOrder();
}
}
