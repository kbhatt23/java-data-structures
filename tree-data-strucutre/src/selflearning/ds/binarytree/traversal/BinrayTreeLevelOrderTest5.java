package selflearning.ds.binarytree.traversal;

public class BinrayTreeLevelOrderTest5 {
public static void main(String[] args) {
	BinrayTreeLevelOrder leveOrder = new BinrayTreeLevelOrder();
	
	leveOrder.insert(10);
	leveOrder.insert(11);
	leveOrder.insert(12);
	leveOrder.insert(13);
	leveOrder.insert(14);
	//leveOrder.traverseLevelOrder();
	leveOrder.findDeepestNodeData().stream().forEach(node -> System.out.println(node.getValue()));
	//leveOrder.deleteNode(10);
	//System.out.println("traversal after delete");
	//leveOrder.traverseLevelOrder();
}
}
