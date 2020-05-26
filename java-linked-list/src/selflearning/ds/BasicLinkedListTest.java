package selflearning.ds;

public class BasicLinkedListTest {
public static void main(String[] args) {
	LinkedList ls = new LinkedList();
	ls.insert(23);
	ls.insert(32);
	ls.insert(39);
	ls.insert(12);
	ls.insert(33);
	ls.insert(36);
	
	ls.printAllNodes();
	int searchVal =36;
	LinkedListNode searchNode = ls.searchNode(searchVal);
	System.out.println("node found "+searchNode);
	if(searchNode != null) {
		System.out.println("is it valid "+ (searchNode.getValue() ==searchVal ));
	}
}
}
