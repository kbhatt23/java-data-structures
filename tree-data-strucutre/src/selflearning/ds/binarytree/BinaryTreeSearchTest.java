package selflearning.ds.binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeSearchTest {

	@Test
	void test() {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		tree.insert(16);
		tree.insert(17);
		tree.insert(18);
		tree.insert(19);
		
		for(int i=10 ; i <20 ; i++) {
			BinaryTreeNode searchItem = tree.searchItem(i);
			assertEquals(i, searchItem.getValue());
		}
	}

}
