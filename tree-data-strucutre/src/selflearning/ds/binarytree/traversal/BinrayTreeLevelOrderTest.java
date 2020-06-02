package selflearning.ds.binarytree.traversal;

public class BinrayTreeLevelOrderTest {
public static void main(String[] args) {
	BinrayTreeLevelOrder leveORder = new BinrayTreeLevelOrder();
	leveORder.createFullTree1();
	leveORder.traverseLevelOrder();
	System.out.println("next wala");
	
	leveORder.createFullTree();
	leveORder.traverseLevelOrder();
}
}
