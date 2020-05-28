package selflearning.ds;

public class InsertLocationLinkedListTest {
public static void main(String[] args) {
	LinkedList ls = new LinkedList();
	ls.insert(23);
	ls.insert(32);
	ls.insert(39);
	ls.insert(12);
	ls.insert(33);
	ls.insert(36);
	System.out.println("initial nodes");
	ls.printAllNodes();
	ls.insertAtLocation(11, 2);
	ls.insertAtLocation(1, 0);
	ls.insertAtLocation(99, -1);
	ls.deleteNode(11);
	ls.deleteNode(99);
	ls.deleteNode(1);
	System.out.println("nodes after insertion");
	ls.printAllNodes();
	
}
}
