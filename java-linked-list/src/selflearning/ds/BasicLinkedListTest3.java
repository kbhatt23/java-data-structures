package selflearning.ds;

public class BasicLinkedListTest3 {
public static void main(String[] args) {
	LinkedList ls = new LinkedList();
	ls.insert(23);
	ls.insert(66);
	ls.insert(99);
	System.out.println("printing in normal order ");
	ls.printNodesUsingLoop();
	System.out.println("printing in reverse order ");
	ls.printReverse();
	ls.deleteNode(23);
	ls.insert(33);
	
	System.out.println("printing in normal order ");
	ls.printNodesUsingLoop();
	System.out.println("printing in reverse order ");
	ls.printReverse();
}
}
