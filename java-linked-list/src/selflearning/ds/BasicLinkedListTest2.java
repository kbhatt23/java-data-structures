package selflearning.ds;

public class BasicLinkedListTest2 {
public static void main(String[] args) {
	LinkedList ls = new LinkedList();
	ls.insert(23);
	ls.insert(66);
	ls.insert(99);
	ls.printNodesUsingLoop();
	ls.deleteNode(23);
	ls.insert(33);
	
	ls.printNodesUsingLoop();
}
}
