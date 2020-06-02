package selflearning.ds.binarytree.traversal;

import selflearning.ds.binarytree.BinaryTreeNode;

public class BinrayTreeLevelOrderTest2 {
public static void main(String[] args) {
	BinrayTreeLevelOrder leveORder = new BinrayTreeLevelOrder();
	
	leveORder.createFullTree();
	BinaryTreeNode searchLevelOrder = leveORder.searchLevelOrder(6);
	if(searchLevelOrder == null) {
		System.out.println("item not found");
	}else {
		System.out.println("item found with value "+searchLevelOrder.getValue());
	}
}
}
